package com.shunxin.shunxin_salesman_visit.controller.mallcontroller;

import com.shunxin.shunxin_salesman_visit.dto.malldto.*;
import com.shunxin.shunxin_salesman_visit.entity.mallentity.Commodity;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.mallservice.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品和购物车的接口为主
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxInventory")
public class SxInventoryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private InventoryService inventoryService;


    /**
     * 首页查询商品 （用于顺兴商城）
     * @param inventoryPar
     * @return
     */
    @RequestMapping("/selectInventory")
    public Object selectInventory(@RequestBody InventoryPar inventoryPar) {
        String ctype = "invenlist"; //用于首页查询
        String cuser_id = inventoryPar.getCuser_id();   //账号ID
        String ctext = inventoryPar.getCtext();    //搜索内容
        try {
            List<InventoryDto> inventoryDtoList = inventoryService.selectInventory(ctype,cuser_id,ctext);
            return baseApiService.setResultResultSuccess(inventoryDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询分类 （无任何地方使用）
     * @return
     */
    @RequestMapping("/selectInvtype")
    public Object selectInvtype(@RequestBody InventoryPar inventoryPar) {
        String ctype = "invenclass"; //用于分类查询
        try {
            List<InventoryDto> inventoryDtotype = inventoryService.selectInvtype(ctype);
            logger.info("查询分类");
            return baseApiService.setResultResultSuccess(inventoryDtotype);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询分类商品 （无任何地方使用）
     * @param inventoryPar
     * @return
     */
    @RequestMapping("/selectInveClassify")
    public Object selectInveClassify(@RequestBody InventoryPar inventoryPar) {
        String ctype = "inventory"; //用于分类查询
        String cuser_id = inventoryPar.getCuser_id();   //账号ID
        String ctext = inventoryPar.getCtext();    //类别，例如：01
        try {
            List<InventoryDto> inventoryDtoList2 = inventoryService.selectInventory(ctype, cuser_id, ctext);
            logger.info("查询分类商品");
            return baseApiService.setResultResultSuccess(inventoryDtoList2);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 添加/删除购物车(+1或-1)
     * @param shoppingTrolleyPar
     * @return
     * @throws Exception
     */
    @RequestMapping("/modifyShoppingTrolley")
    public Object modifyShoppingTrolley(@RequestBody ShoppingTrolleyPar shoppingTrolleyPar) {
        String ctype = shoppingTrolleyPar.getCtype();
        String cuser_id = shoppingTrolleyPar.getCuser_id();
        String cinvcode = shoppingTrolleyPar.getCinvcode();
        try {
            List<ResultDto> resultDtos = inventoryService.modifyShoppingTrolley(ctype, cuser_id, cinvcode, 1);
            logger.info("添加/删除购物车(+1或-1)--参数：ctype：" + ctype + "--cuser_id：" + cuser_id + "--cinvcode：" + cinvcode + "--结果：" + resultDtos);
            return baseApiService.setResultResultSuccess(resultDtos);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 修改购物车(直接修改数量)
     * @param shoppingTrolleyPar
     * @return
     * @throws Exception
     */
    @RequestMapping("/revampShoppingTrolley")
    public Object revampShoppingTrolley(@RequestBody ShoppingTrolleyPar shoppingTrolleyPar) throws Exception {
        String cuser_id = shoppingTrolleyPar.getCuser_id();
        String cinvcode = shoppingTrolleyPar.getCinvcode();
        int iquan = shoppingTrolleyPar.getIquan();
        try {
            inventoryService.modifyShoppingTrolley("remove", cuser_id, cinvcode, 0);   //先清空购物车
            List<ResultDto> resultDtos = inventoryService.modifyShoppingTrolley("add", cuser_id, cinvcode, iquan);
            logger.info("修改购物车--参数：ctype：" + "cuser_id：" + cuser_id + "--cinvcode：" + cinvcode + "--iquan:" + iquan + "--结果：" + resultDtos);
            return baseApiService.setResultResultSuccess(resultDtos);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 删除购物车
     * @param shoppingTrolleyPar
     * @return
     * @throws Exception
     */
    @RequestMapping("/removeShoppingTrolley")
    public Object removeShoppingTrolley(@RequestBody ShoppingTrolleyPar shoppingTrolleyPar) throws Exception {
        String cuser_id = shoppingTrolleyPar.getCuser_id();
        String cinvcode = shoppingTrolleyPar.getCinvcode();  //要考虑接收商品编码集合，再进行遍历删除
        try {
            List<ResultDto> resultDtos = inventoryService.removeShoppingTrolley("remove", cuser_id, cinvcode, 0);  //清空购物车
            logger.info("删除购物车--参数：ctype：" + "cuser_id：" + cuser_id + "--cinvcode：" + cinvcode + "--结果：" + resultDtos);
            return baseApiService.setResultResultSuccess(resultDtos);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询购物车
     * @param inventoryPar
     * @return
     */
    @RequestMapping("/selectShoppingTrolley")
    public Object selectShoppingTrolley(@RequestBody InventoryPar inventoryPar) {
        String ctype = "invencart"; //用于查询购物车
        String cuser_id = inventoryPar.getCuser_id();   //账号ID
        String ctext = inventoryPar.getCtext();     //暂时用不上
        try {
            List<InventoryDto> inventoryDtoList = inventoryService.selectShoppingTrolley(ctype, cuser_id, ctext);
            logger.info("查询购物车--参数：ctype:" + ctype + "cuser_id：" + cuser_id + "--ctext：" + ctext + "--结果：" + inventoryDtoList);
            return baseApiService.setResultResultSuccess(inventoryDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询商品详情selectInvtype
     * @param commonDto
     * @return
     */
    @RequestMapping("/selectCommodity")
    public Object selectCommodity(@RequestBody CommonDto commonDto) {
        int autoid = commonDto.getAutoid();
        String cInvCode = commonDto.getcInvCode();
        try {
            String ccus_level = inventoryService.selectCcus_level(autoid);
            List<Commodity> commodities = inventoryService.selectCommodity(cInvCode, ccus_level);
            logger.info("查询商品详情");
            return baseApiService.setResultResultSuccess(commodities);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("返回错误结果：" + e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }



}
