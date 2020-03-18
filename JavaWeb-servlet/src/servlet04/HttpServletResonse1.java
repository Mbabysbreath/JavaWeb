package servlet04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhaomin
 * @date 2020/3/17 10:58
 * 一、HttpServletResponse类的作用：
 * 1.和HttpServletRequest类一样，每次请求进来时，Tomcat服务器都会创建一个Response对象传递
 * 给Servlet程序去使用。HttpServletRequest表示请求过来的信息，HttpServletResponse表示响应的信息
 * 2.我们如果需要设置返回给客户端的信息，都可以通过HttpServletResponse对象来设置
 *二、两个输出流的说明--两个流只能使用一个
 * 字节流 getOutputStream() ---常用于下载（传递二进制数据）
 * 字符流 getWriter()       ---常用于回传字符串（常用）
 *
 */
public class HttpServletResonse1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/**
 * 如果同时使用，服务器会报异常500
 */
        //resp.getWriter();
       // resp.getOutputStream();
        /**
         * 要求：往客户端回传字符串数据
         */
        //设置服务器端的响应字符集
        resp.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器也使用UTF-8字符集
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        System.out.println("服务器--"+resp.getCharacterEncoding());
        System.out.println("浏览器--"+req.getCharacterEncoding());

        //他会同时设置服务器和浏览器的字符集，还设置了响应头
        //前提：一定要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("response's content ===服务器端响应数据");

    }
}
