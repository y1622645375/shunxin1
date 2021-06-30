package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class StatisalesmanDto {

    private String cperson_name;
    private int ivalue;

    @Override
    public String toString() {
        return "StatisalesmanDto{" +
                "cperson_name='" + cperson_name + '\'' +
                ", ivalue='" + ivalue + '\'' +
                '}';
    }
}
