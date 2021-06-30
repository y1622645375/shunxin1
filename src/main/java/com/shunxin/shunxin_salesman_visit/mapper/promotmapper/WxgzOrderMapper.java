package com.shunxin.shunxin_salesman_visit.mapper.promotmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CImagePathDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.ExaminingDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.OrderWxbands;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.UnpaidOrderDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.WxgzFllowVist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxgzOrderMapper {


    //询订单列表，主要用于公众号中商家查询自己的订单
    List<OrdervDto> getOrderList(@Param("ccus_id") String ccus_id,@Param("ddate2") String ddate2,@Param("csocode") String csocode,@Param("cso_state") String cso_state);


    //客户查看自己店铺的拜访记录
    List<WxgzFllowVist> getFllowList(@Param("cfllow_cid") String cfllow_cid);


    //根据拜访表的autoid查询拜访图片
    List<CImagePathDto> getCimgPath(@Param("fllowid") int fllowid);


    //客户查看各类商品的最新价格
    List<PriceEnter> getCommodityNewPrice(@Param("ccus_cid") String ccus_cid);


    //返回异常订单结果
    List<ExaminingDto> getExaminingReport(@Param("userid") int userid,@Param("ctype") String ctype);


    //获取异常结果日期
    String getTempdbDtime(@Param("autoid") int autoid);


    //查询未付款订单
    List<UnpaidOrderDto> selectUnpaidOrder(@Param("cperson_id") String cperson_id);


    //根据商家ID查询绑定信息
    List<OrderWxbands> getOrderWxbind(@Param("ccusid") String ccusid);




}
