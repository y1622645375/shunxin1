package com.shunxin.shunxin_salesman_visit.entity.checkentity;

import lombok.Data;

@Data
public class Workcheck {
    private String cname;
    private String cpersoncode;
    private String dchecktype;
    private int counts;

    @Override
    public String toString() {
        return "Workcheck{" +
                "cname='" + cname + '\'' +
                ", cpersoncode='" + cpersoncode + '\'' +
                ", dchecktype='" + dchecktype + '\'' +
                ", counts=" + counts +
                '}';
    }
}
