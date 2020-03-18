package servlet02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet获取请求体的信息
 * @author zhaomin
 * @date 2020/3/14 11:25
 */

public class RequestAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //i. getRequestURI() 获取请求的资源路径
        System.out.println("获取请求的资源路径 -->"+req.getRequestURI());
        // ii.getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("获取请求的统一资源定位符（绝对路径-->"+req.getRequestURL());
        // iii. getRemoteHost() 获取客户端的 ip 地址
        System.out.println("获取客户端的 ip 地址-->"+req.getRemoteHost());
        // iv.getHeader()
        System.out.println("请求头--》"+req.getHeader("User-Agent"));
        //getMethod() 获取请求的方法get/post
        System.out.println("获取请求的方法——》"+req.getMethod());
    }
}
