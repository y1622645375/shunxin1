package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import lombok.Data;

@Data
public class Empty {
    private String cinvcode;
    private String cinvname;
    private String cinvstd;
    private int iquan;
    private String cperson_id;


    @Override
    public String toString() {
        return "Empty{" +
                "cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", iquan=" + iquan +
                '}';
    }
}
