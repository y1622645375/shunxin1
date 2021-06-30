package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

@Data
public class AutoChar {
    private String sort1;
    private String sort2;
    private String visits;
    private String plans;
    private String complate;
    private String salepsn;
    private String saleavg;
    private String salemax;
    private String cusonline;
    private String cusall;
    private String cusavg;
    private String vouchpsn;
    private String vouchavg;
    private String vouchmax;

    @Override
    public String toString() {
        return "AutoChar{" +
                "sort1='" + sort1 + '\'' +
                ", sort2='" + sort2 + '\'' +
                ", visits='" + visits + '\'' +
                ", plans='" + plans + '\'' +
                ", complate='" + complate + '\'' +
                ", salepsn='" + salepsn + '\'' +
                ", saleavg='" + saleavg + '\'' +
                ", salemax='" + salemax + '\'' +
                ", cusonline='" + cusonline + '\'' +
                ", cusall='" + cusall + '\'' +
                ", cusavg='" + cusavg + '\'' +
                ", vouchpsn='" + vouchpsn + '\'' +
                ", vouchavg='" + vouchavg + '\'' +
                ", vouchmax='" + vouchmax + '\'' +
                '}';
    }
}
