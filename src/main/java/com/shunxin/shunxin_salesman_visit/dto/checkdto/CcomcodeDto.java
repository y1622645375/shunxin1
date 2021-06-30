package com.shunxin.shunxin_salesman_visit.dto.checkdto;

import lombok.Data;

@Data
public class CcomcodeDto {
    private String ccode;
    private Double counts;
    private String cworkrule;
    private String cpersoncode;

    @Override
    public String toString() {
        return "CcomcodeDto{" +
                "ccode='" + ccode + '\'' +
                ", counts=" + counts +
                ", cworkrule='" + cworkrule + '\'' +
                ", cpersoncode='" + cpersoncode + '\'' +
                '}';
    }
}
