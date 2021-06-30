package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class StatKsCusDto {
    private String cpsnname;
    private int counts;

    @Override
    public String toString() {
        return "StatKsCusDto{" +
                "cpsnname='" + cpsnname + '\'' +
                ", counts=" + counts +
                '}';
    }
}
