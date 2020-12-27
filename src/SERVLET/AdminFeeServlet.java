package SERVLET;

import DAO.FeeDao;
import DAO.LaterecordDao;
import JAVABEAN.fee;
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
public class AdminFeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");

        // 获取按下的是哪个按钮
        String button = request.getParameter("submit");

        String month = request.getParameter("month");
        String dormitoryid = request.getParameter("dormitoryid");
        String electricfee = request.getParameter("electricfee");
        String electricnum = request.getParameter("electricnum");
        String waterfee = request.getParameter("waterfee");
        String waternum = request.getParameter("waternum");

        fee fee = new fee();
        fee.setMonth(month);
        fee.setDormitoryid(dormitoryid);
        fee.setElectricfee(electricfee);
        fee.setElectricnum(electricnum);
        fee.setWaterfee(waterfee);
        fee.setWaternum(waternum);

        FeeDao feeDao = new FeeDao();
        ArrayList<fee> fees = new ArrayList<>();
        try {
            if(button.equals("submit"))
            {
                feeDao.submit(fee);
            } else if(button.equals("modify")){
                feeDao.modify(fee);
            }
            fees = feeDao.getAllFee();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        request.getSession().setAttribute("fees",fees);
        request.getRequestDispatcher("admin_student_fee.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
}
