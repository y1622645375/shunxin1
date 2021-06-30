package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

import java.util.List;

@Data
public class ManageTotal2Dto {
    private String ccus_name;
    private float yps;    //已配送
    private float wsk;    //未收款
    private float ysk;    //已收款
    private List<String> ctype;   //商品或商品


    @Override
    public String toString() {
        return "ManageTotal2Dto{" +
                "ccus_name='" + ccus_name + '\'' +
                ", yps=" + yps +
                ", wsk=" + wsk +
                ", ysk=" + ysk +
                ", ctype=" + ctype +
                '}';
    }
}
