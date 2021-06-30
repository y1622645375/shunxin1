package com.shunxin.shunxin_salesman_visit.mapper.promotmapper;

import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Inventory2;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.Promotion;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SacxHold;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.ZpcinvCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PromotionMapper {

    //查询促销商品列表
    List<Promotion> selectPromotion(@Param("cusercode") String cusercode, @Param("ddate") String ddate, @Param("istate") String istate);


    //新增促销活动
    List<ResultDto> addPromotion(@Param("jsonvist") String jsonvist);


    //修改促销活动
    List<ResultDto> updatePromotion(@Param("jsonvist") String jsonvist);


    //审核促销活动
    List<ResultDto> checkPromotion(@Param("jsonvist") String jsonvist);



    //作废该促销活动
    List<ResultDto> invalidPromotion(@Param("jsonvist") String jsonvist);


    //根据id查询单条数据
    List<Promotion> selectPromoOne(@Param("cusercode") String cusercode,@Param("sacxid") String sacxid);


    //根据活动编号查询客户类型详细
    List<SacxHold> selectSacxHold(@Param("sacxid") String sacxid);


    //根据活动编号查询赠品详细
    List<ZpcinvCode> selectZpCinvName(@Param("ctype") String ctype,@Param("sacxid") String sacxid);


    //商家查询某商品的优惠
    List<ZpcinvCode> getZpSacxCount(@Param("ctype") String ctype,@Param("ccomcode") String ccomcode,
                                    @Param("ccus_id") String ccus_id,@Param("cinvcode") String cinvcode,@Param("iquan") int iquan);


    //查询所有商品
    List<Inventory2> selectInvent2(@Param("cinvname") String cinvname);


    //根据客户ID查询业务员工号
    String getCpersonIds(@Param("autoid") String autoid);


}
