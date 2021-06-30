package com.shunxin.shunxin_salesman_visit.dto.checkdto;

import lombok.Data;

@Data
public class punchDto {
    private String opencheckindatatype;
    private Long starttime;
    private Long endtime;

    @Override
    public String toString() {
        return "punchDto{" +
                "opencheckindatatype='" + opencheckindatatype + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}
