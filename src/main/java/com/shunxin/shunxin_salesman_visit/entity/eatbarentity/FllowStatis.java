package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import lombok.Data;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/4/29
 */
@Data
public class FllowStatis {
    private String ccode;
    private String cname;
    private int shoul_quan;
    private int reality_quan;

    @Override
    public String toString() {
        return "FllowStatis{" +
                "ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", shoul_quan=" + shoul_quan +
                ", reality_quan=" + reality_quan +
                '}';
    }
}
