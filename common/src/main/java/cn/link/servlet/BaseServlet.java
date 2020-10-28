package cn.link.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/28 21:05
 * @description 复习基本的 Servlet
 *
 *
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            //action参数可通过表单隐藏域传递
            String action = req.getParameter("action");
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //子 Servlet函数中的参数都是 req 和 resp即可
            method.invoke(this, req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
