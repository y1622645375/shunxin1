package com.shunxin.shunxin_salesman_visit.dto.clientdto;

public class SalesmanDto {
    private String ccode;
    private String cname;
    private String ccomcode;
    private String ccomname;
    private String cdepname;
    private String cryzt;
    private String cuscount;


    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcomcode() {
        return ccomcode;
    }

    public void setCcomcode(String ccomcode) {
        this.ccomcode = ccomcode;
    }

    public String getCcomname() {
        return ccomname;
    }

    public void setCcomname(String ccomname) {
        this.ccomname = ccomname;
    }

    public String getCdepname() {
        return cdepname;
    }

    public void setCdepname(String cdepname) {
        this.cdepname = cdepname;
    }

    public String getCryzt() {
        return cryzt;
    }

    public void setCryzt(String cryzt) {
        this.cryzt = cryzt;
    }

    public String getCuscount() {
        return cuscount;
    }

    public void setCuscount(String cuscount) {
        this.cuscount = cuscount;
    }

    @Override
    public String toString() {
        return "SalesmanDto{" +
                "ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cdepname='" + cdepname + '\'' +
                ", cryzt='" + cryzt + '\'' +
                ", cuscount='" + cuscount + '\'' +
                '}';
    }
}
