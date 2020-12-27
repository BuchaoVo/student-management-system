package SERVLET;

import DAO.StudentDao;
import JAVABEAN.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AdminSearchServlet")
public class AdminSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");
        try {
            // 对表单提交的数据进行处理
            String studentid = request.getParameter("studentid");
            String studentname = request.getParameter("studentname");
            String major = request.getParameter("major");
            String department = request.getParameter("department");
            String classes = request.getParameter("classes");
            String dormitoryid = request.getParameter("dormitoryid");
            String phoneid = request.getParameter("phoneid");

            student student = new student();
            student.setStudentid(studentid);
            student.setStudentname(studentname);
            student.setMajor(major);
            student.setDepartment(department);
            student.setClasses(classes);
            student.setDormitoryid(dormitoryid);
            student.setPhoneid(phoneid);

            StudentDao studentDao = new StudentDao();
            ArrayList<student> students = studentDao.getStudentsByCondition(student);

            request.getSession().setAttribute("students",students);
            request.getRequestDispatcher("admin_student_information.jsp").forward(request,response);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
