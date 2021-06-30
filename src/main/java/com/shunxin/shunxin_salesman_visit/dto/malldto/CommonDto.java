package com.shunxin.shunxin_salesman_visit.dto.malldto;


public class CommonDto {

    private int autoid;
    private String cInvCode;
    private String items;
    private String userid;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getcInvCode() {
        return cInvCode;
    }

    public void setcInvCode(String cInvCode) {
        this.cInvCode = cInvCode;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public int getIlogin_type() {
        return ilogin_type;
    }

    public void setIlogin_type(int ilogin_type) {
        this.ilogin_type = ilogin_type;
    }

    @Override
    public String toString() {
        return "CommonDto{" +
                "autoid=" + autoid +
                ", cInvCode='" + cInvCode + '\'' +
                ", items='" + items + '\'' +
                ", userid='" + userid + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
