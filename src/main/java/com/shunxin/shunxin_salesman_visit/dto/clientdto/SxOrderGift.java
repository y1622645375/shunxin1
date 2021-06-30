package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

/**
 * 赠品信息
 */
@Data
public class SxOrderGift {
    private int autoid;
    private String id;
    private String cinvcode;
    private String cinvcode_member;
    private int iquantity;
    private String cdefine28;
    private String cinvname;
    private String cinvstd;
    private String cinvimg;

    @Override
    public String toString() {
        return "SxOrderGift{" +
                "autoid=" + autoid +
                ", id='" + id + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvcode_member='" + cinvcode_member + '\'' +
                ", iquantity=" + iquantity +
                ", cdefine28='" + cdefine28 + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", cinvimg='" + cinvimg + '\'' +
                '}';
    }
}
