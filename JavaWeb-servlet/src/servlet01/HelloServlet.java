package servlet01;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhaomin
 * @date 2020/3/10 16:05
 * servlet的生命周期
 * 1.构造器
 * 2.init
 * 1.2步只在第一次访问，创建servlet时会被调用
 * 3.service
 * 每一次访问都会被调用
 * 4.derstory
 * 在web工程停止时被调用
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1.构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init()初始化过程");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.Servlet程序被访问");
        //类型转换，因为HttpServletRequest有getMethod()的方法
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        //获取请求的方式
        String method = request.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }
    /**
     * 做get请求的操作
     *
     */
    public void doGet(){
        System.out.println("get请求的操作");
    }

     /**
     * 做post请求的操作
     *
     */
    public void doPost(){
        System.out.println("post请求的操作");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destory()销毁");
    }
}
