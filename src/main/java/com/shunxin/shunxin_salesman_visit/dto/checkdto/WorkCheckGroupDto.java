package com.shunxin.shunxin_salesman_visit.dto.checkdto;

import lombok.Data;

@Data
public class WorkCheckGroupDto {
    private int autoid;
    private String cgroupcode;
    private String cgroupname;
    private String cpcode;
    private String ctype;

    @Override
    public String toString() {
        return "WorkCheckGroupDto{" +
                "autoid=" + autoid +
                ", cgroupcode='" + cgroupcode + '\'' +
                ", cgroupname='" + cgroupname + '\'' +
                ", cpcode='" + cpcode + '\'' +
                ", ctype='" + ctype + '\'' +
                '}';
    }
}
