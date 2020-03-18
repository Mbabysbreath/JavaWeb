package servlet03;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaomin
 * @date 2020/3/16 10:18
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        System.out.println("检查材料参数"+username);
        //2.获取域对象 --检查1的章
        Object key = req.getAttribute("key1");
        System.out.println( key);
        //3处理自己的业务
        System.out.println("柜台2处理自己的业务");
    }
}
