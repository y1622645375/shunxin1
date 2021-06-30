package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

@Data
public class ResponseBase {
    private Integer rtnCode;
    private String msg;
    private Object data;

    public ResponseBase(){}

    public ResponseBase(Integer rtnCode, String msg, Object data){
        super();
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }

}
