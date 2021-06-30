package com.shunxin.shunxin_salesman_visit.dto.eatbardto;

import lombok.Data;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/4/29
 */
@Data
public class FllowImgDto {
    private String cimg_type;         //图片类型
    private String cimg_path;         //图片路径

    @Override
    public String toString() {
        return "FllowImgDto{" +
                "cimg_type='" + cimg_type + '\'' +
                ", cimg_path='" + cimg_path + '\'' +
                '}';
    }
}
