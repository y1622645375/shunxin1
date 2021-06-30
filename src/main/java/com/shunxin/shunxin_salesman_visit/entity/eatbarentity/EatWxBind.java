package com.shunxin.shunxin_salesman_visit.entity.eatbarentity;

import lombok.Data;

/**
 * 微信openid绑定表
 */
@Data
public class EatWxBind {
    private int wx_id;
    private String wx_code;
    private String wx_openid;

    @Override
    public String toString() {
        return "EatWxBind{" +
                "wx_id=" + wx_id +
                ", wx_code='" + wx_code + '\'' +
                ", wx_openid='" + wx_openid + '\'' +
                '}';
    }
}
