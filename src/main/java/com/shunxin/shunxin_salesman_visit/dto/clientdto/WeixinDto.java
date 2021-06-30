package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class WeixinDto {

    private String openid;
    private String ccode;

    @Override
    public String toString() {
        return "WeixinDto{" +
                "openid='" + openid + '\'' +
                ", ccode='" + ccode + '\'' +
                '}';
    }
}
