package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

@Data
public class CustLevelDto {

    private String clevelid;
    private String clevelname;
    private String cparentid;
    private String isxemallid;

    @Override
    public String toString() {
        return "CustLevelDto{" +
                "clevelid='" + clevelid + '\'' +
                ", clevelname='" + clevelname + '\'' +
                ", cparentid='" + cparentid + '\'' +
                ", isxemallid='" + isxemallid + '\'' +
                '}';
    }
}
