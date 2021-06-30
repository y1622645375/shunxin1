package com.shunxin.shunxin_salesman_visit.dto.malldto;

public class InventoryPar {

    private String ctype;
    private String cuser_id;
    private String ctext;

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

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }


    @Override
    public String toString() {
        return "InventoryPar{" +
                "ctype='" + ctype + '\'' +
                ", cuser_id='" + cuser_id + '\'' +
                ", ctext='" + ctext + '\'' +
                '}';
    }
}
