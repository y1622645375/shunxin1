package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import lombok.Data;

@Data
public class SxCharges {
    private String ccode2;
    private String cname2;

    @Override
    public String toString() {
        return "SxCharges{" +
                "ccode2='" + ccode2 + '\'' +
                ", cname2='" + cname2 + '\'' +
                '}';
    }
}
