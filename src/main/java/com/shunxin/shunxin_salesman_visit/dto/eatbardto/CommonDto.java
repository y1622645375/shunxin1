package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class CommonDto {
    private String scanCode;
    private String wxOpenid;
    private String ap_type;

    @Override
    public String toString() {
        return "CommonDto{" +
                "scanCode='" + scanCode + '\'' +
                ", wxOpenid='" + wxOpenid + '\'' +
                ", ap_type='" + ap_type + '\'' +
                '}';
    }
}

