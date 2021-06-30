package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FllowVisitinfoDto {

    private int autoid;
    private int ipagecount;
    private int rownum;
    private String ccus_address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dfllow_end_time;
    private String ccus_name;
    private String dfllow_visit_time;
    private String ifllow_space;
    private int ifllow_bplan;
    private String cfllow_pid;
    private BigDecimal cfllow_xpoint;
    private BigDecimal cfllow_ypoint;
    private String cname;
    private String cfllow_memo;
    private String ccomcode;
    private String ccomname;
    private String fllowid;
    private String img1_1;
    private String img1_2;
    private String img1_3;
    private String img1_4;
    private String img1_5;
    private String img2_1;
    private String img2_2;
    private String img2_3;
    private String img2_4;
    private String img2_5;
    private String img3_1;
    private String img3_2;
    private String img3_3;
    private String img3_4;
    private String img3_5;
    private String img4_1;
    private String img4_2;
    private String img4_3;
    private String img4_4;
    private String img4_5;
    private int isalesum;
    private String cdepname;

    @Override
    public String toString() {
        return "FllowVisitinfoDto{" +
                "autoid=" + autoid +
                ", ipagecount=" + ipagecount +
                ", rownum=" + rownum +
                ", ccus_address='" + ccus_address + '\'' +
                ", dfllow_start_time=" + dfllow_start_time +
                ", dfllow_end_time=" + dfllow_end_time +
                ", ccus_name='" + ccus_name + '\'' +
                ", dfllow_visit_time='" + dfllow_visit_time + '\'' +
                ", ifllow_space='" + ifllow_space + '\'' +
                ", ifllow_bplan=" + ifllow_bplan +
                ", cfllow_pid='" + cfllow_pid + '\'' +
                ", cfllow_xpoint=" + cfllow_xpoint +
                ", cfllow_ypoint=" + cfllow_ypoint +
                ", cname='" + cname + '\'' +
                ", cfllow_memo='" + cfllow_memo + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", fllowid='" + fllowid + '\'' +
                ", img1_1='" + img1_1 + '\'' +
                ", img1_2='" + img1_2 + '\'' +
                ", img1_3='" + img1_3 + '\'' +
                ", img1_4='" + img1_4 + '\'' +
                ", img1_5='" + img1_5 + '\'' +
                ", img2_1='" + img2_1 + '\'' +
                ", img2_2='" + img2_2 + '\'' +
                ", img2_3='" + img2_3 + '\'' +
                ", img2_4='" + img2_4 + '\'' +
                ", img2_5='" + img2_5 + '\'' +
                ", img3_1='" + img3_1 + '\'' +
                ", img3_2='" + img3_2 + '\'' +
                ", img3_3='" + img3_3 + '\'' +
                ", img3_4='" + img3_4 + '\'' +
                ", img3_5='" + img3_5 + '\'' +
                ", img4_1='" + img4_1 + '\'' +
                ", img4_2='" + img4_2 + '\'' +
                ", img4_3='" + img4_3 + '\'' +
                ", img4_4='" + img4_4 + '\'' +
                ", img4_5='" + img4_5 + '\'' +
                ", isalesum=" + isalesum +
                ", cdepname='" + cdepname + '\'' +
                '}';
    }
}
