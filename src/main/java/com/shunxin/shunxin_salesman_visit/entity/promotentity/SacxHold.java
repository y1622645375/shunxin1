package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import lombok.Data;

@Data
public class SacxHold {
    private String sacxid;
    private String ccustype;    //客户类型编号
    private String ctypename;   //客户类型名称

    @Override
    public String toString() {
        return "SacxHold{" +
                "ccustype='" + ccustype + '\'' +
                ", ctypename='" + ctypename + '\'' +
                '}';
    }
}
