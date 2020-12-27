package SERVLET;

import DAO.GuaranteeDao;
import JAVABEAN.guarantee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AdminGuaranteeServlet")
public class StudentGuaranteeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");


        String dormitoryid = request.getParameter("dormitoryid");
        String studentname = request.getParameter("studentname");
        String goodsname = request.getParameter("goodsname");
        String reason = request.getParameter("reason");
        String phoneid = request.getParameter("phoneid");

        guarantee guarantee = new guarantee();
        guarantee.setDormitoryid(dormitoryid);
        guarantee.setStudentname(studentname);
        guarantee.setGoodsname(goodsname);
        guarantee.setReason(reason);
        guarantee.setPhoneid(phoneid);

        GuaranteeDao guaranteeDao = new GuaranteeDao();
        ArrayList<guarantee> guarantees = new ArrayList<>();
        try {
            guaranteeDao.submit(guarantee);
            guarantees = guaranteeDao.getGuaranteesByDormitoryid(dormitoryid);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        request.getSession().setAttribute("guarantee",guarantees);
        request.getRequestDispatcher("student_guarantee.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
