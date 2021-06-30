package com.shunxin.shunxin_salesman_visit.entity.promotentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SxJsqd {

    private int autoid;
    private String cjscode;
    private String csocode;
    private String ccus_name;
    private String cacc_id;
    private String ccompand_id;
    private String cpersoncode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ddate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dbegin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dend;
    private String istate;
    private int iquan;
    private Double imoney;
    private Double iqrmoney;
    private Double ixjmoney;
    private String cmemo;

    @Override
    public String toString() {
        return "SxJsqd{" +
                "autoid=" + autoid +
                ", cjscode='" + cjscode + '\'' +
                ", csocode='" + csocode + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", cacc_id='" + cacc_id + '\'' +
                ", ccompand_id=" + ccompand_id +
                ", cpersoncode='" + cpersoncode + '\'' +
                ", ddate=" + ddate +
                ", dbegin=" + dbegin +
                ", dend=" + dend +
                ", istate='" + istate + '\'' +
                ", iquan=" + iquan +
                ", imoney=" + imoney +
                ", iqrmoney=" + iqrmoney +
                ", ixjmoney=" + ixjmoney +
                ", cmemo='" + cmemo + '\'' +
                '}';
    }
}
