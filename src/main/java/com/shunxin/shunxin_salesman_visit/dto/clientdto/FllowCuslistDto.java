package com.shunxin.shunxin_salesman_visit.dto.clientdto;

/**
 * 今日应拜访客户列表（视图生成）
 */
public class FllowCuslistDto {
    private int autoid;
    private String ccus_name;       //店铺名称
    private String ccus_address;    //店铺地址
    private String ccus_person;     //店主名称
    private String ccus_account;      //店主联系电话
    private int distance;           //距离（米）
    private String bplan;           //计划内外
    private String bvisit;          //是否已拜访
    private String bimg_fromphoto;  // 0 只能相机 1 拍照相机都可以
    private String bcheckman;


    public FllowCuslistDto() {
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCcus_name() {
        return ccus_name;
    }

    public void setCcus_name(String ccus_name) {
        this.ccus_name = ccus_name;
    }

    public String getCcus_address() {
        return ccus_address;
    }

    public void setCcus_address(String ccus_address) {
        this.ccus_address = ccus_address;
    }

    public String getCcus_person() {
        return ccus_person;
    }

    public void setCcus_person(String ccus_person) {
        this.ccus_person = ccus_person;
    }

    public String getCcus_account() {
        return ccus_account;
    }

    public void setCcus_account(String ccus_account) {
        this.ccus_account = ccus_account;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getBplan() {
        return bplan;
    }

    public void setBplan(String bplan) {
        this.bplan = bplan;
    }

    public String getBvisit() {
        return bvisit;
    }

    public void setBvisit(String bvisit) {
        this.bvisit = bvisit;
    }

    public String getBimg_fromphoto() {
        return bimg_fromphoto;
    }

    public void setBimg_fromphoto(String bimg_fromphoto) {
        this.bimg_fromphoto = bimg_fromphoto;
    }

    public String getBcheckman() {
        return bcheckman;
    }

    public void setBcheckman(String bcheckman) {
        this.bcheckman = bcheckman;
    }

    @Override
    public String toString() {
        return "FllowCuslistDto{" +
                "autoid=" + autoid +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_address='" + ccus_address + '\'' +
                ", ccus_person='" + ccus_person + '\'' +
                ", ccus_account='" + ccus_account + '\'' +
                ", distance=" + distance +
                ", bplan='" + bplan + '\'' +
                ", bvisit='" + bvisit + '\'' +
                ", bimg_fromphoto='" + bimg_fromphoto + '\'' +
                ", bcheckman='" + bcheckman + '\'' +
                '}';
    }
}
