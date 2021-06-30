package com.shunxin.shunxin_salesman_visit.dto.promotdto;

import lombok.Data;

@Data
public class CImagePathDto {
    private int autoid;
    private int fllowid;
    private String cimg_type;
    private String cimg_path;
    private String iimg_sort;

    @Override
    public String toString() {
        return "CImagePathDto{" +
                "autoid=" + autoid +
                ", fllowid=" + fllowid +
                ", cimg_type='" + cimg_type + '\'' +
                ", cimg_path='" + cimg_path + '\'' +
                ", iimg_sort='" + iimg_sort + '\'' +
                '}';
    }
}
