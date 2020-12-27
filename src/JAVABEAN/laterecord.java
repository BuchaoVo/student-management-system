package JAVABEAN;

import java.util.Date;

public class laterecord {
    private String  studentname;
    private String  dormitoryid;
    private Date    latetime;
    private String  reason;

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public Date getLatetime() {
        return latetime;
    }

    public void setLatetime(Date latetime) {
        this.latetime = latetime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
