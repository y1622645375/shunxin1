package com.shunxin.shunxin_salesman_visit.entity.cliententity;

/**
 *客户图片表
 */
public class SxFllowImg {
    private int autoid;         //ID
    private String fllowid;     //ID
    private String cimg_type;   //照片类型
    private String cimg_path;   //照片路径
    private int iimg_sort;      //照片顺序

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getFllowid() {
        return fllowid;
    }

    public void setFllowid(String fllowid) {
        this.fllowid = fllowid;
    }

    public String getCimg_type() {
        return cimg_type;
    }

    public void setCimg_type(String cimg_type) {
        this.cimg_type = cimg_type;
    }

    public String getCimg_path() {
        return cimg_path;
    }

    public void setCimg_path(String cimg_path) {
        this.cimg_path = cimg_path;
    }

    public int getIimg_sort() {
        return iimg_sort;
    }

    public void setIimg_sort(int iimg_sort) {
        this.iimg_sort = iimg_sort;
    }

    @Override
    public String toString() {
        return "SxFllowImg{" +
                "autoid=" + autoid +
                ", fllowid='" + fllowid + '\'' +
                ", cimg_type='" + cimg_type + '\'' +
                ", cimg_path='" + cimg_path + '\'' +
                ", iimg_sort=" + iimg_sort +
                '}';
    }
}
