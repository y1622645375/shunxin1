package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class SettleAccountDto {

    private String cjscode;
    private String cpersoncode;
    private String dbegin;
    private String dend;
    private String istate;
    private int iquan;
    private Double imoney;
    private Double iqrmoney;
    private Double ixjmoney;
    private String cmemo;
    private String ccomputer;
    private String cuserid;
    private String ckey;
    private int ilogin_type;

    @Override
    public String toString() {
        return "SettleAccountDto{" +
                "cjscode='" + cjscode + '\'' +
                ", cpersoncode='" + cpersoncode + '\'' +
                ", dbegin='" + dbegin + '\'' +
                ", dend='" + dend + '\'' +
                ", istate='" + istate + '\'' +
                ", iquan=" + iquan +
                ", imoney=" + imoney +
                ", iqrmoney=" + iqrmoney +
                ", ixjmoney=" + ixjmoney +
                ", cmemo='" + cmemo + '\'' +
                ", ccomputer='" + ccomputer + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", ckey='" + ckey + '\'' +
                ", ilogin_type=" + ilogin_type +
                '}';
    }
}
