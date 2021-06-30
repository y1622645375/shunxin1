package com.shunxin.shunxin_salesman_visit.dto.malldto;

import lombok.Data;

@Data
public class SxOrderDto {
    private String cinvcode;
    private String csocode;
    private int iquantity;
    private Float imoney;
    private String cInvName;
    private String cInvStd;
    private String iprice;

    @Override
    public String toString() {
        return "SxOrderDto{" +
                "cinvcode='" + cinvcode + '\'' +
                ", csocode='" + csocode + '\'' +
                ", iquantity=" + iquantity +
                ", imoney=" + imoney +
                ", cInvName='" + cInvName + '\'' +
                ", cInvStd='" + cInvStd + '\'' +
                ", iprice='" + iprice + '\'' +
                '}';
    }
}
