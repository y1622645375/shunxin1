package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class ExaminingDto {
    private String ccus_name;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private String ddate;
    private int iquan_sum;
    private String cname;

    @Override
    public String toString() {
        return "ExaminingDto{" +
                "ccus_name='" + ccus_name + '\'' +
                ", ddate=" + ddate +
                ", iquan_sum=" + iquan_sum +
                ", cname='" + cname + '\'' +
                '}';
    }
}
