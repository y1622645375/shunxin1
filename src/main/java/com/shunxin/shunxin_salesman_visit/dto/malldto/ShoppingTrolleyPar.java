package com.shunxin.shunxin_salesman_visit.dto.malldto;

public class ShoppingTrolleyPar {

    private String ctype;       //类型
    private String cuser_id;    //客户ID
    private String cinvcode;    //存货编码
    private int iquan;       //正整数

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCuser_id() {
        return cuser_id;
    }

    public void setCuser_id(String cuser_id) {
        this.cuser_id = cuser_id;
    }

    public String getCinvcode() {
        return cinvcode;
    }

    public void setCinvcode(String cinvcode) {
        this.cinvcode = cinvcode;
    }

    public int getIquan() {
        return iquan;
    }

    public void setIquan(int iquan) {
        this.iquan = iquan;
    }

    @Override
    public String toString() {
        return "ShoppingTrolleyPar{" +
                "ctype='" + ctype + '\'' +
                ", cuser_id='" + cuser_id + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iquan='" + iquan + '\'' +
                '}';
    }
}
