package com.shunxin.shunxin_salesman_visit.controller.eatbarcontroller;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PriceAllDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnterLog;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.PriceEnterLogService;
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
@RequestMapping("/api/priceEnterLog")
public class PriceEnterLogController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PriceEnterLogService priceEnterLogService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 查询历史价格表
     * @param priceEnterLog
     * @return
     */
    @RequestMapping("/selectPriceEnterLog")
    public Object selectPriceEnterLog(@RequestBody PriceEnterLog priceEnterLog){
        String cperson_id = priceEnterLog.getCperson_id();
        String ccomcode =  priceEnterLog.getCcomcode();
        String cinvcode = priceEnterLog.getCinvcode();
        String ccus_level = priceEnterLog.getCcus_level();
        String ddate = priceEnterLog.getDdates();
        String cuserid = priceEnterLog.getCuserid();
        String ckey = priceEnterLog.getCkey();
        int ilogin_type = priceEnterLog.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<PriceEnterLog>  priceEnterLogs = priceEnterLogService.selectPriceEnterLog(cperson_id,ccomcode,cinvcode,ccus_level,ddate);
                return baseApiService.setResultResultSuccess(priceEnterLogs);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增历史价格表
     * @param priceEnterLog
     * @return
     */
    /*@RequestMapping("/insertPriceEnter")
    public Object insertPriceEnter(@RequestBody PriceEnterLog priceEnterLog){
        String ccomcode = priceEnterLog.getCcomcode();
        String cuser_id = priceEnterLog.getCuser_id();
        String cinvcode = priceEnterLog.getCinvcode();
        String ccus_level = priceEnterLog.getCcus_level();
        BigDecimal ccus_price = priceEnterLog.getCcus_price();
        Float igoldrate = priceEnterLog.getIgoldrate();
        Date ddateb = priceEnterLog.getDdateb();
        Date ddatee = priceEnterLog.getDdatee();
        String cmemo = priceEnterLog.getCmemo();
        String result = "";
        try {
            int count = priceEnterLogService.insertPriceEnter(ccomcode,cuser_id,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,cmemo);
            result = count>0?"新增成功":"新增失败";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    *//**
     * 修改历史价格表
     * @param priceEnterLog
     * @return
     *//*
    @RequestMapping("/updatePriceEnter")
    public Object updatePriceEnter(@RequestBody PriceEnterLog priceEnterLog){
        String result = "";
        String ccomcode = priceEnterLog.getCcomcode();
        String cuser_id = priceEnterLog.getCuser_id();
        String cinvcode = priceEnterLog.getCinvcode();
        String ccus_level = priceEnterLog.getCcus_level();
        BigDecimal ccus_price = priceEnterLog.getCcus_price();
        Float igoldrate = priceEnterLog.getIgoldrate();
        Date ddateb = priceEnterLog.getDdateb();
        Date ddatee = priceEnterLog.getDdatee();
        String cmemo = priceEnterLog.getCmemo();
        int autoid = priceEnterLog.getAutoid();
        try {
            int count = priceEnterLogService.updatePriceEnter(ccomcode,cuser_id,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,cmemo,autoid);
            result = count>0?"修改成功":"修改失败";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    *//**
     * 停用选择的价格
     * @param priceEnterLog
     * @return
     *//*
    @RequestMapping("/forbiddenInventory")
    public Object forbiddenInventory(@RequestBody PriceEnterLog priceEnterLog){
        int autoid = priceEnterLog.getAutoid();
        String ccloser = priceEnterLog.getCcloser();
        String cmemo = priceEnterLog.getCmemo();
        try {
            String result = "";
            String checktepy = priceEnterLogService.getChecktepy(autoid);
            if (checktepy.equals("已审核")){
                PriceEnterLog priceEnterLog1 = priceEnterLogService.getExtLogs(autoid);
                if (priceEnterLog1.getIext_id()!=0) {
                    int shul = priceEnterLogService.updateBclose(priceEnterLog1.getIext_id());
                    if (shul>0){
                        int count = priceEnterLogService.forbiddenInventory(ccloser,cmemo,autoid);
                        result = count>0?"停用成功":"停用失败";
                    }else {
                        result = "停用失败";
                    }
                }else {
                    result = "参数为空，停用失败";
                }
            }else {
                result = "还未审核，无法停用";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    *//**
     * 审核新价格
     * @param priceEnterLog
     * @return
     *//*
    @RequestMapping("/checkInventory")
    public Object checkInventory(@RequestBody PriceEnterLog priceEnterLog){
        int autoid = priceEnterLog.getAutoid();
        String cchecker = priceEnterLog.getCchecker();
        try {
            String result = "";
            PriceEnterLog priceEnterLog1 = priceEnterLogService.getExtLogs(autoid);
            if (priceEnterLog1!=null){
                String ccomcode = priceEnterLog1.getCcomcode();
                String ccus_level = priceEnterLog1.getCcus_level();
                String cinvcode = priceEnterLog1.getCinvcode();
                BigDecimal ccus_price = priceEnterLog1.getCcus_price();
                Float igoldrate = priceEnterLog1.getIgoldrate();
                int igrade = 0;
                Date ddateb = priceEnterLog1.getDdateb();
                Date ddatee = priceEnterLog1.getDdatee();
                int count1 = priceEnterLogService.judgeRepeat(ccomcode,ccus_level,cinvcode,ddateb,ddatee);
                if (count1==1){  //数据无重复，唯一
                    int autoid2 = priceEnterLogService.judgeInventoryExt(ccomcode,ccus_level,cinvcode);
                    if (autoid2!=0){ //正式表存在有数据，则进行修改
                        int autoid3 = priceEnterLogService.judgeInventoryExtAutoid(ccomcode,ccus_level,cinvcode);
                        int count2 = priceEnterService.updateInvents(ccomcode,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,igrade,autoid3);
                        if (count2>0){  //修改成功,将iext_id修改为正式表的autoid
                            priceEnterLogService.updateIextId(autoid3,autoid);
                            int count3 = priceEnterLogService.checkInventory(cchecker,autoid);
                            result = count3>0?"审核成功":"审核失败";
                        }
                    }else {  //正式表没有有数据，则进行新增
                        int count4 = priceEnterService.addInventoryExt(ccomcode,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,igrade);
                        if (count4>0) { //新增成功
                            int autoid3 = priceEnterLogService.judgeInventoryExtAutoid(ccomcode,ccus_level,cinvcode);
                            priceEnterLogService.updateIextId(autoid3,autoid);
                            int count3 = priceEnterLogService.checkInventory(cchecker,autoid);
                            result = count3>0?"审核成功":"审核失败";
                        }
                    }
                }else {
                    result = "有数据重复，审核无法通过";
                }
            }else {
                result = "数据为空，无法审核";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }*/


    /**
     * 停用价格
     * @param priceAllDto
     * @return
     */
    @RequestMapping("/stopPriceEnter")
    public Object stopPriceEnter(@RequestBody PriceAllDto priceAllDto){
        String jsonvist = priceAllDto.getJsonvist();
        String cuserid = priceAllDto.getCuserid();
        String ckey = priceAllDto.getCkey();
        int ilogin_type = priceAllDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = priceEnterLogService.stopPriceEnter(jsonvist);
                logger.info("停用价格");
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增价格记录
     * @param priceAllDto
     * @return
     */
    @RequestMapping("/addPriceEnter")
    public Object addPriceEnter(@RequestBody PriceAllDto priceAllDto){
        String jsonvist = priceAllDto.getJsonvist();
        String cuserid = priceAllDto.getCuserid();
        String ckey = priceAllDto.getCkey();
        int ilogin_type = priceAllDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                /*String [] strary = jsonvist.split(",&");
                List<ResultDto> resultDtos = new ArrayList<>();
                for (int i = 0; i < strary.length; i++) {
                    resultDtos = priceEnterLogService.addPriceEnter(strary[i]);
                }*/
                List<ResultDto> resultDtos = priceEnterLogService.addPriceEnter(jsonvist);
                logger.info("新增价格记录");
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 修改价格
     * @param priceAllDto
     * @return
     */
    @RequestMapping("/modificatPriceEnter")
    public Object modificatPriceEnter(@RequestBody PriceAllDto priceAllDto){
        String jsonvist = priceAllDto.getJsonvist();
        String cuserid = priceAllDto.getCuserid();
        String ckey = priceAllDto.getCkey();
        int ilogin_type = priceAllDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = priceEnterLogService.modificatPriceEnter(jsonvist);
                logger.info("修改价格");
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 审核价格
     * @param priceAllDto
     * @return
     */
    @RequestMapping("/auditPriceEnter")
    public Object auditPriceEnter(@RequestBody PriceAllDto priceAllDto){
        String jsonvist = priceAllDto.getJsonvist();
        String cuserid = priceAllDto.getCuserid();
        String ckey = priceAllDto.getCkey();
        int ilogin_type = priceAllDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtos = priceEnterLogService.auditPriceEnter(jsonvist);
                logger.info("审核价格");
                return baseApiService.setResultResultSuccess(resultDtos);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 延长商品上架时间
     * @return
     */
    @RequestMapping("/updateInventoryExt")
    public Object updateInventoryExt(@RequestBody PriceAllDto priceAllDto){
        int autoid = priceAllDto.getAutoid();
        String ddatee = priceAllDto.getDdatee()+" 23:59:59";
        try {
            int count = priceEnterLogService.updateInventoryExt(ddatee,autoid);
            String reslut = count>0?"操作成功":"操作失败";
            if (reslut.equals("操作成功")){
                priceEnterLogService.updateInventoryExtLog(ddatee,autoid);
            }
            return baseApiService.setResultResultSuccess(reslut);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




}
