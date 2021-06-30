package com.shunxin.shunxin_salesman_visit.mapper.signmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.signdto.PersonalCenter;
import com.shunxin.shunxin_salesman_visit.entity.signentity.Information;
import com.shunxin.shunxin_salesman_visit.entity.signentity.IntegralRecord;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignCommod;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignCenterMapper {


        //客户进行签到
        ResultDto insertSignRecord(@Param("jsonvisit") String jsonvisit);


        //根据客户ID查询当前积分
        IntegralRecord selectSignIntegral(@Param("integral_cid") String integral_cid);


        //查询今日签到获得的积分
        IntegralRecord getTodayIntegral(@Param("csign_cid") String csign_cid);


        //查询今日是否已签到
        int getSignTodayRecord(@Param("csign_cid") String csign_cid);


        //根据客户ID查询签到记录
        List<SignRecord> selectSignRecord(@Param("csign_cid") String csign_cid);


        //查询当前可兑换商品
        List<SignCommod> selectCommodList();


        //查询签到积分记录
        List<IntegralRecord> selectCreditsExchange(@Param("integral_type") String integral_type,@Param("integral_cid") String integral_cid);


        //查询兑换积分记录
        List<IntegralRecord> selectCommodExchange(@Param("integral_type") String integral_type,@Param("integral_cid") String integral_cid);


        //根据ID查询需要兑换的商品
        SignCommod getSignCommods(@Param("autoid") int autoid);


        //进行商品兑换，库存发生变化
        int updateCommodQuan(@Param("iquan") int iquan,@Param("rquan") int rquan,@Param("autoid") int autoid);


        //商品兑换完成，写入积分记录表
        int addIntegralCommod(@Param("integral_cid") String integral_cid,@Param("integral_type") String integral_type,@Param("integral_Dr") int integral_Dr,
                              @Param("integral_Cr") int integral_Cr,@Param("integral_Ye") int integral_Ye,@Param("commod_id") int commod_id);


        //查询连续签到积分方案
        Information selectInformation(@Param("cname") String cname);


        //查询本周拜访获得的总积分
        //int selectFllowRecord(@Param("integral_cid") String csign_cid,@Param("integral_type") String integral_type);


        //拜访完成，写入积分记录表
        //int addIntegralFllow(@Param("integral_cid") String csign_cid,@Param("integral_type") String integral_type,@Param("integral_Dr") int integral_Dr,
                             //@Param("integral_Cr") int integral_Cr,@Param("integral_Ye") int integral_Ye,@Param("fllow_id") int fllow_id);


        //查询今日拜访autoid
        //int selectSxFllowToday(@Param("cfllow_cid") String cfllow_cid);


        //客户手动领取积分后，积分发生改变
        int updateIntegral(@Param("integral_dr") int integral_dr,@Param("integral_ye") int integral_ye,@Param("autoid") int autoid);


        //根据拜访ID查询积分情况
        IntegralRecord selectFllowIntegral(@Param("fllow_id") int fllow_id);


        //根据auotid查询积分记录
        //IntegralRecord selectIntegralAutoid(@Param("autoid") int autoid);


        //根据订单ID查询积分情况
        IntegralRecord selectOrderIntegral(@Param("order_id") int order_id);


        //通过openid获取用户的基础信息
        List<PersonalCenter> selectPersonal(@Param("copenid") String copenid);


}
