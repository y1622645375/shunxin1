package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class wxlogindataDto {
    private int lefttime;
    private String ckey;
    private String copenid;

    @Override
    public String toString() {
        return "wxlogindataDto{" +
                "lefttime=" + lefttime +
                ", ckey='" + ckey + '\'' +
                ", copenid='" + copenid + '\'' +
                '}';
    }
}
