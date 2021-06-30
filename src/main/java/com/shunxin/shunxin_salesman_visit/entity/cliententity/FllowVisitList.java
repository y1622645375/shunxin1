package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/5/28
 */
@Data
public class FllowVisitList {
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
    /*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;   //刷新时间
    private BigDecimal centre_lat;  //地图中心点的纬度
    private BigDecimal centre_lng;  //地图中心点的经度*/

    @Override
    public String toString() {
        return "FllowVisitList{" +
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
                '}';
    }
}
