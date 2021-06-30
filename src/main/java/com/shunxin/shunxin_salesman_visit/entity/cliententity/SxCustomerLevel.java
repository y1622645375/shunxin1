package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 客户级别表
 */
public class SxCustomerLevel {
    private int autoid;         //ID
    private String clevelid;    //客户级别ID
    private String clevelname;  //级别名称
    private int ilevel_grade;   //客户级别级次，1级2级
    private String cparentid;   //父级ID,如本身为1级则置0
    private int isortid;        //排序ID
    private int bclose;         //是否作废，0生效，1关闭
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dcreate_time;  //建立时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dclose_time;   //关闭时间
    private String ccompany_id; //所属公司ID，可能要考虑公司专属级别，暂为空表示公共级别

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getClevelid() {
        return clevelid;
    }

    public void setClevelid(String clevelid) {
        this.clevelid = clevelid;
    }

    public String getClevelname() {
        return clevelname;
    }

    public void setClevelname(String clevelname) {
        this.clevelname = clevelname;
    }

    public int getIlevel_grade() {
        return ilevel_grade;
    }

    public void setIlevel_grade(int ilevel_grade) {
        this.ilevel_grade = ilevel_grade;
    }

    public String getCparentid() {
        return cparentid;
    }

    public void setCparentid(String cparentid) {
        this.cparentid = cparentid;
    }

    public int getIsortid() {
        return isortid;
    }

    public void setIsortid(int isortid) {
        this.isortid = isortid;
    }

    public int getBclose() {
        return bclose;
    }

    public void setBclose(int bclose) {
        this.bclose = bclose;
    }

    public Date getDcreate_time() {
        return dcreate_time;
    }

    public void setDcreate_time(Date dcreate_time) {
        this.dcreate_time = dcreate_time;
    }

    public Date getDclose_time() {
        return dclose_time;
    }

    public void setDclose_time(Date dclose_time) {
        this.dclose_time = dclose_time;
    }

    public String getCcompany_id() {
        return ccompany_id;
    }

    public void setCcompany_id(String ccompany_id) {
        this.ccompany_id = ccompany_id;
    }

    @Override
    public String toString() {
        return "SxCustomerLevel{" +
                "autoid=" + autoid +
                ", clevelid='" + clevelid + '\'' +
                ", clevelname='" + clevelname + '\'' +
                ", ilevel_grade=" + ilevel_grade +
                ", cparentid='" + cparentid + '\'' +
                ", isortid=" + isortid +
                ", bclose=" + bclose +
                ", dcreate_time=" + dcreate_time +
                ", dclose_time=" + dclose_time +
                ", ccompany_id='" + ccompany_id + '\'' +
                '}';
    }
}
