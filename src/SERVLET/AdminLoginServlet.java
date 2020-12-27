package SERVLET;

import DAO.*;
import JAVABEAN.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");

        // 获取用户名 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断用户名、密码是否为空
        if(username==""||username.length()==0){
            request.setAttribute("NAMEMSG","用户名为空!");
            request.getRequestDispatcher("admin_login.jsp").forward(request, response);
        }
        if(password==""||password.length()==0) {
            request.setAttribute("PWDMSG", "密码为空!");
            request.getRequestDispatcher("admin_login.jsp").forward(request, response);
        }
        AdminDao adminDao = new AdminDao();
        StudentDao studentDao = new StudentDao();
        ExpressDao expressDao = new ExpressDao();
        GuaranteeDao guaranteeDao = new GuaranteeDao();
        LeavereturnDao leavereturnDao = new LeavereturnDao();
        LaterecordDao laterecordDao = new LaterecordDao();
        FeeDao feeDao = new FeeDao();
        try {

            ResultSet rs = adminDao.selectAdmin(username);
            if(rs.next()){
                if(password.equals(rs.getString("password"))){
                    //登陆成功
                    //将用户admin存入session域
                    dormadmin admin = new dormadmin();
                    admin.setUsername(username);
                    admin.setPassword(password);
                    request.getSession().setAttribute("dormadmin",admin);
                    // 得到管理员名字
                    String dormadminname = rs.getString("dormadminname");
                    // 得到所有寝室成员的信息
                    ArrayList<student> students = studentDao.getAllStudents();
                    // 得到所有快件信息
                    ArrayList<express> expresses =  expressDao.getAllExpress();
                    // 得到所有维修信息
                    ArrayList<guarantee> guarantees = guaranteeDao.getAllguarantee();
                    // 得到所有离校返校信息
                    ArrayList<leavereturn>  leavereturns = leavereturnDao.getAllLeavereturn();
                    // 得到所有的晚归记录
                    ArrayList<laterecord>   laterecords = laterecordDao.getAllLaterecords();
                    // 得到所有的水电费信息
                    ArrayList<fee>   fees = feeDao.getAllFee();

                    request.getSession().setAttribute("admin",username);
                    request.getSession().setAttribute("dormadminname",dormadminname);
                    request.getSession().setAttribute("students",students);
                    request.getSession().setAttribute("expresses",expresses);
                    request.getSession().setAttribute("guarantees",guarantees);
                    request.getSession().setAttribute("leavereturns",leavereturns);
                    request.getSession().setAttribute("laterecords",laterecords);
                    request.getSession().setAttribute("fees",fees);

                    Cookie cookie = new Cookie("SESSION",admin.getUsername());
                    cookie.setMaxAge(24*60*60);
                    cookie.setComment("student");
                    //设置作用域，这里设置为根目录以下所有
                    cookie.setPath("/");
                    //将设置好的cookie保存到客户端的浏览器
                    response.addCookie(cookie);
                    // 跳转至首页
                    request.getRequestDispatcher("admin_student_information.jsp").forward(request,response);

                }else{
                    request.setAttribute("PWDERROR","密码不正确!");
                    request.getRequestDispatcher("admin_login.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("NAMEERROR","用户名不存在!");
                request.getRequestDispatcher("admin_login.jsp").forward(request, response);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
