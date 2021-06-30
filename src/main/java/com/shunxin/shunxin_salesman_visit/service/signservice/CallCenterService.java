package com.shunxin.shunxin_salesman_visit.service.signservice;

import com.shunxin.shunxin_salesman_visit.entity.signentity.CallCenter;

import java.util.Date;
import java.util.List;

public interface CallCenterService {


    //根据自己的编号获取近七天的聊天记录
    List<CallCenter> selectCallService(String copenid);


    //根据openid获取所有聊天记录
    List<CallCenter> selectAllService(String copenid);


    //发送消息
    int insertCallService(String copenid,String csource,String cmsgtext);


    //将消息转发至企业微信
    String sendMessages(String cperson_id,String msgtext);


    //更新客服在线的最后时间
    int updateCdefine5(String copenid);


    //获取客服在线的最后时间
    Date selectMaxCdefine5(String copenid);

}
