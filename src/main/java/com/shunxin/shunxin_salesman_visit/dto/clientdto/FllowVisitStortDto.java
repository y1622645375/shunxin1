package com.shunxin.shunxin_salesman_visit.dto.clientdto;


public class FllowVisitStortDto {

    private int autoid;
    private String cinvcname;
    private String cinvcode;
    private String cinvname;
    private String dinvdate;
    private String iinvquan;
    private String cinvmemo;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCinvcname() {
        return cinvcname;
    }

    public void setCinvcname(String cinvcname) {
        this.cinvcname = cinvcname;
    }

    public String getCinvcode() {
        return cinvcode;
    }

    public void setCinvcode(String cinvcode) {
        this.cinvcode = cinvcode;
    }

    public String getCinvname() {
        return cinvname;
    }

    public void setCinvname(String cinvname) {
        this.cinvname = cinvname;
    }

    public String getDinvdate() {
        return dinvdate;
    }

    public void setDinvdate(String dinvdate) {
        this.dinvdate = dinvdate;
    }

    public String getIinvquan() {
        return iinvquan;
    }

    public void setIinvquan(String iinvquan) {
        this.iinvquan = iinvquan;
    }

    public String getCinvmemo() {
        return cinvmemo;
    }

    public void setCinvmemo(String cinvmemo) {
        this.cinvmemo = cinvmemo;
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
        return "FllowVisitStortDto{" +
                "autoid=" + autoid +
                ", cinvcname='" + cinvcname + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", dinvdate='" + dinvdate + '\'' +
                ", iinvquan='" + iinvquan + '\'' +
                ", cinvmemo='" + cinvmemo + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
