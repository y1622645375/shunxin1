package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

import java.util.List;

@Data
public class ManageTotalDto {
    private String ccus_name;
    private float yps;    //已配送
    private float wsk;    //未收款
    private float ysk;    //已收款
    private int ctype1;   //商品1
    private int ctype2;   //商品2
    private int ctype3;   //商品3
    private int ctype4;   //商品4
    private int ctype5;   //商品5
    private List<String> ctype;   //商品

    @Override
    public String toString() {
        return "ManageTotalDto{" +
                "ccus_name='" + ccus_name + '\'' +
                ", yps=" + yps +
                ", wsk=" + wsk +
                ", ysk=" + ysk +
                ", ctype1=" + ctype1 +
                ", ctype2=" + ctype2 +
                ", ctype3=" + ctype3 +
                ", ctype4=" + ctype4 +
                ", ctype5=" + ctype5 +
                ", ctype=" + ctype +
                '}';
    }
}
