package SERVLET;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用户注销
        //取得登录的用户名
        HttpSession session =request.getSession();
        //销毁session
        session.invalidate();
        //给名为SINSESSION的cookie复写，将cookie的生命周期设置为0，相当于从客户端销毁了cookie
        Cookie cookie = new Cookie("SESSION","");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        //把复写的cookie返回给客户端
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
