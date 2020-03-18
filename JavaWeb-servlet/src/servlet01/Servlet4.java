package servlet01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaomin
 * @date 2020/3/13 0:17
 */
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1、ServletContext 是一个接口，它表示 Servlet 上下文对象
         * 2、一个 web 工程，只有一个 ServletContext 对象实例。
         * 3、ServletContext 对象是一个域对象。
         * 4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁
         */
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext.getAttribute("key1"));
        servletContext.setAttribute("key1","val1");
        System.out.println(servletContext.getAttribute("key1"));
        System.out.println(servletContext.getAttribute("key1"));
        System.out.println(servletContext.getAttribute("key1"));
        System.out.println(servletContext.getAttribute("key1"));

    }
}
