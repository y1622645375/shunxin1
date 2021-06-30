package com.shunxin.shunxin_salesman_visit.service.promotservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CImagePathDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.ExaminingDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.OrderWxbands;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.UnpaidOrderDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.WxgzFllowVist;

import java.util.List;

public interface WxgzOrderService {


    //询订单列表，主要用于公众号中商家查询自己的订单
    List<OrdervDto> getOrderList(String ccus_id, String ddate2, String csocode, String cso_state);


    //客户查看自己店铺的拜访记录
    List<WxgzFllowVist> getFllowList(String cfllow_cid);


    //根据拜访表的autoid查询拜访图片
    List<CImagePathDto> getCimgPath(int fllowid);


    //客户查看各类商品的最新价格
    List<PriceEnter> getCommodityNewPrice(String ccus_cid);


    //返回异常订单结果
    List<ExaminingDto> getExaminingReport(int userid,String ctype);


    //获取异常结果日期
    String getTempdbDtime(int autoid);


    //查询未付款订单
    List<UnpaidOrderDto> selectUnpaidOrder(String cperson_id);


    //根据商家ID查询绑定信息
    List<OrderWxbands> getOrderWxbind(String ccusid);

}
