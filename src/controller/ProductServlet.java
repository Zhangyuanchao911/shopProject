package controller;

import model.Category;
import model.Product;
import model.Supplier;
import service.CategoryService;
import service.ProductService;
import service.SupplierService;
import service.impl.CategoryImpl;
import service.impl.ProductImpl;
import service.impl.SupplierImpl;
import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product.do")
public class ProductServlet extends HttpServlet {

    ProductService service=new ProductImpl();
    CategoryService categoryService=new CategoryImpl();
    SupplierService supplierService=new SupplierImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (Constant.SHOW.equals(action)){
            show(request,response);
        }else if (Constant.SELECT_FUZZY.equals(action)){
            fuzzyQuery(request,response);
        }else if (Constant.DELETE.equals(action)){
            delete(request,response);
        }else if (Constant.UPDATE.equals(action)){
            update(request,response);
        }else if (Constant.showProduct.equals(action)){
            showProduct(request,response);
        }else if (Constant.ADD_UPDATE.equals(action)){
            addUpdate(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list=service.listQuery();
        request.setAttribute("show",list);
        request.getRequestDispatcher("/view/product/product_list.jsp").forward(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("param"));
        service.delete(id);
        showProduct(request,response);
    }
    //模糊查询
    public void fuzzyQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String kw=request.getParameter("kw");
        byte[] bytes=kw.getBytes("ISO-8859-1");
        String kww=new String(bytes,"utf-8");
        List<Product> list=service.listQueryFuzz(kww);
        request.setAttribute("show",list);
        request.getRequestDispatcher("/view/product/product_list.jsp").forward(request,response);
    }
    //显示产品信息查询
    public void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list=service.showProduct();
        request.setAttribute("show",list);
        request.getRequestDispatcher("/view/product/product_list.jsp").forward(request,response);

    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("param"));
        Product product=service.query(id);
        List<Category> category=categoryService.listQuery();
        List<Supplier> supplier=supplierService.listQuery();
        request.setAttribute("product",product);
        request.setAttribute("category",category);
        request.setAttribute("supplier",supplier);
        request.getRequestDispatcher("/view/product/product_modify.jsp").forward(request,response);
        show(request,response);
    }
    public void addUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        String bar=request.getParameter("barCode");
        String productName1=request.getParameter("productName");
        byte[] bytes=productName1.getBytes("ISO-8859-1");
        String productName=new String(bytes,"utf-8");
        String salePrice=request.getParameter("salePrice");
        float sale=Float.parseFloat(salePrice);
        int supplierId=Integer.parseInt(request.getParameter("supplierId"));
        int categoryId=Integer.parseInt(request.getParameter("categoryId"));
        ProductService service=new ProductImpl();
        Product product=new Product();
        product.setId(id);
        product.setBar_code(bar);
        product.setProduct_name(productName);
        product.setProduct_price(sale);
        product.setSupplier_id(supplierId);
        product.setCategory_id(categoryId);
        System.out.println(product.toString());
        service.update(product);
        request.getRequestDispatcher("/view/product/product_list.jsp").forward(request,response);

    }
}
