package SERVLET;

import DAO.ExpressDao;
import DAO.LeavereturnDao;
import JAVABEAN.express;
import JAVABEAN.leavereturn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "AdminLeavereturnServlet")
public class AdminLeavereturnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");

        // 获取按下的是哪个按钮
        String button = request.getParameter("submit");
        String studentname = request.getParameter("studentname");
        String dormitoryid = request.getParameter("dormitoryid");
        Date leavetime = null;
        Date returntime = null;
        try {
            leavetime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("leavetime"));
            returntime =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("returntime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        leavereturn leavereturn = new leavereturn();
        leavereturn.setStudentname(studentname);
        leavereturn.setDormitoryid(dormitoryid);
        leavereturn.setLeavetime(leavetime);
        leavereturn.setReturntime(returntime);

        LeavereturnDao leavereturnDao = new LeavereturnDao();
        ArrayList<leavereturn> leavereturns = new ArrayList<>();
        try {
            if(button.equals("submit"))
            {
                leavereturnDao.submit(leavereturn);
            } else if(button.equals("modify")){
                leavereturnDao.modify(leavereturn);
            }
            leavereturns = leavereturnDao.getAllLeavereturn();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        request.getSession().setAttribute("leavereturns",leavereturns);
        request.getRequestDispatcher("admin_student_leavereturn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
