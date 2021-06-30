package com.shunxin.shunxin_salesman_visit.dto.clientdto;

public class FllowTotalDto {

    private String dtotal_time;
    private String ctotal;

    public String getDtotal_time() {
        return dtotal_time;
    }

    public void setDtotal_time(String dtotal_time) {
        this.dtotal_time = dtotal_time;
    }

    public String getCtotal() {
        return ctotal;
    }

    public void setCtotal(String ctotal) {
        this.ctotal = ctotal;
    }

    @Override
    public String toString() {
        return "FllowTotalDto{" +
                "dtotal_time='" + dtotal_time + '\'' +
                ", ctotal='" + ctotal + '\'' +
                '}';
    }
}
