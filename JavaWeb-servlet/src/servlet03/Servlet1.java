package servlet03;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaomin
 * @date 2020/3/16 9:41
 * 请求转发的特点：
 * 1、浏览器地址栏没有变化
 * 2、他们是一次请求
 * 3、他们共享Request域中的数据
 * 4、可以转发到WEB_INF目录下
 * 5、不可以访问工程以外的资源
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.获取请求参数--检查资料
        String username = req.getParameter("username");
        System.out.println("检查材料参数"+username);
        System.out.println("柜台1处理自己的业务");
        //2.给材料盖章--设置域数据
        req.setAttribute("key1", "柜台1的章");
        //3.获取请求转发对象 问路
        /**
         * 请求转发必须要以斜杠打头，/斜杠表示地址为：http://ip:port/工程名/ ,
         * 映射到IDEA代码的web目录
         *
         * web中斜杠的不同意义
         * 在web中斜杠/ 是一种绝对路径
         * 被浏览器解析(html文件会被浏览器解析)：---得到的地址：http://ip:port
         * 被服务器解析，得到的地址是----http://ip:port/工程路径
         * <url-pattern>/servlet</url-pattern>
         * servletContext.getRealPath("/")
         * request.getRequestDispatcher("/")
         *
         * 特殊情况：response.sendRediect("/")--把斜杠发送给浏览器解析，得到http://ip:port/
         *
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //可以转发到WEB_INF目录下,form.html在WEB-INF目录下不能直接被访问，但可以通过转发访问到
        RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("/WEB-INF/form.html");
        //不可以访问工程以外的资源
        RequestDispatcher requestDispatcher2= req.getRequestDispatcher("http://www.baidu.com");

        //4.向柜台2去带着自己的参数（材料）
        requestDispatcher.forward(req,resp);
    }
}
