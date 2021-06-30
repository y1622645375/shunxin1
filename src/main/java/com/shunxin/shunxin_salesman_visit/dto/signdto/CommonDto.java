package com.shunxin.shunxin_salesman_visit.dto.signdto;

import lombok.Data;

@Data
public class CommonDto {
    private String ckey;
    private String integral_cid;
    private String csign_cid;
    private String jsonvisit;
    private String integral_type;
    private String cfllow_cid;
    private String ccusid;
    private String device_id;
    private String unionid;

    @Override
    public String toString() {
        return "CommonDto{" +
                "ckey='" + ckey + '\'' +
                ", integral_cid='" + integral_cid + '\'' +
                ", csign_cid='" + csign_cid + '\'' +
                ", jsonvisit='" + jsonvisit + '\'' +
                ", integral_type='" + integral_type + '\'' +
                ", cfllow_cid='" + cfllow_cid + '\'' +
                ", ccusid='" + ccusid + '\'' +
                ", device_id='" + device_id + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
