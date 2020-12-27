package DAO;

import JAVABEAN.fee;
import JDBC.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeeDao {
    // 根据宿舍号返回水电费信息信息
    public ArrayList<fee> getFeesByStudentname(String dormitoryid) throws SQLException, ClassNotFoundException {
        ArrayList<fee> fees = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        String sql = "select * from fee where dormitoryid = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dormitoryid);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            fee fee = new fee();
            fee.setMonth(rs.getString("month"));
            fee.setDormitoryid(rs.getString("dormitoryid"));
            fee.setElectricfee(rs.getString("electricfee"));
            fee.setElectricnum(rs.getString("electricnum"));
            fee.setWaterfee(rs.getString("waterfee"));
            fee.setWaternum(rs.getString("waternum"));
            fees.add(fee);
        }
        return  fees;
    }

    // 得到所有水电费信息
    public ArrayList<fee> getAllFee() throws SQLException, ClassNotFoundException {
        ArrayList<fee> fees = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        String sql = "select * from fee";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            fee fee = new fee();
            fee.setMonth(rs.getString("month"));
            fee.setDormitoryid(rs.getString("dormitoryid"));
            fee.setElectricfee(rs.getString("electricfee"));
            fee.setElectricnum(rs.getString("electricnum"));
            fee.setWaterfee(rs.getString("waterfee"));
            fee.setWaternum(rs.getString("waternum"));
            fees.add(fee);
        }
        return  fees;
    }
    // 修改水电费信息
    public void modify(fee fee) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtils.getConnection();
        String sql = "update fee set  month = ?,dormitoryid = ?, electricfee = ?, electricnum = ?, waterfee = ?, waternum = ? where dormitoryid = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,fee.getMonth());
        pstmt.setString(2,fee.getDormitoryid());
        pstmt.setString(3,fee.getElectricfee());
        pstmt.setString(4,fee.getElectricnum());
        pstmt.setString(5,fee.getElectricfee());
        pstmt.setString(6,fee.getElectricnum());
        pstmt.setString(7,fee.getDormitoryid());
        pstmt.executeUpdate();
    }
    // 提交修改信息
    public void submit(fee fee) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtils.getConnection();
        String sql = "insert into fee(month,dormitoryid,electricfee,electricnum,waterfee,waternum) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,fee.getMonth());
        pstmt.setString(2,fee.getDormitoryid());
        pstmt.setString(3,fee.getElectricfee());
        pstmt.setString(4,fee.getElectricnum());
        pstmt.setString(5,fee.getElectricfee());
        pstmt.setString(6,fee.getElectricnum());
        pstmt.executeUpdate();
    }
}
