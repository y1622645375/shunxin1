package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/3/23
 */
@Data
public class MapTmps {
    private String autoid;
    private String lat;
    private String lng;
    private String param1;

    @Override
    public String toString() {
        return "MapTmps{" +
                "autoid='" + autoid + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", param1='" + param1 + '\'' +
                '}';
    }
}
