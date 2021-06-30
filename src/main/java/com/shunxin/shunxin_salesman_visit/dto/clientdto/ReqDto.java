package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ReqDto {
    private String autoid;          //ID
    private String userid;          //业务员Id
    private String ccus_name;       //店铺名称
    private String ccus_status;     //店铺状态
    private String logintype;       //登录渠道（APP或者WX）
    private String ckey;            //访问接口需要的key
    private BigDecimal xpiont;      //维度
    private BigDecimal ypiont;      //经度
    private int bplan;    //是否计划内拜访，0计划内1计划外
    private String ctype;           //ccuslevel客户级别,ccustype客户类型,inventory商品（不同的参数得到不同的结果）
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dplan_time;        //拜访日期
    private String jsonvisit;
    private String tables_name;
    private String openid;
    private String cperson_id;
    private String cinvccode;       //商品分类编号
    private String cuserid;
    private int ilogin_type;
    private String photos;
    private String ccus_id;  //店铺id
    private String cfllow_cid;
    private String cfllow_pid;

    public String getCfllow_cid() {
        return cfllow_cid;
    }

    public void setCfllow_cid(String cfllow_cid) {
        this.cfllow_cid = cfllow_cid;
    }

    public String getCfllow_pid() {
        return cfllow_pid;
    }

    public void setCfllow_pid(String cfllow_pid) {
        this.cfllow_pid = cfllow_pid;
    }

    public String getCinvccode() {
        return cinvccode;
    }

    public void setCinvccode(String cinvccode) {
        this.cinvccode = cinvccode;
    }

    public ReqDto() {
    }

    public String getJsonvisit() {
        return jsonvisit;
    }

    public void setJsonvisit(String jsonvisit) {
        this.jsonvisit = jsonvisit;
    }

    public ReqDto(String userid) {
        this.userid = userid;
    }

    public String getAutoid() {
        return autoid;
    }

    public void setAutoid(String autoid) {
        this.autoid = autoid;
    }

    public String getCcus_status() {
        return ccus_status;
    }

    public void setCcus_status(String ccus_status) {
        this.ccus_status = ccus_status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCcus_name() {
        return ccus_name;
    }

    public void setCcus_name(String ccus_name) {
        this.ccus_name = ccus_name;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public BigDecimal getXpiont() {
        return xpiont;
    }

    public void setXpiont(BigDecimal xpiont) {
        this.xpiont = xpiont;
    }

    public BigDecimal getYpiont() {
        return ypiont;
    }

    public void setYpiont(BigDecimal ypiont) {
        this.ypiont = ypiont;
    }

    public int getBplan() {
        return bplan;
    }

    public void setBplan(int bplan) {
        this.bplan = bplan;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public Date getDplan_time() {
        return dplan_time;
    }

    public void setDplan_time(Date dplan_time) {
        this.dplan_time = dplan_time;
    }

    public String getTables_name() {
        return tables_name;
    }

    public void setTables_name(String tables_name) {
        this.tables_name = tables_name;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCperson_id() {
        return cperson_id;
    }

    public void setCperson_id(String cperson_id) {
        this.cperson_id = cperson_id;
    }


    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }

    public int getIlogin_type() {
        return ilogin_type;
    }

    public void setIlogin_type(int ilogin_type) {
        this.ilogin_type = ilogin_type;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getCcus_id() {
        return ccus_id;
    }

    public void setCcus_id(String ccus_id) {
        this.ccus_id = ccus_id;
    }

    @Override
    public String toString() {
        return "ReqDto{" +
                "autoid='" + autoid + '\'' +
                ", userid='" + userid + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_status='" + ccus_status + '\'' +
                ", logintype='" + logintype + '\'' +
                ", ckey='" + ckey + '\'' +
                ", xpiont=" + xpiont +
                ", ypiont=" + ypiont +
                ", bplan=" + bplan +
                ", ctype='" + ctype + '\'' +
                ", dplan_time=" + dplan_time +
                ", jsonvisit='" + jsonvisit + '\'' +
                ", tables_name='" + tables_name + '\'' +
                ", openid='" + openid + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cinvccode='" + cinvccode + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
