package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class WxgzFllowVist {

    private int autoid;
    private String ccus_address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dfllow_start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dfllow_end_time;
    private String ccus_name;
    private String dfllow_visit_time;
    private int ifllow_space;
    private int ifllow_bplan;
    private String cfllow_pid;
    private BigDecimal cfllow_xpoint;
    private BigDecimal cfllow_ypoint;
    private String cname;
    private String cfllow_memo;
    private String ccomcode;
    private String ccomname;
    private String cdepcode;
    private String cdepname;
    private String cfllow_cid;
    private List<String> cimg_path;
    private String integral_result;

    @Override
    public String toString() {
        return "WxgzFllowVist{" +
                "autoid=" + autoid +
                ", ccus_address='" + ccus_address + '\'' +
                ", dfllow_start_time=" + dfllow_start_time +
                ", dfllow_end_time=" + dfllow_end_time +
                ", ccus_name='" + ccus_name + '\'' +
                ", dfllow_visit_time='" + dfllow_visit_time + '\'' +
                ", ifllow_space=" + ifllow_space +
                ", ifllow_bplan=" + ifllow_bplan +
                ", cfllow_pid='" + cfllow_pid + '\'' +
                ", cfllow_xpoint=" + cfllow_xpoint +
                ", cfllow_ypoint=" + cfllow_ypoint +
                ", cname='" + cname + '\'' +
                ", cfllow_memo='" + cfllow_memo + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cdepcode='" + cdepcode + '\'' +
                ", cdepname='" + cdepname + '\'' +
                ", cfllow_cid='" + cfllow_cid + '\'' +
                ", cimg_path=" + cimg_path +
                ", integral_result='" + integral_result + '\'' +
                '}';
    }
}
