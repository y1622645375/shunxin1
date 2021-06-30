package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import lombok.Data;

import java.util.Date;

@Data
public class AppDinwei {
    private String cname;
    private int autoid;
    private String cuser_id;
    private Date ddate;
    private String logs;
    private String itype;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;

    @Override
    public String toString() {
        return "AppDinwei{" +
                "cname='" + cname + '\'' +
                ", autoid=" + autoid +
                ", cuser_id='" + cuser_id + '\'' +
                ", ddate=" + ddate +
                ", logs='" + logs + '\'' +
                ", itype='" + itype + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", param3='" + param3 + '\'' +
                ", param4='" + param4 + '\'' +
                ", param5='" + param5 + '\'' +
                '}';
    }
}
