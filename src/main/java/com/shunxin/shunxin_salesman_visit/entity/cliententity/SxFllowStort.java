package com.shunxin.shunxin_salesman_visit.entity.cliententity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *商品信息
 */
public class SxFllowStort {
    private int autoid;         //ID
    private String fllowid;     //拜访主表ID，fllow_
    private String cinvcode;    //商品编码
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dinvdate;      //商品的到期日期
    private float iinvquan;     //商品数量
    private String cinvemo;     //备注

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getFllowid() {
        return fllowid;
    }

    public void setFllowid(String fllowid) {
        this.fllowid = fllowid;
    }

    public String getCinvcode() {
        return cinvcode;
    }

    public void setCinvcode(String cinvcode) {
        this.cinvcode = cinvcode;
    }

    public Date getDinvdate() {
        return dinvdate;
    }

    public void setDinvdate(Date dinvdate) {
        this.dinvdate = dinvdate;
    }

    public float getIinvquan() {
        return iinvquan;
    }

    public void setIinvquan(float iinvquan) {
        this.iinvquan = iinvquan;
    }

    public String getCinvemo() {
        return cinvemo;
    }

    public void setCinvemo(String cinvemo) {
        this.cinvemo = cinvemo;
    }

    @Override
    public String toString() {
        return "SxFllowStort{" +
                "autoid=" + autoid +
                ", fllowid='" + fllowid + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", dinvdate=" + dinvdate +
                ", iinvquan=" + iinvquan +
                ", cinvemo='" + cinvemo + '\'' +
                '}';
    }
}
