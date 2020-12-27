package DAO;

import JAVABEAN.student;
import JDBC.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
    // 根据用户名得到 进行登陆验证
    public ResultSet selectStudent(String username) throws SQLException, ClassNotFoundException {
        Connection  conn = DBUtils.getConnection();;
        PreparedStatement pstmt = null;
        String sql = "select * from student where username = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    // 根据名字返回宿舍号
    public String getDormirotyByUsername(String username) throws SQLException, ClassNotFoundException {
        Connection  conn = DBUtils.getConnection();
        String sql = "select * from student where username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet rs = pstmt.executeQuery();

        String dormitoryid = null;
        while(rs.next())
        {
            dormitoryid = rs.getString("dormitoryid");
        }
        return dormitoryid;
    }// 根据名字返回学号
    public String getStudentidByStudentname(String studentname) throws SQLException, ClassNotFoundException {
        Connection  conn = DBUtils.getConnection();
        String sql = "select * from student where studentname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,studentname);
        ResultSet rs = pstmt.executeQuery();

        String studentid = null;
        while(rs.next())
        {
            studentid = rs.getString("studentid");
        }
        return studentid;
    }
    // 根据宿舍号返回宿舍成员
    public ArrayList<student> getStudentsByDormitoryid(String dormitoryid) throws SQLException, ClassNotFoundException {
        ArrayList<student> students = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        String sql = "select * from student where dormitoryid = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dormitoryid);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            student stu = new student();
            stu.setStudentid(rs.getString("studentid"));
            stu.setStudentname(rs.getString("studentname"));
            stu.setMajor(rs.getString("major"));
            stu.setGender(rs.getString("gender"));
            stu.setDepartment(rs.getString("department"));
            stu.setClasses(rs.getString("classes"));
            stu.setDormitoryid(rs.getString("dormitoryid"));
            stu.setPhoneid(rs.getString("phoneid"));
            stu.setEntrytime(rs.getDate("entrytime"));
            students.add(stu);
        }
        return  students;
    }
    // 返回所有寝室成员
    public ArrayList<student> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<student> students = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        String sql = "select * from student";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            student stu = new student();
            stu.setStudentid(rs.getString("studentid"));
            stu.setStudentname(rs.getString("studentname"));
            stu.setMajor(rs.getString("major"));
            stu.setGender(rs.getString("gender"));
            stu.setDepartment(rs.getString("department"));
            stu.setClasses(rs.getString("classes"));
            stu.setDormitoryid(rs.getString("dormitoryid"));
            stu.setPhoneid(rs.getString("phoneid"));
            stu.setEntrytime(rs.getDate("entrytime"));
            stu.setUsername(rs.getString("username"));
            stu.setPassword(rs.getString("password"));
            students.add(stu);
        }
        return  students;
    }
    // 根据学号得到名字
    public String getStudentnameByUsername(String username) throws SQLException, ClassNotFoundException {
        Connection  conn = DBUtils.getConnection();
        String sql = "select * from student where username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet rs = pstmt.executeQuery();
        String studentname = null;
        while(rs.next())
        {
            studentname = rs.getString("studentname");
        }
        return studentname;
    }
    // 根据条件查询得到学生
    public ArrayList<student> getStudentsByCondition(student stu) throws SQLException, ClassNotFoundException {
        Connection  conn = DBUtils.getConnection();
        String sql = "select * from student where 1 = 1";
        ArrayList<String> parm = new ArrayList<>();
        ArrayList<student> students = new ArrayList<>();

        String studentid = stu.getStudentid();
        String studentname = stu.getStudentname();
        String major = stu.getMajor();
        String department = stu.getDepartment();
        String classes = stu.getClasses();
        String dormitoryid = stu.getDormitoryid();
        String phoneid = stu.getPhoneid();

        if (studentid != "")
        {
            sql += " and studentid = ?";
            parm.add(studentid);
        }
        if(studentname != "")
        {
            sql += " and studentname = ?";
            parm.add(studentname);
        }
        if (major != "")
        {
            sql += " and major = ?";
            parm.add(major);
        }
        if(department != "")
        {
            sql += " and department = ?";
            parm.add(department);
        }
        if(classes != "")
        {
            sql += " and classes = ?";
            parm.add(classes);
        }
        if(dormitoryid != "")
        {
            sql += " and dormitoryid = ?";
            parm.add(dormitoryid);
        }
        if(phoneid != "")
        {
            sql += " and phoneid = ?";
            parm.add(phoneid);
        }
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //System.out.println("sql :" + sql);
        for (int i = 0; i < parm.size(); i++)
        {
            pstmt.setString(i+1,parm.get(i));
        }

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            student student = new student();

            student.setStudentid(rs.getString("studentid"));
            student.setStudentname(rs.getString("studentname"));
            student.setGender(rs.getString("gender"));
            student.setMajor(rs.getString("major"));
            student.setDepartment(rs.getString("department"));
            student.setClasses(rs.getString("classes"));
            student.setDormitoryid(rs.getString("dormitoryid"));
            student.setPhoneid(rs.getString("phoneid"));
            student.setEntrytime(rs.getDate("entrytime"));
            student.setUsername(rs.getString("username"));
            student.setPassword(rs.getString("password"));

            //System.out.println("username :" + rs.getString("username"));

            students.add(student);
        }
        return students;
    }
}
