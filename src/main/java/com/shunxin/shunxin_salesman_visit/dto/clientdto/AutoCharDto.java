package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class AutoCharDto {
    String ctype;
    String userid;
    String ddate1;
    String ddate2;

    @Override
    public String toString() {
        return "AutoCharDto{" +
                "ctype='" + ctype + '\'' +
                ", userid='" + userid + '\'' +
                ", ddate1='" + ddate1 + '\'' +
                ", ddate2='" + ddate2 + '\'' +
                '}';
    }
}
