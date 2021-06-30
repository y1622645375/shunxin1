package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SxPersonarea {

    private int autoid;
    private String ccompand_id;
    private String cuser_id;
    private BigDecimal xpoint;
    private BigDecimal ypoint;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ddate;
    private String param1;
    private String param2;
    private String param3;
    private String ctype;


    @Override
    public String toString() {
        return "SxPersonarea{" +
                "autoid=" + autoid +
                ", ccompand_id='" + ccompand_id + '\'' +
                ", cuser_id='" + cuser_id + '\'' +
                ", xpoint=" + xpoint +
                ", ypoint=" + ypoint +
                ", ddate=" + ddate +
                ", param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", param3='" + param3 + '\'' +
                ", ctype='" + ctype + '\'' +
                '}';
    }
}
