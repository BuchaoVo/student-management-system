package SERVLET;

import DAO.ExpressDao;
import DAO.GuaranteeDao;
import JAVABEAN.express;
import JAVABEAN.guarantee;

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

@WebServlet(name = "AdminGuaranteeServlet")
public class AdminGuaranteeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");


        String dormitoryid = request.getParameter("dormitoryid");
        String studentname = request.getParameter("studentname");
        String goodsname = request.getParameter("goodsname");
        String reason = request.getParameter("reason");
        String phoneid = request.getParameter("phoneid");

        Date guaranteetime = null;
        try {
            guaranteetime =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("guaranteetime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String guaranteestaus = request.getParameter("guaranteestaus");

        guarantee guarantee = new guarantee();

        guarantee.setDormitoryid(dormitoryid);
        guarantee.setGoodsname(goodsname);
        guarantee.setGuaranteetime(guaranteetime);
        guarantee.setGuaranteestaus(guaranteestaus);


        GuaranteeDao guaranteeDao = new GuaranteeDao();
        ArrayList<guarantee> guarantees = new ArrayList<>();
        try {
            guaranteeDao.modify(guarantee);
            guarantees = guaranteeDao.getAllguarantee();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        request.getSession().setAttribute("guarantees",guarantees);
        request.getRequestDispatcher("admin_student_guarantee.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
