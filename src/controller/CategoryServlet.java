package controller;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;
import model.Category;
import service.CategoryService;
import service.impl.CategoryImpl;
import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@WebServlet("/category.do")
public class CategoryServlet extends HttpServlet {
    CategoryService service=new CategoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action=request.getParameter("action");
            if (Constant.SHOW.equals(action)){
                show(request,response);
            }else if (Constant.UPDATE.equals(action)){
                  update(request,response);
            }else if (Constant.SELECT_FUZZY.equals(action)){
                 fuzzy(request,response);
            }else if (Constant.DELETE.equals(action)){
                delete(request,response);
            }else if (Constant.DETAIL.equals(action)){
                detail(request,response);
            }
            else if((Constant.ADD.equals(action))){
               add(request,response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Category> list=service.listQuery();
         request.setAttribute("show",list);
         request.getRequestDispatcher("/view/category/category_list.jsp").forward(request,response);
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("param"));
        //转乱码
        String categoryName1=request.getParameter("categoryName");
        byte[] bytes=categoryName1.getBytes("ISO-8859-1");
        String categoryName=new String(bytes,"utf-8");
        service.update(categoryName,id);
        show(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("param"));
        System.out.println(id);
        service.delete(id);
        show(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String categoryName1=request.getParameter("categoryName");
        byte[] bytes=categoryName1.getBytes("ISO-8859-1");
        String categoryName=new String(bytes,"utf-8");
        Date date=new Date();
        Category category=new Category();
        category.setCategory_name(categoryName);
        category.setCreat_time(date);
        category.setUpdate_time(date);
        int i=service.add(category);
        show(request,response);
    }
    public void fuzzy(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
            String kw=request.getParameter("kw");
            byte[] bytes=kw.getBytes("ISO-8859-1");
            String kww=new String(bytes,"utf-8");
            List<Category> list=service.listFuzzy(kww);
            request.setAttribute("show",list);
            request.getRequestDispatcher("/view/category/category_list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void detail(HttpServletRequest request, HttpServletResponse response){
         int id=Integer.parseInt(request.getParameter("param"));
         Category category=service.query(id);
         request.setAttribute("category",category);
        try {
            request.getRequestDispatcher("/view/category/category_modify.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
