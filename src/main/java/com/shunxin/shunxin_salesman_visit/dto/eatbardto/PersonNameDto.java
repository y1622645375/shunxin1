package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class PersonNameDto {

     private String ccomcode;
     private String ccode;
     private String cname;

    @Override
    public String toString() {
        return "PersonNameDto{" +
                "ccomcode='" + ccomcode + '\'' +
                ", code='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
