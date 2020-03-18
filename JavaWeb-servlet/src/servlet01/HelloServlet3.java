package servlet01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaomin
 * @date 2020/3/10 23:45
 * servletContext的作用：
 * 1、获取 web.xml 中配置的上下文参数 context-param
 * 2、获取当前的工程路径，格式:/工程路径
 * 3、获取工程部署后在服务器硬盘上的绝对路径
 * 4、像 Map 一样存取数据

 */
public class HelloServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost使用");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet使用");
        //1、获取 web.xml 中配置的上下文参数 context-param
        ServletContext servletContext=getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println(username);
        String url = servletContext.getInitParameter("url");
        System.out.println(url);
        //2.获取工程的路径
        String context = servletContext.getContextPath();
        System.out.println(context);
        //3.获取工程部署后在服务器硬盘上的绝对路径
        /*
         斜 杠 被 服 务 器 解 析 地 址 为 :http://ip:port/ 工 程 名 /
         映 射 到 IDEA代 码 的 web 目 录 <br/>
         Idea整合tomcat后，Tomact被拷贝的一些副本内容
         C:\Users\zhao'min\.IntelliJIdea2017.3\system\tomcat\Tomcat_9_0_30_JavaWeb_4
         */
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
    }


}
