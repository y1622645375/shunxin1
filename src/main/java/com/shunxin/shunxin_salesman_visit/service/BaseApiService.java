package com.shunxin.shunxin_salesman_visit.service;

import com.shunxin.shunxin_salesman_visit.entity.cliententity.ResponseBase;
import org.springframework.stereotype.Component;

@Component
public class BaseApiService {
    public ResponseBase setResultError(Integer code, String msg){
        return setResult(code,msg,null);
    }

    //返回错误，可以传msg值
    public ResponseBase setResultError(String msg){
        return setResult(500,msg,null);
    }

    //返回成功，可以传data值
    public ResponseBase setResultResultSuccess(Object data){
        return setResult(200,"处理成功",data);
    }

    //返回成功，不传值
    public ResponseBase setResultResultSuccess(){
        return setResult(200,"处理成功",null);
    }

    //返回成功，可以传msg值
    public ResponseBase setResultResultSuccess2(String msg){
        return setResult(200,msg,null);
    }

    public ResponseBase setResult(Integer code, String msg, Object data){
        return new ResponseBase(code,msg,data);
    }

}
