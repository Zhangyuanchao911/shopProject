package controller;

import model.Supplier;
import service.SupplierService;
import service.impl.SupplierImpl;
import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( "/supplier.do")
public class SupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (Constant.SHOW.equals(action)){
            show(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
    SupplierService service=new SupplierImpl();

    private void show(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Supplier> list=service.listQuery();
        request.setAttribute("supplier",list);
        request.getRequestDispatcher("/view/supplier/supplier_list.jsp").forward(request,response);
    }
    private boolean delete(int id){
        int count=service.delete(id);
        if (count>0)
            return true;
        else
            return false;
    }
}
