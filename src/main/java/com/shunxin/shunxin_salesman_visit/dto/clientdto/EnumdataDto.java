package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class EnumdataDto {
    private String ccode;
    private String cclass;
    private String cname;

    @Override
    public String toString() {
        return "EnumdataDto{" +
                "ccode='" + ccode + '\'' +
                ", cclass='" + cclass + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
