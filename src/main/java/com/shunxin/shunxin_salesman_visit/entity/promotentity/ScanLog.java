package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ScanLog {
    private int autoid;
    private String param1;
    private String cname;
    private String param3;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;
    private String cuname;
    private String param5;
    private String param2;
    private String param4;

    @Override
    public String toString() {
        return "ScanLog{" +
                "autoid=" + autoid +
                ", param1='" + param1 + '\'' +
                ", cname='" + cname + '\'' +
                ", param3='" + param3 + '\'' +
                ", ddate=" + ddate +
                ", cuname='" + cuname + '\'' +
                ", param5='" + param5 + '\'' +
                ", param2='" + param2 + '\'' +
                ", param4='" + param4 + '\'' +
                '}';
    }
}
