package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Promotion {

    private String sacxid;      //活动编号
    private String sacxname;    //活动名称
    private String ccomcode;    //公司编号
    private String ccomname;    //公司名称
    private String sacximg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dbegin;        //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dend;          //结束时间
    private int iquan;
    private int istate;         //审核状态(0表示录入未审核，1表示已审核生效，9表示作废)
    private String cstate;      //
    private String sacxtype;    //是否累计买赠（0表示累计计算买赠，1表示不累计计算买赠）
    private String csacxstate;
    private String cinvcode;    //商品编号
    private String cinvname;    //商品名称
    private String csamemo;     //备注（该买赠活动的说明等）
    private String sacxtext;
    private String izpgroup;    //买赠深度(10为最高深度)
    private List<SacxHold> sacxHolds;
    private List<ZpcinvCode> zpcinvCodes;

    @Override
    public String toString() {
        return "Promotion{" +
                "sacxid='" + sacxid + '\'' +
                ", sacxname='" + sacxname + '\'' +
                ", ccomcode='" + ccomcode + '\'' +
                ", ccomname='" + ccomname + '\'' +
                ", sacximg='" + sacximg + '\'' +
                ", dbegin=" + dbegin +
                ", dend=" + dend +
                ", iquan=" + iquan +
                ", istate=" + istate +
                ", cstate='" + cstate + '\'' +
                ", sacxtype='" + sacxtype + '\'' +
                ", csacxstate='" + csacxstate + '\'' +
                ", cinvcode='" + cinvcode + '\'' +
                ", cinvname='" + cinvname + '\'' +
                ", csamemo='" + csamemo + '\'' +
                ", sacxtext='" + sacxtext + '\'' +
                ", izpgroup='" + izpgroup + '\'' +
                ", sacxHolds=" + sacxHolds +
                ", zpcinvCodes=" + zpcinvCodes +
                '}';
    }
}
