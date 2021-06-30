package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.FllowImgDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/4/29
 */
@Data
public class TempFllowVisit {
    private String autoid;
    private String cperson_name;
    private String cfllow_cid;      //店铺id
    private String ccus_name;       //店铺名称
    private String ccus_address;    //店铺地址
    private String cfllow_pid;      //员工id
    private String cname;           //员工姓名
    private String cfllow_comid;    //公司id
    private String cccus_xpoint;    //店铺经度
    private String cccus_ypoint;    //店铺纬度
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dfllow_start_time;   //拜访开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dfllow_end_time;     //拜访结束时间
    private String cfllow_memo;       //备注
    private List<FllowImgDto> FllowImglist; //拜访图片
    private String cdefine1;    //门店 1为合格 0为不合格
    private String cdefine2;    //陈列
    private String cdefine3;    //冰柜
    private String cdefine4;    //货架

    @Override
    public String toString() {
        return "TempFllowVisit{" +
                "autoid='" + autoid + '\'' +
                ", cperson_name='" + cperson_name + '\'' +
                ", cfllow_cid='" + cfllow_cid + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccus_address='" + ccus_address + '\'' +
                ", cfllow_pid='" + cfllow_pid + '\'' +
                ", cname='" + cname + '\'' +
                ", cfllow_comid='" + cfllow_comid + '\'' +
                ", cccus_xpoint='" + cccus_xpoint + '\'' +
                ", cccus_ypoint='" + cccus_ypoint + '\'' +
                ", dfllow_start_time=" + dfllow_start_time +
                ", dfllow_end_time=" + dfllow_end_time +
                ", cfllow_memo='" + cfllow_memo + '\'' +
                ", FllowImglist=" + FllowImglist +
                '}';
    }
}
