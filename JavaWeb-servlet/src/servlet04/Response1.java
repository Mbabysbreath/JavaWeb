package servlet04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaomin
 * @date 2020/3/17 13:34
 * 请求重定向的特点：
 * 1.地址栏中的地址会发生变化
 * 2.是两次请求
 * 3.不共享Request域中的数据
 * 4.不能访问WEB-INF下的资源
 * 5.可以访问工程以外的资源
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*第一种方案：*/
        req.setAttribute("key", "value");
        //设置响应状态码，表示重定向（已经搬迁）
        resp.setStatus(302);
        //设置响应头，说明新的地址在哪里
        //resp.setHeader("Location","http://localhost:8080/JavaWeb-servlet/response2");
        // resp.setHeader("Location","http://localhost:8080/JavaWeb-servlet/WEB-INF/form.html");
        resp.setHeader("Location", "http://localhost:8080");
/*第二种方案：推荐使用*/
        resp.sendRedirect("http://localhost:8080/JavaWeb-servlet/response2");
    }
}
