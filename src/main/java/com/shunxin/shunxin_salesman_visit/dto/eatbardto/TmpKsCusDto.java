package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TmpKsCusDto {
    private int autoid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ddate;
    private String ccusname;
    private String ccomname;
    private String cpsnname;
    private String cstate;

    @Override
    public String toString() {
        return "TmpKsCusDto{" +
                "autoid=" + autoid +
                ", ddate=" + ddate +
                ", ccusname='" + ccusname + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cpsnname='" + cpsnname + '\'' +
                ", cstate='" + cstate + '\'' +
                '}';
    }
}
