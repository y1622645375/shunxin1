package com.shunxin.shunxin_salesman_visit.dto.clientdto;

public class FllowCheckDto {
    private int autoid;
    private String cuser_id;
    private String cchecktext;

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCuser_id() {
        return cuser_id;
    }

    public void setCuser_id(String cuser_id) {
        this.cuser_id = cuser_id;
    }

    public String getCchecktext() {
        return cchecktext;
    }

    public void setCchecktext(String cchecktext) {
        this.cchecktext = cchecktext;
    }

    @Override
    public String toString() {
        return "FllowCheckDto{" +
                "autoid=" + autoid +
                ", cuser_id='" + cuser_id + '\'' +
                ", cchecktext='" + cchecktext + '\'' +
                '}';
    }
}
