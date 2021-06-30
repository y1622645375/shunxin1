package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class SoorderDto {
    private String autoid;
    private String csocode;
    private String cperson_id;
    private String ddate;
    private String cstate;
    private String ccus_id;
    private String csotype;
    private String cinvcode;
    private String iquantity;
    private String iprice;
    private String imoney;
    private String ctype;
    private String jsonvist;
    private String ccode;
    private String ddate1;
    private String ddate2;

    @Override
    public String toString() {
        return "SoorderDto{" +
                "autoid='" + autoid + '\'' +
                ", csocode='" + csocode + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", ddate='" + ddate + '\'' +
                ", cstate='" + cstate + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", csotype='" + csotype + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", iquantity='" + iquantity + '\'' +
                ", iprice='" + iprice + '\'' +
                ", imoney='" + imoney + '\'' +
                ", ctype='" + ctype + '\'' +
                ", jsonvist='" + jsonvist + '\'' +
                ", ccode='" + ccode + '\'' +
                ", ddate1='" + ddate1 + '\'' +
                ", ddate2='" + ddate2 + '\'' +
                '}';
    }
}
