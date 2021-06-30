package com.shunxin.shunxin_salesman_visit.service.promotservice;

import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Inventory2;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Promotion;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SacxHold;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ZpcinvCode;

import java.util.List;

public interface PromotionService {


    //查询促销商品列表
    List<Promotion> selectPromotion(String cusercode, String ddate, String istate);


    //新增促销活动
    List<ResultDto> addPromotion(String jsonvist);


    //修改促销活动
    List<ResultDto> updatePromotion(String jsonvist);


    //审核促销活动
    List<ResultDto> checkPromotion(String jsonvist);


    //作废该促销活动
    List<ResultDto> invalidPromotion(String jsonvist);


    //根据id查询单条数据
    List<Promotion> selectPromoOne(String cusercode,String sacxid);


    //根据活动编号查询客户类型详细
    List<SacxHold> selectSacxHold(String sacxid);


    //根据活动编号查询赠品详细
    List<ZpcinvCode> selectZpCinvName(String ctype,String sacxid);


    //商家查询某商品的优惠
    List<ZpcinvCode> getZpSacxCount(String ctype,String ccomcode,String ccus_id,String cinvcode,int iquan);


    //查询所有商品
    List<Inventory2> selectInvent2(String cinvname);


    //根据客户ID查询业务员工号
    String getCpersonIds(String autoid);

}
