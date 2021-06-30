package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 历史价格表（非正式价格表）
 */
@Data
public class PriceEnterLog {

    private int autoid;
    private int iext_id;                //审核通过后填正式表的autoid
    private String ccomcode;            //公司编号
    private String cuser_id;            //录入人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;                 //录入日期
    private String cinvcode;            //存货编码
    private String ccus_level;          //客户级别
    private BigDecimal ccus_price;      //新的价格
    private Float igoldrate;            //现积分率
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddateb;                //现开始日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddatee;                //现结束日期
    private String cchecker;            //审核人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dcheck;                //审核时间
    private String ccloser;             //关闭人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dclose;                //关闭时间
    private String cmemo;               //备注（新增价格或禁用价格）
    private String ccomname;
    private String cinvname;
    private String cinvstd;
    private String clevelname;
    private String checktepy;
    private String ddates;
    private String cperson_id;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    @Override
    public String toString() {
        return "PriceEnterLog{" +
                "autoid=" + autoid +
                ", iext_id=" + iext_id +
                ", ccomcode='" + ccomcode + '\'' +
                ", cuser_id='" + cuser_id + '\'' +
                ", ddate=" + ddate +
                ", cinvcode='" + cinvcode + '\'' +
                ", ccus_level='" + ccus_level + '\'' +
                ", ccus_price=" + ccus_price +
                ", igoldrate=" + igoldrate +
                ", ddateb=" + ddateb +
                ", ddatee=" + ddatee +
                ", cchecker='" + cchecker + '\'' +
                ", dcheck=" + dcheck +
                ", ccloser='" + ccloser + '\'' +
                ", dclose=" + dclose +
                ", cmemo='" + cmemo + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", cinvstd='" + cinvstd + '\'' +
                ", clevelname='" + clevelname + '\'' +
                ", checktepy='" + checktepy + '\'' +
                ", ddates='" + ddates + '\'' +
                ", cperson_id='" + cperson_id + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
