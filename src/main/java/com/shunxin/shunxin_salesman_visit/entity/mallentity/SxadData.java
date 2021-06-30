package com.shunxin.shunxin_salesman_visit.entity.mallentity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SxadData {

    private int autoid;
    private String cad_name;    //广告长标题
    private String cad_title;   //广告短标题
    private String cad_usefor;  //用途，1微信APP端,2PC端，3其他
    private String cad_type;    //广告类型，1主首页轮播，2快捷入口，3今日特卖，4新品推荐，后期推出更多
    private String cad_img;     //图片地址
    private String cad_text;    //文字内容
    private int iad_sort;       //排序序号
    private String cad_memo;    //描述
    private String cad_link;    //链接地址
    private int iad_state;      //状态，0生效，1失效
    private int is_del;         //是否删除，0未删，1删除
    private String create_by;   //创建者
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;   //创建时间
    private String update_by;   //最后修改人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date update_time;   //最后修改时间
    private String cdefine1;
    private String cdefine2;
    private String cdefine3;
    private String cdefine4;
    private String cdefine5;
    private int idefine1;
    private int idefine2;
    private int idefine3;


    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCad_name() {
        return cad_name;
    }

    public void setCad_name(String cad_name) {
        this.cad_name = cad_name;
    }

    public String getCad_title() {
        return cad_title;
    }

    public void setCad_title(String cad_title) {
        this.cad_title = cad_title;
    }

    public String getCad_usefor() {
        return cad_usefor;
    }

    public void setCad_usefor(String cad_usefor) {
        this.cad_usefor = cad_usefor;
    }

    public String getCad_type() {
        return cad_type;
    }

    public void setCad_type(String cad_type) {
        this.cad_type = cad_type;
    }

    public String getCad_img() {
        return cad_img;
    }

    public void setCad_img(String cad_img) {
        this.cad_img = cad_img;
    }

    public String getCad_text() {
        return cad_text;
    }

    public void setCad_text(String cad_text) {
        this.cad_text = cad_text;
    }

    public int getIad_sort() {
        return iad_sort;
    }

    public void setIad_sort(int iad_sort) {
        this.iad_sort = iad_sort;
    }

    public String getCad_memo() {
        return cad_memo;
    }

    public void setCad_memo(String cad_memo) {
        this.cad_memo = cad_memo;
    }

    public String getCad_link() {
        return cad_link;
    }

    public void setCad_link(String cad_link) {
        this.cad_link = cad_link;
    }

    public int getIad_state() {
        return iad_state;
    }

    public void setIad_state(int iad_state) {
        this.iad_state = iad_state;
    }

    public int getIs_del() {
        return is_del;
    }

    public void setIs_del(int is_del) {
        this.is_del = is_del;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getCdefine1() {
        return cdefine1;
    }

    public void setCdefine1(String cdefine1) {
        this.cdefine1 = cdefine1;
    }

    public String getCdefine2() {
        return cdefine2;
    }

    public void setCdefine2(String cdefine2) {
        this.cdefine2 = cdefine2;
    }

    public String getCdefine3() {
        return cdefine3;
    }

    public void setCdefine3(String cdefine3) {
        this.cdefine3 = cdefine3;
    }

    public String getCdefine4() {
        return cdefine4;
    }

    public void setCdefine4(String cdefine4) {
        this.cdefine4 = cdefine4;
    }

    public String getCdefine5() {
        return cdefine5;
    }

    public void setCdefine5(String cdefine5) {
        this.cdefine5 = cdefine5;
    }

    public int getIdefine1() {
        return idefine1;
    }

    public void setIdefine1(int idefine1) {
        this.idefine1 = idefine1;
    }

    public int getIdefine2() {
        return idefine2;
    }

    public void setIdefine2(int idefine2) {
        this.idefine2 = idefine2;
    }

    public int getIdefine3() {
        return idefine3;
    }

    public void setIdefine3(int idefine3) {
        this.idefine3 = idefine3;
    }

    @Override
    public String toString() {
        return "SxadData{" +
                "autoid=" + autoid +
                ", cad_name='" + cad_name + '\'' +
                ", cad_title='" + cad_title + '\'' +
                ", cad_usefor='" + cad_usefor + '\'' +
                ", cad_type='" + cad_type + '\'' +
                ", cad_img='" + cad_img + '\'' +
                ", cad_text='" + cad_text + '\'' +
                ", iad_sort=" + iad_sort +
                ", cad_memo='" + cad_memo + '\'' +
                ", cad_link='" + cad_link + '\'' +
                ", iad_state=" + iad_state +
                ", is_del=" + is_del +
                ", create_by='" + create_by + '\'' +
                ", create_time=" + create_time +
                ", update_by='" + update_by + '\'' +
                ", update_time=" + update_time +
                ", cdefine1='" + cdefine1 + '\'' +
                ", cdefine2='" + cdefine2 + '\'' +
                ", cdefine3='" + cdefine3 + '\'' +
                ", cdefine4='" + cdefine4 + '\'' +
                ", cdefine5='" + cdefine5 + '\'' +
                ", idefine1=" + idefine1 +
                ", idefine2=" + idefine2 +
                ", idefine3=" + idefine3 +
                '}';
    }
}
