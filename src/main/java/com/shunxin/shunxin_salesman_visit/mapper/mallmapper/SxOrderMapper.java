package com.shunxin.shunxin_salesman_visit.mapper.mallmapper;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.OrdervDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.ResultOrderDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.OrderstyleDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.SxOrderDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Order;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.OrderLog;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.SxOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SxOrderMapper {


    /**
     * 查询订单
     * @return
     */
    //List<Order> selectOrderList(@Param("ccus_id") String ccus_id, @Param("cso_state") String cso_state);
    List<OrdervDto> selectOrderList(@Param("ccus_id") String ccus_id, @Param("ddate2") String ddate2, @Param("csocode") String csocode, @Param("cso_state") String cso_state);


    /**
     * 查询订单日志
     * @return
     */
    List<OrderLog> selectOrderLog(int order_id);


    /**
     * 将商品存入临时订单表
     * @param items
     * @return
     */
    List<ResultDto> insertOrder(String items);


    /**
     * 核对订单
     * @param ccus_id
     * @return
     */
    List<OrderstyleDto> selectOrderstyleList(String ccus_id);


    /**
     * 生成订单
     * @param items
     * @return
     */
    //List<ResultOrderDto> addOrder(@Param("items") String items);
    ResultOrderDto addOrder(@Param("items") String items);

    /**
     * 订单作废
     * @param jsonvist
     * @return
     */
    List<ResultDto> cancelOrder(String jsonvist);


    /**
     * 查询订单详情
     * @param csocode
     * @return
     */
    List<Order> selectOrderInfo(String csocode);


    //根据客户编号查询所属分销商编号
    String getDistribution(@Param("autoid") String autoid);


    //查询支付二维码的收款状态
    int selectPayCodeType(@Param("csocode") String csocode);



    //新增日志
    int addErrlogs(@Param("cuserid") String cuserid,@Param("logs") String logs);


    //查询订单列表(非详情)
    List<SxOrder> queryOrderList(@Param("cperson_id") String cperson_id, @Param("ddate1") String ddate1, @Param("ddate2") String ddate2,
                                 @Param("cso_state") String cso_state, @Param("csocode") String csocode);


    //根据订单号查询订单详情
    List<SxOrderDto> queryOrderInfo(@Param("csocode") String csocode);


    //查询订单列表（详情）
    List<OrdervDto> selectSxOrderList(@Param("cperson_id") String cperson_id, @Param("ddate1") String ddate1, @Param("ddate2") String ddate2,
                                      @Param("cso_state") String cso_state, @Param("csocode") String csocode,@Param("ccomcode") String ccomcode,@Param("cusercode") String cusercode);


    //让失效的订单重新生效
    int takeEffectOrder(@Param("csocode") String csocode);

}
