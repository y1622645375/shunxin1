package com.shunxin.shunxin_salesman_visit.dto.malldto;

import lombok.Data;

@Data
public class ResponseBase {
    private Integer rtnCode;
    private String msg;
    private Object data;
    private String jsonvist;

    public ResponseBase() {
    }

    public ResponseBase(Integer rtnCode, String msg, Object data, String jsonvist) {
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
        this.jsonvist = jsonvist;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "rtnCode=" + rtnCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", jsonvist='" + jsonvist + '\'' +
                '}';
    }
}
