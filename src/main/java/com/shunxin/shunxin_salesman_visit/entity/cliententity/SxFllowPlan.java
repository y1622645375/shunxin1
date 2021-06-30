package com.shunxin.shunxin_salesman_visit.entity.cliententity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 *拜访计划表
 */
public class SxFllowPlan {
    private int autoid;         //ID
    private String cplan_pid;   //业务员id
    private String cplan_comid; //公司id
    private String cplan_cid;   //客户id
    private BigDecimal ccus_xpiont; //经度
    private BigDecimal ccus_ypiont; //纬度
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dplan_time;    //计划拜访日期
    private int bplan_visit;    //是否已拜访,0未拜访，1已拜访
    private int bimg_fromphoto; //是否允许来自于相册

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCplan_pid() {
        return cplan_pid;
    }

    public void setCplan_pid(String cplan_pid) {
        this.cplan_pid = cplan_pid;
    }

    public String getCplan_comid() {
        return cplan_comid;
    }

    public void setCplan_comid(String cplan_comid) {
        this.cplan_comid = cplan_comid;
    }

    public String getCplan_cid() {
        return cplan_cid;
    }

    public void setCplan_cid(String cplan_cid) {
        this.cplan_cid = cplan_cid;
    }

    public BigDecimal getCcus_xpiont() {
        return ccus_xpiont;
    }

    public void setCcus_xpiont(BigDecimal ccus_xpiont) {
        this.ccus_xpiont = ccus_xpiont;
    }

    public BigDecimal getCcus_ypiont() {
        return ccus_ypiont;
    }

    public void setCcus_ypiont(BigDecimal ccus_ypiont) {
        this.ccus_ypiont = ccus_ypiont;
    }

    public Date getDplan_time() {
        return dplan_time;
    }

    public void setDplan_time(Date dplan_time) {
        this.dplan_time = dplan_time;
    }

    public int getBplan_visit() {
        return bplan_visit;
    }

    public void setBplan_visit(int bplan_visit) {
        this.bplan_visit = bplan_visit;
    }

    public int getBimg_fromphoto() {
        return bimg_fromphoto;
    }

    public void setBimg_fromphoto(int bimg_fromphoto) {
        this.bimg_fromphoto = bimg_fromphoto;
    }

    @Override
    public String toString() {
        return "SxFllowPlan{" +
                "autoid=" + autoid +
                ", cplan_pid='" + cplan_pid + '\'' +
                ", cplan_comid='" + cplan_comid + '\'' +
                ", cplan_cid='" + cplan_cid + '\'' +
                ", ccus_xpiont='" + ccus_xpiont + '\'' +
                ", ccus_ypiont='" + ccus_ypiont + '\'' +
                ", dplan_time=" + dplan_time +
                ", bplan_visit=" + bplan_visit +
                ", bimg_fromphoto=" + bimg_fromphoto +
                '}';
    }
}
