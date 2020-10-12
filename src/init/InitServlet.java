package init;

import util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(urlPatterns = "/init.do",loadOnStartup = 0)
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

        try {
            //初始化资源 转成流
            InputStream io=InitServlet.class.getResourceAsStream("/db.properties");
            Properties pro=new Properties();
            pro.load(io);
            JDBCUtil jdbcUtil=JDBCUtil.getInstance();
            jdbcUtil.initFromProperties(pro);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
