package com.shunxin.shunxin_salesman_visit.controller.CheckController;

import com.shunxin.shunxin_salesman_visit.dto.checkdto.StockDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Group;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.InventoryStock;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Stock;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.Upload_pictures;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.StockService;
import com.shunxin.shunxin_salesman_visit.util.DistanceUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品库存
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/stockinfo")
public class StockController {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StockService stockService;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private CheckService checkService;


    /**
     * 查询商品分类
     * @return
     */
    @RequestMapping("/selectInventoryOne")
    public Object selectInventoryOne(@RequestBody StockDto stockDto){
        String cuserid = stockDto.getCuserid();
        String ckey = stockDto.getCkey();
        int ilogin_type = stockDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<InventoryStock> inventoryClassList = stockService.selectInventoryOne();
                return baseApiService.setResultResultSuccess(inventoryClassList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询商品列表
     * @return
     */
    @RequestMapping("/selectStockinfo")
    public Object selectStockinfo(@RequestBody StockDto stockDto){
        String cuserid = stockDto.getCuserid();
        String ckey = stockDto.getCkey();
        int ilogin_type = stockDto.getIlogin_type();
        String cinvccode = stockDto.getCinvccode();
        String cinvcode = stockDto.getCinvcode();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<Stock> stockList = stockService.selectStockinfo(cinvccode,cinvcode);
                for (Stock stock : stockList) {
                    if (stock.getCinvimg()!=null){
                        stock.setCinvimg("http://pic.hnsxtj.com/sxemall/public/"+stock.getCinvimg()+"_500.jpg");
                    }
                }
                return baseApiService.setResultResultSuccess(stockList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 录入库存商品
     * @param stockDto
     * @return
     */
    @RequestMapping("/enterStock")
    public Object enterStock(@RequestBody StockDto stockDto){
        String jsonvist = stockDto.getJsonvist();
        JSONObject jsonObject =JSONObject.fromObject(jsonvist);
        String cinvimg = jsonObject.get("cinvimg").toString();  //获取到图片的base64编码
        String imgName = jsonObject.get("cinvcode").toString();
        Upload_pictures upload_pictures = new Upload_pictures();
        String fileUrl = "E:\\wwwroot\\pic\\sxemall\\public";
        for (int i = 0; i < 2; i++) {
            String path = upload_pictures.upload2(cinvimg,fileUrl,imgName+"_"+i+"_500");    //保存图片
            if (path==null||path.equals("")){
                return baseApiService.setResultResultSuccess("执行成功，但图片保存失败");
            }
            DistanceUtils.zoomImage(fileUrl+"\\"+imgName+"_"+i+"_500.jpg",fileUrl+"\\"+imgName+"_"+i+"_64.jpg",64,64);
            String imgurl = path.substring(path.lastIndexOf("\\")+1);
            if (jsonObject.get("cinvimg") != null) {
                jsonObject.put("cinvimg", imgurl);
            }
        }
        jsonObject.put("cinvimg",imgName+"_1_500.jpg");
        jsonObject.put("bsale",0);
        jsonObject.put("bpurchase",0);
        jsonObject.put("bself",0);
        jsonObject.put("bcomsume",0);
        jsonObject.put("bproducing",0);
        jsonObject.put("bservice",0);
        String inveatt = jsonObject.get("inveatt").toString();
        String str1 = inveatt.substring(1,inveatt.lastIndexOf("]"));
        String [] strs = str1.split(",");
        for (int i = 0; i < strs.length; i++) {
            String jiegou = strs[i].substring(1,strs[i].lastIndexOf("\""));
            if (jiegou.equals("bsale")){
                jsonObject.put("bsale",1);
            }else if (jiegou.equals("bpurchase")){
                jsonObject.put("bpurchase",1);
            }else if (jiegou.equals("bself")){
                jsonObject.put("bself",1);
            }else if (jiegou.equals("bcomsume")){
                jsonObject.put("bcomsume",1);
            }else if (jiegou.equals("bproducing")){
                jsonObject.put("bproducing",1);
            }else if (jiegou.equals("bservice")){
                jsonObject.put("bservice",1);
            }
        }
        try {
            List<ResultDto> resultDtos = stockService.enterStock(jsonObject.toString());
            logger.info("录入库存商品："+jsonObject.toString());
            return baseApiService.setResultResultSuccess(resultDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**select CPERSON_ID from customer_v
     * 审核存货商品
     * @param stockDto
     * @return
     */
    @RequestMapping("/checkStock")
    public Object checkStock(@RequestBody StockDto stockDto){
        String cuserid = stockDto.getCuserid();
        String ckey = stockDto.getCkey();
        int ilogin_type = stockDto.getIlogin_type();
        String jsonvist = stockDto.getJsonvist();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtoList = stockService.checkStock(jsonvist);
                logger.info("审核存货商品："+jsonvist);
                return baseApiService.setResultResultSuccess(resultDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 禁用存货商品
     * @param stockDto
     * @return
     */
    @RequestMapping("/forbidStock")
    public Object forbidStock(@RequestBody StockDto stockDto){
        String cuserid = stockDto.getCuserid();
        String ckey = stockDto.getCkey();
        int ilogin_type = stockDto.getIlogin_type();
        String jsonvist = stockDto.getJsonvist();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtoList = stockService.forbidStock(jsonvist);
                logger.info("禁用存货商品："+jsonvist);
                return baseApiService.setResultResultSuccess(resultDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 删除存货商品
     * @param stockDto
     * @return
     */
    @RequestMapping("/deleteStock")
    public Object deleteStock(@RequestBody StockDto stockDto){
        String cuserid = stockDto.getCuserid();
        String ckey = stockDto.getCkey();
        int ilogin_type = stockDto.getIlogin_type();
        String jsonvist = stockDto.getJsonvist();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> resultDtoList = stockService.deleteStock(jsonvist);
                logger.info("删除存货商品："+jsonvist);
                return baseApiService.setResultResultSuccess(resultDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询计量单位类别
     * @return
     */
    @RequestMapping("/selectGroupType")
    public Object selectGroupType(){
        try {
            List<Group> groupList = stockService.selectGroupType();
            return baseApiService.setResultResultSuccess(groupList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据存货编码修改图片
     * @return
     */
    @RequestMapping("/UpdateInventotyImg")
    public Object UpdateInventotyImg(@RequestBody StockDto stockDto){
        String jsonvist = stockDto.getJsonvist();
        JSONObject jsonObject =JSONObject.fromObject(jsonvist);
        String cinvcode = jsonObject.get("cinvcode").toString();
        String cinvimg = jsonObject.get("cinvimg").toString();  //获取到图片的base64编码
        String imgurl = "";
        Upload_pictures upload_pictures = new Upload_pictures();
        String fileUrl = "E:\\wwwroot\\pic\\sxemall\\public";
        for (int i = 0; i < 2; i++) {
            String path = upload_pictures.upload2(cinvimg,fileUrl,cinvcode+"_"+i+"_500");    //保存图片
            DistanceUtils.zoomImage(fileUrl+"\\"+cinvcode+"_"+i+"_500.jpg",fileUrl+"\\"+cinvcode+"_"+i+"_64.jpg",64,64);
            imgurl = path.substring(path.lastIndexOf("\\")+1);
        }
        try {
            String result = "";
            stockService.deleteInventotyImg(cinvcode);
            int count = stockService.insertInventotyImg(cinvcode,cinvcode+"_1",cinvcode+"_0");
            result = count>0?"保存成功":"保存失败";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




}
