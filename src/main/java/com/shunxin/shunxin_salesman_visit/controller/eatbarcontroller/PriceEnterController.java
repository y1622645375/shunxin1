package com.shunxin.shunxin_salesman_visit.controller.eatbarcontroller;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PriceAllDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.Compay;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxAInvService;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.PriceEnterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/priceEnter")
public class PriceEnterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PriceEnterService priceEnterService;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private SxAInvService sxAInvService;


    /**
     * 查询商品价格列表 （用于车销和顺兴商城）
     * @return
     */
    @RequestMapping("/selectPriceEnter")
    public Object selectPriceEnter(@RequestBody PriceAllDto priceAllDto){
        String ccus_account =  priceAllDto.getCcus_account();  //手机号码
        String ccus_pid = priceAllDto.getCcus_pid();           //客户编号
        String ddates = priceAllDto.getDdates();               //日期例如： 2020-10-24
        String ctype = priceAllDto.getCtype();
        String cuserid = priceAllDto.getCuserid();
        try {
            if (ctype!=null&&ctype.equals("saleonline")){  //商城
                //先查询当前年月日
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ddates = sdf.format(date);
                //客户编号换取客户手机号
                String account = sxAInvService.getCcusAccount(ccus_pid);
                logger.info("换取到的手机号："+account);
                List<PriceEnter> priceEnters = priceEnterService.selectPriceEnter(account,ddates,cuserid);
                logger.info("查询商品价格录入表(用于顺兴商城)");
                return baseApiService.setResultResultSuccess(priceEnters);
            }else {     //车销
                List<PriceEnter> priceEnters = priceEnterService.selectPriceEnter(ccus_account,ddates,cuserid);
                logger.info("查询商品价格录入表(用于车销系统)");
                return baseApiService.setResultResultSuccess(priceEnters);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    @RequestMapping("/testsad")
    public Object testsad(){
        return "成功";
    }



    /**
     * 查询基础档案接口（公司、部门）（旧接口）
     * @return
     */
    @RequestMapping("/selectCompay")
    public Object selectCompay(@RequestBody PriceAllDto priceAllDto){
        String cusercode = priceAllDto.getCusercode();
        String ctype = priceAllDto.getCtype();
        String cuserid = priceAllDto.getCuserid();
        String ckey = priceAllDto.getCkey();
        int ilogin_type = priceAllDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<Compay> compayList  = priceEnterService.selectCompay(cusercode,ctype);
                logger.info("查询所有公司 查询人工号："+cusercode+"公司的类型："+ctype);
                return baseApiService.setResultResultSuccess(compayList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询基础档案（公司 company，hr公司相关 hrcompany，部门 department，订单状态  csostate）
     * @param priceAllDto
     * @return
     */
    @RequestMapping("/selectEnumdataLists")
    public Object selectEnumdataLists(@RequestBody PriceAllDto priceAllDto){
        String ctype = priceAllDto.getCtype();  //公司 company，hr公司相关 hrcompany, 部门 department，订单状态  csostate
        String cuserid = priceAllDto.getCuserid();
        String ckey = priceAllDto.getCkey();
        int ilogin_type = priceAllDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<Compay> compayList = priceEnterService.selectEnumdataLists(ctype,cuserid);
                logger.info("查询基础档案，类型为："+ctype+" 工号为："+cuserid);
                return baseApiService.setResultResultSuccess(compayList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 新增价格表
     * @param priceEnter
     * @return
     */
    @RequestMapping("/addInventoryExt")
    public Object addInventoryExt(@RequestBody PriceEnter priceEnter){
        String ccomcode = priceEnter.getCcomcode();
        String cinvcode = priceEnter.getCinvcode();
        String ccus_level = priceEnter.getCcus_level();
        BigDecimal ccus_price = priceEnter.getCcus_price();
        Float igoldrate = priceEnter.getIgoldrate();
        Date ddateb = priceEnter.getDdateb();
        Date ddatee = priceEnter.getDdatee();
        int igrade = priceEnter.getIgrade();
        String cuserid = priceEnter.getCuserid();
        String ckey = priceEnter.getCkey();
        int ilogin_type = priceEnter.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                String result = "";
                int count = priceEnterService.addInventoryExt(ccomcode,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,igrade);
                result = count>0?"新增成功":"新增失败";
                logger.info("新增价格表");
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询所有商品名称及编码
     * @return
     */
    @RequestMapping("/getInvents")
    public Object getInvents(@RequestBody PriceEnter priceEnter){
        String cinvname = priceEnter.getCinvname();
        String cuserid = priceEnter.getCuserid();
        String ckey = priceEnter.getCkey();
        int ilogin_type = priceEnter.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<Inventory> inventoryList = priceEnterService.getInvents(cinvname);
                return baseApiService.setResultResultSuccess(inventoryList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 修改价格表
     * @param priceEnter
     * @return
     */
    @RequestMapping("/updateInvents")
    public Object updateInvents(@RequestBody PriceEnter priceEnter){
        String ccomcode = priceEnter.getCcomcode();
        String cinvcode = priceEnter.getCinvcode();
        String ccus_level = priceEnter.getCcus_level();
        BigDecimal ccus_price = priceEnter.getCcus_price();
        Float igoldrate = priceEnter.getIgoldrate();
        Date ddateb = priceEnter.getDdateb();
        Date ddatee = priceEnter.getDdatee();
        int igrade = priceEnter.getIgrade();
        int autoid = priceEnter.getAutoid();
        String cuserid = priceEnter.getCuserid();
        String ckey = priceEnter.getCkey();
        int ilogin_type = priceEnter.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                String result = "";
                int count = priceEnterService.updateInvents(ccomcode,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,igrade,autoid);
                result = count>0?"修改成功":"修改失败";
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


}
