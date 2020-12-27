package SERVLET;

import DAO.ExpressDao;
import JAVABEAN.express;

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
public class AdminExpressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");

        // 获取按下的是哪个按钮
        String button = request.getParameter("submit");
        String studentname = request.getParameter("studentname");
        String dormitoryid = request.getParameter("dormitoryid");
        Date arrivetime = null;
        Date collecttime = null;
        try {
            arrivetime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("arrivetime"));
            collecttime =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("collecttime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String collectname = request.getParameter("collectname");
        int collectnum = Integer.parseInt(request.getParameter("collectnum"));
        String collectphoneid = request.getParameter("collectphoneid");

        express express = new express();
        express.setStudentname(studentname);
        express.setDormitoryid(dormitoryid);
        express.setArrivetime(arrivetime);
        express.setCollecttime(collecttime);
        express.setCollectnum(collectnum);
        express.setCollectname(collectname);
        express.setCollectphoneid(collectphoneid);

        ExpressDao expressDao = new ExpressDao();
        ArrayList<express> expresses = new ArrayList<>();
        try {
            if(button.equals("submit"))
            {
                expressDao.submit(express);
            } else if(button.equals("modify")){
                expressDao.modify(express);
            }
           expresses = expressDao.getAllExpress();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        request.getSession().setAttribute("expresses",expresses);
        request.getRequestDispatcher("admin_student_expess.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
}
