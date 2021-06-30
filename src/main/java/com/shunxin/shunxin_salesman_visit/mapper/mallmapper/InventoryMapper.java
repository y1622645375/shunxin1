package com.shunxin.shunxin_salesman_visit.mapper.mallmapper;


import com.shunxin.shunxin_salesman_visit.dto.malldto.InventoryDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InventoryMapper {

    /**
     * 首页查询商品以及分类商品
     *
     * @return
     */
    List<InventoryDto> selectInventory(@Param("ctype") String ctype, @Param("cuser_id") String cuser_id, @Param("ctext") String ctext);


    /**
     * 查询所有类别
     *
     * @param ctype
     * @return
     */
    List<InventoryDto> selectInvtype(String ctype);


    /**
     * 修改购物车
     *
     * @param ctype
     * @param cuser_id
     * @param cinvcode
     * @param iquan
     * @return
     */
    List<ResultDto> modifyShoppingTrolley(@Param("ctype") String ctype, @Param("cuser_id") String cuser_id, @Param("cinvcode") String cinvcode, @Param("iquan") int iquan);


    /**
     * 删除购物车
     *
     * @param ctype
     * @param cuser_id
     * @param cinvcode
     * @param iquan
     * @return
     */
    List<ResultDto> removeShoppingTrolley(@Param("ctype") String ctype, @Param("cuser_id") String cuser_id, @Param("cinvcode") String cinvcode, @Param("iquan") int iquan);


    /**
     * 查询购物车
     *
     * @param ctype
     * @param cuser_id
     * @param ctext
     * @return
     */
    List<InventoryDto> selectShoppingTrolley(@Param("ctype") String ctype, @Param("cuser_id") String cuser_id, @Param("ctext") String ctext);


    /**
     * 查询商品详情
     *
     * @param cInvCode
     * @param ccus_level
     * @return
     */
    List<Commodity> selectCommodity(@Param("cInvCode") String cInvCode, @Param("ccus_level") String ccus_level);


    /**
     * 查询客户分类
     *
     * @param autoid
     * @return
     */
    String selectCcus_level(int autoid);

}
