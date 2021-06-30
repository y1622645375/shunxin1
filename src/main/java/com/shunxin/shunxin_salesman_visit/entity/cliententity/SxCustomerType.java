package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 客户类型表
 */
public class SxCustomerType {
    private int autoid;         //ID
    private String ctypeid;     //客户类型ID
    private String ctypename;   //类型名称
    private int itype_grade;    //客户类型类次
    private String cparentid;   //父级ID
    private int isortid;        //排序ID
    private int bclose;         //是否作废，0生效，1关闭
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dcreate_time;  //建立时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dclose_time;   //关闭时间

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCtypeid() {
        return ctypeid;
    }

    public void setCtypeid(String ctypeid) {
        this.ctypeid = ctypeid;
    }

    public String getCtypename() {
        return ctypename;
    }

    public void setCtypename(String ctypename) {
        this.ctypename = ctypename;
    }

    public int getItype_grade() {
        return itype_grade;
    }

    public void setItype_grade(int itype_grade) {
        this.itype_grade = itype_grade;
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

    @Override
    public String toString() {
        return "SxCustomerType{" +
                "autoid=" + autoid +
                ", ctypeid='" + ctypeid + '\'' +
                ", ctypename='" + ctypename + '\'' +
                ", itype_grade=" + itype_grade +
                ", cparentid='" + cparentid + '\'' +
                ", isortid=" + isortid +
                ", bclose=" + bclose +
                ", dcreate_time=" + dcreate_time +
                ", dclose_time=" + dclose_time +
                '}';
    }
}
