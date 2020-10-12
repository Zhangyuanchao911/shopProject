package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

/**
 * tomcat停止时，关闭jdbc链接资源，避免内存泄漏
 * 关闭tomcat时相关的错误日志信息：
 * 16-Jul-2020 11:39:40.626 警告 [main] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesJdbc Web应用程序 [shop-pss] 注册了JDBC驱动程序 [com.alibaba.druid.proxy.DruidDriver]，但在Web应用程序停止时无法注销它。 为防止内存泄漏，JDBC驱动程序已被强制取消注册。
 * 16-Jul-2020 11:39:40.627 警告 [main] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesJdbc Web应用程序 [shop-pss] 注册了JDBC驱动程序 [com.mysql.cj.jdbc.Driver]，但在Web应用程序停止时无法注销它。 为防止内存泄漏，JDBC驱动程序已被强制取消注册。
 * 16-Jul-2020 11:39:40.628 警告 [main] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesThreads Web应用程序[shop-pss]似乎启动了一个名为[mysql-cj-abandoned-connection-cleanup]的线程，但未能停止它。这很可能会造成内存泄漏。线程的堆栈跟踪：[
 *  java.lang.Object.wait(Native Method)
 *  java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:144)
 *  com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:85)
 *  java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
 *  java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
 *  java.lang.Thread.run(Thread.java:748)]
 * 16-Jul-2020 11:39:40.631 信息 [main] org.apache.coyote.AbstractProtocol.stop 正在停止ProtocolHandler ["http-nio-8080"]
 * 16-Jul-2020 11:39:40.632 信息 [main] org.apache.coyote.AbstractProtocol.destroy 正在摧毁协议处理器 ["http-nio-8080"]
 */
@WebListener
public class ContextFinalizerListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while (drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                System.out.println(String.format("ContextFinalizer:Driver %s deregistered", d));
            } catch (SQLException ex) {
                System.out.println(String.format("ContextFinalizer:Error deregistering driver %s", d) + ":" + ex);
            }
        }
        AbandonedConnectionCleanupThread.uncheckedShutdown();
    }

    public ContextFinalizerListener(){
        System.out.println("init ContextFinalizerListener");
    }

}
