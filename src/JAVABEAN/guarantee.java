package JAVABEAN;

import java.util.Date;

public class guarantee {
    private String  dormitoryid;
    private String  studentname;
    private String  goodsname;
    private String  reason;
    private Date    guaranteetime;
    private String  phoneid;

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid;
    }

    private String  guaranteestaus;

    public String getGuaranteestaus() {
        return guaranteestaus;
    }

    public void setGuaranteestaus(String guaranteestaus) {
        this.guaranteestaus = guaranteestaus;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getGuaranteetime() {
        return guaranteetime;
    }

    public void setGuaranteetime(Date guaranteetime) {
        this.guaranteetime = guaranteetime;
    }
}
