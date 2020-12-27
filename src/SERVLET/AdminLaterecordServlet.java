package SERVLET;

import DAO.ExpressDao;
import DAO.LaterecordDao;
import JAVABEAN.express;
import JAVABEAN.laterecord;

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

@WebServlet(name = "AdminExpressServlet")
public class AdminLaterecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");

        // 获取按下的是哪个按钮
        String button = request.getParameter("submit");
        String studentid = request.getParameter("studentid");
        String studentname = request.getParameter("studentname");
        String dormitoryid = request.getParameter("dormitoryid");
        Date latetime = null;
        try {
            latetime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("latetime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String reason = request.getParameter("reason");

        laterecord laterecord = new laterecord();
        laterecord.setStudentname(studentname);
        laterecord.setDormitoryid(dormitoryid);
        laterecord.setLatetime(latetime);
        laterecord.setReason(reason);

        LaterecordDao laterecordDao = new LaterecordDao();
        ArrayList<laterecord> laterecords = new ArrayList<>();
        try {
            if(button.equals("submit"))
            {
                laterecordDao.submit(laterecord);
            } else if(button.equals("modify")){
                laterecordDao.modify(laterecord);
            }
            laterecords = laterecordDao.getAllLaterecords();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        request.getSession().setAttribute("laterecords",laterecords);
        request.getRequestDispatcher("admin_student_laterecord.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
}
