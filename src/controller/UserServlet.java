package controller;

import model.Role;
import model.User;
import service.RoleService;
import service.UserService;
import service.impl.RoleImpl;
import service.impl.UserImpl;
import util.Constant;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    UserService service = new UserImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Constant.LOGIN.equals(action)) {
            loginUser(request, response);
        } else if (Constant.ADD.equals(action)) {
              add(request,response);
        } else if (Constant.SHOW.equals(action)) {
            show(request, response);
        } else if (Constant.UPDATE.equals(action)) {
            update(request, response);
        } else if (Constant.DELETE.equals(action)) {
            delete(request,response);
        }else if (Constant.MODIFY.equals(action)){
            modify(request,response);
        }else if (Constant.SELECT_FUZZY.equals(action)){
            fuzzy(request,response);
        }else if (Constant.INSERT.equals(action)){
            insert(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void insert(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String userName=request.getParameter("userName");
        byte[] b1=userName.getBytes("ISO-8859-1");
        String user_name=new String(b1,"utf-8");
        int role_id = Integer.parseInt(request.getParameter("roleId"));
        String loginAccount = request.getParameter("loginAccount");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String wx_account = request.getParameter("wxAccount");
        String id_no = request.getParameter("idNo");
        String address1=request.getParameter("address");
        byte[] b2=address1.getBytes("ISO-8859-1");
        String address=new String(b2,"utf-8");
        User user=new User(user_name,role_id,loginAccount,password,tel,wx_account,id_no,address);
        service.add(user);
        show(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoleService roleService=new RoleImpl();
        List<Role>roleList=roleService.listQuery();
        request.setAttribute("rList",roleList);
        request.getRequestDispatcher("/view/user/user_add.jsp").forward(request,response);
    }
    public void fuzzy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String kw=request.getParameter("kw");
        byte[] bytes=kw.getBytes("ISO-8859-1");
        String kww=new String(bytes,"utf-8");
        List<User> list=service.listQueryFuzz(kww);
        request.setAttribute("user",list);
        request.getRequestDispatcher("/view/user/user_list.jsp").forward(request,response);
    }
    public void show(HttpServletRequest request, HttpServletResponse response) {

        try {
            List<User> list = service.listQuery();
            request.setAttribute("user", list);
            request.getRequestDispatcher("/view/user/user_list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            RoleService roleService = new RoleImpl();
            List<Role> roles = roleService.listQuery();
            request.setAttribute("role", roles);
            int id = Integer.parseInt(request.getParameter("id"));
            User user = service.query(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/view/user/user_modify.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        show(request, response);
    }

    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginAccount = request.getParameter("loginAccount");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = service.login(loginAccount, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        boolean log = false;
        if (user != null) {
            log = true;
        }
        if (log) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName=request.getParameter("userName");
        byte[] b1=userName.getBytes("ISO-8859-1");
        String user_name=new String(b1,"utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int role_id = Integer.parseInt(request.getParameter("roleId"));
        String loginAccount = request.getParameter("loginAccount");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String wx_account = request.getParameter("wxAccount");
        String id_no = request.getParameter("idNo");
        String address1=request.getParameter("address");
        byte[] b2=address1.getBytes("ISO-8859-1");
        String address=new String(b2,"utf-8");
        User user = new User(id, user_name, role_id, loginAccount, password, tel, wx_account, id_no, address);
        service.update(user);
        show(request,response);

    }

}
