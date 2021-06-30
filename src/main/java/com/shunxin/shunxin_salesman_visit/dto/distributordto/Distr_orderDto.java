package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

@Data
public class Distr_orderDto {

    private String csocode;
    private String ddate;
    private String content;
    private String cso_state_sub;
    private String ctype;
    private String ckey;
    private String cuserid;
    private int ilogin_type;
    private String jsonvit;
    private String cdefine3;
    private String ccus_id;
    private String ccuss_id;
    private String courier_xpoint;
    private String courier_ypoint;
    private String code;


    @Override
    public String toString() {
        return "Distr_orderDto{" +
                "csocode='" + csocode + '\'' +
                ", ddate='" + ddate + '\'' +
                ", content='" + content + '\'' +
                ", cso_state_sub='" + cso_state_sub + '\'' +
                ", ctype='" + ctype + '\'' +
                ", ckey='" + ckey + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ilogin_type=" + ilogin_type +
                ", jsonvit='" + jsonvit + '\'' +
                ", cdefine3='" + cdefine3 + '\'' +
                ", ccus_id='" + ccus_id + '\'' +
                ", ccuss_id='" + ccuss_id + '\'' +
                ", courier_xpoint='" + courier_xpoint + '\'' +
                ", courier_ypoint='" + courier_ypoint + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
