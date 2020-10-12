package controller;

import com.mysql.cj.Session;
import model.*;
import service.CategoryService;
import service.ProductService;
import service.PurchaseService;
import service.SupplierService;
import service.impl.CategoryImpl;
import service.impl.ProductImpl;
import service.impl.PurchaseImpl;
import service.impl.SupplierImpl;
import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/purchase.do")
public class PurchaseServlet extends HttpServlet {
          PurchaseService service=new PurchaseImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (Constant.ADD.equals(action)){
            add(request,response);
        }else if (Constant.SHOW.equals(action)){
            show(request,response);
        }else if (Constant.SELECT_FUZZY.equals(action)){
            fuzzy(request,response);
        }else if (Constant.INSERT.equals(action)){
            insert(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService=new CategoryImpl();
        List<Category> categoryList=categoryService.listQuery();
        SupplierService supplierService=new SupplierImpl();
        List<Supplier> supplierList=supplierService.listQuery();
        request.setAttribute("category",categoryList);
        request.setAttribute("supplier",supplierList);
        request.getRequestDispatcher("/view/purchase/purchase_input.jsp").forward(request,response);
    }
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list=service.show();
        request.setAttribute("product",list);
        request.getRequestDispatcher("/view/purchase/purchase_list.jsp").forward(request,response);
    }
    public void fuzzy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String kw=request.getParameter("kw");
        byte[] bytes=kw.getBytes("ISO-8859-1");
        String kww=new String(bytes,"utf-8");
        List<Product> list=service.fuzzyQuery(kww);
        request.setAttribute("product",list);
        request.getRequestDispatcher("/view/purchase/purchase_list.jsp").forward(request,response);
    }
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String barCode=request.getParameter("barCode");
        String productName1=request.getParameter("productName");
        byte[] bytes=productName1.getBytes("ISO-8859-1");
        String productName=new String(bytes,"utf-8");
        BigDecimal purchasePrice=new BigDecimal(request.getParameter("purchasePrice"));
        String purchaseDate=request.getParameter("purchaseDate");
        String proDate=request.getParameter("proDate");
        String expDate=request.getParameter("expDate");
        int count=Integer.parseInt(request.getParameter("count"));
        BigDecimal salePrice=new BigDecimal(request.getParameter("salePrice"));
        int supplierId=Integer.parseInt(request.getParameter("supplierId"));
        int categoryId=Integer.parseInt(request.getParameter("categoryId"));
        //从session获取登录用户id
        User user=(User) request.getSession().getAttribute("user");
        int userId=user.getId();
        service.purchase(barCode,userId,productName,purchasePrice,purchaseDate,proDate,expDate,count,salePrice,supplierId,categoryId);
        request.getRequestDispatcher("/view/purchase/input_result.jsp").forward(request,response);

    }
}
