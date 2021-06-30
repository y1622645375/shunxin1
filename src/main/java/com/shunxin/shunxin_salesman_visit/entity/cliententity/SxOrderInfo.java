package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

@Data
public class SxOrderInfo {
    private String csocode;
    private String ddate;
    private String ccus_name;
    private String cperson_name;
    private String imoney_sum;
    private String bprint;
    private String printmsg;

    @Override
    public String toString() {
        return "SxOrderInfo{" +
                "csocode='" + csocode + '\'' +
                ", ddate='" + ddate + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", imoney_sum='" + imoney_sum + '\'' +
                ", bprint='" + bprint + '\'' +
                ", printmsg='" + printmsg + '\'' +
                '}';
    }
}
