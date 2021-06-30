package com.shunxin.shunxin_salesman_visit.controller.promotcontroller;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.CustomerDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CustomGoodDto;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.CustomGoods;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.promotservice.CustomgoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/CustomGoods")
public class CustomGoodsController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomgoodsService customgoodsService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 根据业务员工号查询所管客户
     * @param customGoodDto
     * @return
     */
    @RequestMapping("/selectCustoms")
    public Object selectCustoms(@RequestBody CustomGoodDto customGoodDto){
        String cperson_id = customGoodDto.getCperson_id();
        String ccus_name = customGoodDto.getCcus_name();
        String cuserid = customGoodDto.getCuserid();
        String ckey = customGoodDto.getCkey();
        int ilogin_type = customGoodDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<CustomGoodDto> customGoodsList = customgoodsService.selectCustoms(cperson_id,ccus_name);
                return baseApiService.setResultResultSuccess(customGoodsList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询所有商品
     * @param customGoodDto
     * @return
     */
    @RequestMapping("/selectCommodity")
    public Object selectCommodity(@RequestBody CustomGoodDto customGoodDto){
        String cinvname = customGoodDto.getCinvname();
        String cuserid = customGoodDto.getCuserid();
        String ckey = customGoodDto.getCkey();
        int ilogin_type = customGoodDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<CustomGoodDto> customGoodsList = customgoodsService.selectCommodity(cinvname);
                return baseApiService.setResultResultSuccess(customGoodsList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 给客户选择商品
     * @param customGoods
     * @return
     */
    @RequestMapping("/addCommdityToCustoms")
    public Object addCommdityToCustoms(@RequestBody CustomGoods customGoods){
        String ccus_id = customGoods.getCcus_id();   //客户编号
        String cinvcode = customGoods.getCinvcode(); //商品编号
        String [] cinvcodes = cinvcode.split(",");
        String cperson_id = customGoods.getCperson_id();   //操作工号
        String result = "";
        try {
            String ccomcode = customgoodsService.selectCompany(cperson_id); //公司编号
            customgoodsService.deleteCommdityToCustoms(ccus_id);
            for (int i = 0; i < cinvcodes.length; i++) {
                int count = customgoodsService.addCommdityToCustoms(ccomcode,ccus_id,cinvcodes[i],cperson_id);
                result = count >0?"操作成功":"操作失败";
            }
            logger.info("给客户选择商品");
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 给商品选择客户
     * @param customGoods
     * @return
     */
    @RequestMapping("/addCustomsToCommdity")
    public Object addCustomsToCommdity(@RequestBody CustomGoods customGoods){
        String ccus_id = customGoods.getCcus_id();   //客户编号
        String cinvcode = customGoods.getCinvcode(); //商品编号
        String [] ccusids = ccus_id.split(",");
        String cperson_id = customGoods.getCperson_id();   //操作工号
        String result = "";
        try {
            String ccomcode = customgoodsService.selectCompany(cperson_id); //公司编号
            customgoodsService.deleteCustomsToCommdity(cinvcode);
            for (int i = 0; i < ccusids.length; i++) {
                int count = customgoodsService.addCommdityToCustoms(ccomcode,ccusids[i],cinvcode,cperson_id);
                result = count >0?"操作成功":"操作失败";
            }
            logger.info("给商品选择客户");
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据客户查询已选择的商品
     * @return
     */
    @RequestMapping("/getCustomCommdity")
    public Object getCustomCommdity(@RequestBody CustomGoods customGoods){
        String ccus_id = customGoods.getCcus_id();
        try {
            List<CustomerDto> customerDtoList = customgoodsService.getCustomCommdity(ccus_id);
            return baseApiService.setResultResultSuccess(customerDtoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据商品查询已选择的客户
     * @param customGoods
     * @return
     */
    @RequestMapping("/getCommdityCustom")
    public Object getCommdityCustom(@RequestBody CustomGoods customGoods){
        String cinvcode = customGoods.getCinvcode();
        String cperson_id = customGoods.getCperson_id();
        try {
            List<CustomerDto> customerDtoList = customgoodsService.getCommdityCustom(cinvcode,cperson_id);
            return baseApiService.setResultResultSuccess(customerDtoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



}
