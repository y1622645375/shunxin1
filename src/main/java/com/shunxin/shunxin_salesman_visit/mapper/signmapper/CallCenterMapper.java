package com.shunxin.shunxin_salesman_visit.mapper.signmapper;

import com.shunxin.shunxin_salesman_visit.entity.signentity.CallCenter;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CallCenterMapper {


    //根据openid获取近七天的聊天记录
    List<CallCenter> selectCallService(@Param("copenid") String copenid);


    //根据openid获取所有聊天记录
    List<CallCenter> selectAllService(@Param("copenid") String copenid);


    //发送消息
    int insertCallService(@Param("copenid") String copenid,@Param("csource") String csource,@Param("cmsgtext") String cmsgtext);


    //将消息转发至企业微信
    String sendMessages(@Param("cperson_id") String cperson_id,@Param("msgtext") String msgtext);


    //更新客服在线的最后时间
    int updateCdefine5(@Param("copenid") String copenid);


    //获取客服在线的最后时间
    Date selectMaxCdefine5(@Param("copenid") String copenid);


}
