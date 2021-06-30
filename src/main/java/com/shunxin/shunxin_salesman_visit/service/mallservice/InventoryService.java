package com.shunxin.shunxin_salesman_visit.service.mallservice;



import com.shunxin.shunxin_salesman_visit.dto.malldto.InventoryDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Commodity;

import java.util.List;

public interface InventoryService {

    /**
     * 首页查询商品以及分类商品
     *
     * @return
     */
    List<InventoryDto> selectInventory(String ctype, String cuser_id, String ctext);


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
    List<ResultDto> modifyShoppingTrolley(String ctype, String cuser_id, String cinvcode, int iquan);


    /**
     * 删除购物车
     *
     * @param ctype
     * @param cuser_id
     * @param cinvcode
     * @param iquan
     * @return
     */
    List<ResultDto> removeShoppingTrolley(String ctype, String cuser_id, String cinvcode, int iquan);


    /**
     * 查询购物车
     *
     * @param ctype
     * @param cuser_id
     * @param ctext
     * @return
     */
    List<InventoryDto> selectShoppingTrolley(String ctype, String cuser_id, String ctext);


    /**
     * 查询商品详情
     *
     * @param cInvCode
     * @param ccus_level
     * @return
     */
    List<Commodity> selectCommodity(String cInvCode, String ccus_level);


    /**
     * 查询客户分类
     *
     * @param autoid
     * @return
     */
    String selectCcus_level(int autoid);

}
