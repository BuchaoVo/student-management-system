package DAO;

import JAVABEAN.express;
import JAVABEAN.guarantee;
import JDBC.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class ExpressDao {
    // 根据姓名返回快件信息
    public ArrayList<express> getExpressesByStudentname(String studentname) throws SQLException, ClassNotFoundException {
        ArrayList<express> expresses = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        String sql = "select * from express where studentname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentname);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            express exp = new express();
            exp.setStudentname(rs.getString("studentname"));
            exp.setDormitoryid(rs.getString("dormitoryid"));
            exp.setArrivetime(rs.getDate("arrivetime"));
            exp.setCollecttime(rs.getDate("collecttime"));
            exp.setCollectnum(rs.getInt("collectnum"));
            exp.setCollectname(rs.getString("collectname"));
            exp.setCollectphoneid(rs.getString("collectphoneid"));
            expresses.add(exp);
        }
        return  expresses;
    }
    // 根据用户名跟时间查询快件
    public express getExpressByArrivetime(String studentname,String arrivetime) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtils.getConnection();
        String sql = "select * from express where studentname = ? and arrivetime = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentname);
        pstmt.setString(2, arrivetime);

        ResultSet rs = pstmt.executeQuery();
        express express = new express();
        while (rs.next())
        {
            express.setStudentname(rs.getString("studentname"));
            express.setDormitoryid(rs.getString("dormitoryid"));
            express.setArrivetime(rs.getDate("arrivetime"));
            express.setCollecttime(rs.getDate("collecttime"));
            express.setCollectnum(rs.getInt("collectnum"));
            express.setCollectname(rs.getString("collectname"));
            express.setCollectphoneid(rs.getString("collectphoneid"));
        }
        return  express;
    }

    // 得到所有快件信息
    public ArrayList<express> getAllExpress() throws SQLException, ClassNotFoundException {
        ArrayList<express> expresses = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        String sql = "select * from express";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            express exp = new express();
            exp.setStudentname(rs.getString("studentname"));
            exp.setDormitoryid(rs.getString("dormitoryid"));
            exp.setArrivetime(rs.getDate("arrivetime"));
            exp.setCollecttime(rs.getDate("collecttime"));
            exp.setCollectnum(rs.getInt("collectnum"));
            exp.setCollectname(rs.getString("collectname"));
            exp.setCollectphoneid(rs.getString("collectphoneid"));
            expresses.add(exp);
        }
        return  expresses;
    }
    // 修改快件信息
    public void modify(express express) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtils.getConnection();
        String sql = "update express set  collecttime = ?,  collectname = ?, collectphoneid = ? where dormitoryid = ? and studentname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1,express.getStudentname());
        //pstmt.setString(2,express.getDormitoryid());
        //pstmt.setDate(3, new java.sql.Date(express.getArrivetime().getTime()));
        pstmt.setDate(1,new java.sql.Date(express.getCollecttime().getTime()));
        //pstmt.setInt(5,express.getCollectnum());
        pstmt.setString(2,express.getCollectname());
        pstmt.setString(3,express.getCollectphoneid());
        pstmt.setString(4,express.getDormitoryid());
        pstmt.setString(5,express.getStudentname());

        pstmt.executeUpdate();
    }
    // 提交修改信息
    public void submit(express express) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtils.getConnection();
        String sql = "insert into express(studentname,dormitoryid,arrivetime,collectnum) values(?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,express.getStudentname());
        pstmt.setString(2,express.getDormitoryid());
        pstmt.setDate(3,new java.sql.Date(express.getArrivetime().getTime()));
        pstmt.setInt(4,express.getCollectnum());
        pstmt.executeUpdate();
    }
}
