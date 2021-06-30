package com.shunxin.shunxin_salesman_visit.service.signservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.signdto.PersonalCenter;
import com.shunxin.shunxin_salesman_visit.entity.signentity.Information;
import com.shunxin.shunxin_salesman_visit.entity.signentity.IntegralRecord;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignCommod;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignRecord;

import java.util.List;

public interface SignCenterService {


    //客户进行签到
    ResultDto insertSignRecord(String jsonvisit);


    //根据客户ID查询客户积分
    IntegralRecord selectSignIntegral(String integral_cid);


    //查询今日签到获得的积分
    IntegralRecord getTodayIntegral(String csign_cid);


    //查询今日是否已签到
    int getSignTodayRecord(String csign_cid);


    //根据客户ID查询签到记录
    List<SignRecord> selectSignRecord(String csign_cid);


    //查询当前可兑换商品
    List<SignCommod> selectCommodList();


    //查询签到积分记录
    List<IntegralRecord> selectCreditsExchange(String integral_type,String integral_cid);


    //查询兑换积分记录
    List<IntegralRecord> selectCommodExchange(String integral_type,String integral_cid);


    //根据ID查询需要兑换的商品
    SignCommod getSignCommods(int autoid);


    //进行商品兑换，库存发生变化
    int updateCommodQuan(int iquan,int rquan,int autoid);


    //商品兑换完成，写入积分记录表
    int addIntegralCommod(String integral_cid,String integral_type,int integral_Dr,int integral_Cr,int integral_Ye,int commod_id);


    //查询连续签到积分方案
    Information selectInformation(String cname);


    //查询本周拜访获得的总积分
    //int selectFllowRecord(String integral_cid,String integral_type);


    //拜访完成，写入积分记录表
    //int addIntegralFllow(String integral_cid,String integral_type,int integral_Dr,int integral_Cr,int integral_Ye,int fllow_id);


    //查询今日拜访autoid
    //int selectSxFllowToday(String cfllow_cid);


    //客户手动领取积分后，积分发生改变
    int updateIntegral(int integral_dr,int integral_ye,int autoid);


    //根据拜访ID查询积分情况
    IntegralRecord selectFllowIntegral(int fllow_id);


    //根据auotid查询积分记录
    //IntegralRecord selectIntegralAutoid( int autoid);


    //根据订单ID查询积分情况
    IntegralRecord selectOrderIntegral(int order_id);


    //通过openid获取用户的基础信息
    List<PersonalCenter> selectPersonal(String copenid);

}
