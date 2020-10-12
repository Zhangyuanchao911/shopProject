package filter;

import model.User;
import util.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "*.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;
        //修改字符集编码方式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri=request.getRequestURI();
        //css放行
        if (uri.endsWith(".css")){
            response.setContentType("text/css;charset=utf-8");
        }else {
            response.setContentType("text/html;charset=utf-8");
        }
        User user = (User) request.getSession().getAttribute("user");
        String action=request.getParameter("action");
        //登录过滤器
        if (user==null&&!uri.endsWith("login.jsp")&&!Constant.LOGIN.equals(action)){
            response.sendRedirect("login.jsp");
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
