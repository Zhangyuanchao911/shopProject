package controller;

import model.Product;
import service.StockService;
import service.impl.StockImpl;
import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/stock.do")
public class StockServlet extends HttpServlet {
    StockService service = new StockImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Constant.SHOW.equals(action)) {
            show(request, response);
        } else if (Constant.SELECT_FUZZY.equals(action)) {
            fuzzy(request, response);
        }else if (Constant.RECORD.equals(action)){
            showRecord(request,response);
        }else if (Constant.RECORD_FUZZY.equals(action)){
            showRecordFuzzy(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void showRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Product> products=service.showRecord();
         request.setAttribute("record",products);
         request.getRequestDispatcher("/view/stock/stock_recorder_list.jsp").forward(request,response);
    }
    public void showRecordFuzzy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String kw = request.getParameter("kw");
        byte[] bytes = kw.getBytes("ISO-8859-1");
        String kww = new String(bytes, "utf-8");
        List<Product> product=service.showRecordFuzzy(kww);
        request.setAttribute("record",product);
        request.getRequestDispatcher("/view/stock/stock_recorder_list.jsp").forward(request,response);

    }
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = service.show();
        request.setAttribute("products", product);
        request.getRequestDispatcher("/view/stock/stock_list.jsp").forward(request, response);
    }

    public void fuzzy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String kw = request.getParameter("kw");
        byte[] bytes = kw.getBytes("ISO-8859-1");
        String kww = new String(bytes, "utf-8");
        List<Product> products = service.listQueryFuzz(kww);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/view/stock/stock_list.jsp").forward(request,response);
    }
}
