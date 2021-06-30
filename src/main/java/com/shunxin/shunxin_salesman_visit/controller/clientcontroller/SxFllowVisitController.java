package com.shunxin.shunxin_salesman_visit.controller.clientcontroller;


import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CImagePathDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.FllowVisitList;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.StaffCus;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.Upload_pictures;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxFllowVisitService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import com.shunxin.shunxin_salesman_visit.service.promotservice.WxgzOrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sxfllowVisit")
public class SxFllowVisitController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SxFllowVisitService sxFllowVisitService;
    @Autowired
    private WxgzOrderService wxgzOrderService;
    @Autowired
    private SxPersonareaService sxPersonareaService;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private CheckService checkService;

    /**
     * 查询今天已拜访的客户列表
     * @return
     */
    @RequestMapping("/selectSxFllowVisitList")
    public Object selectSxFllowVisitList(@RequestBody ParameterDto parameterDto){
        String cuserid = parameterDto.getCuserid();
        String ckey = parameterDto.getCkey();
        int ilogin_type = parameterDto.getIlogin_type();
        String jsonvist = parameterDto.getJsonvist();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<FllowVisitListDto> fllowVisitListDtoList = sxFllowVisitService.selectSxFllowVisitList(jsonvist);
                logger.info("调用今天已拜访的客户列表接口\t参数："+jsonvist);
                return baseApiService.setResultResultSuccess(fllowVisitListDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("调用今天已拜访的客户列表接口\t参数："+jsonvist);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询单个具体的拜访记录
     * @param fllowVisitDetailDto
     * @return
     */
    @RequestMapping("/selectFllowVisitDetail")
    public Object selectFllowVisitDetail(@RequestBody FllowVisitDetailDto fllowVisitDetailDto){
        int autoid = fllowVisitDetailDto.getAutoid();
        try {
            List<FllowVisitDetailDto> fllowVisitDetailDto1 = sxFllowVisitService.selectFllowVisitDetail(autoid);
            logger.info("调用：查询单个具体的拜访记录"+"参数autoid："+autoid);
            return baseApiService.setResultResultSuccess(fllowVisitDetailDto1);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("返回结果异常："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询客户的商品资料
     * @param fllowVisitStortDto
     * @return
     */
    @RequestMapping("/selectStort")
    public Object selectStort(@RequestBody FllowVisitStortDto fllowVisitStortDto){
        int autoid = fllowVisitStortDto.getAutoid();
        String cuserid = fllowVisitStortDto.getCuserid();
        String ckey = fllowVisitStortDto.getCkey();
        int ilogin_type = fllowVisitStortDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<FllowVisitStortDto> fllowVisitStortDto1  = sxFllowVisitService.selectStort(autoid);
                logger.info("调用：查询客户的商品资料"+"参数autoid："+autoid);
                return baseApiService.setResultResultSuccess(fllowVisitStortDto1);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("返回结果异常："+e.toString());
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 添加拜访记录
     * @return
     */
    @RequestMapping("/insertFllowVisit")
    public Object insertFllowVisit(@RequestBody ReqDto reqDto){
        String json = reqDto.getJsonvisit().replace("'","\"");
        String cuserid = reqDto.getCuserid();
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<ResultDto> result = sxFllowVisitService.insertFllowVisit(json);
                logger.info("调用添加拜访记录接口\t参数："+json+"\n返回结果："+result);
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("调用添加拜访记录接口\t参数："+json+"\n返回结果异常："+e);
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询5分钟内同一业务员是否有拜访记录
     * @return
     */
    @RequestMapping("/getFllowVistt")
    public Object getFllowVistt(@RequestBody PersonDto personDto){
        String cfllow_pid = personDto.getCfllow_pid();
        String result = "";
        try {
            int count = sxFllowVisitService.getFllowVistt(cfllow_pid);
            result = count>0?"error":"success";
            return baseApiService.setResultResultSuccess(result);
        }catch(Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 新增拜访记录（新接口）
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertFllowVisit2")
    public Object insertFllowVisit2(@RequestBody ReqDto reqDto){
        String json = reqDto.getJsonvisit().replace("'","\"");
        String photos = reqDto.getPhotos().replace("'","\"");
        String cuserid = reqDto.getCuserid();   //工号
        String ckey = reqDto.getCkey();
        int ilogin_type = reqDto.getIlogin_type();
        String ccus_id = reqDto.getCcus_id();
        String [] strarry = new String[15];   //定义数值存储图片路径
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                Upload_pictures upload_pictures = new Upload_pictures();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String[] date = df.format(new Date()).split("-");// new Date()为获取当前系统时间
                JSONArray jsonArray = JSONArray.fromObject(photos);
                JSONArray jsonArray1 = new JSONArray();  //定义新的JSONArray存储修改后的JSONObject
                int numer = 0;
                for (Object obj : jsonArray) {
                    String random = (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)+".jpg";     //随机生成图片名称
                    JSONObject jsonObject = JSONObject.fromObject(obj.toString());
                    String cimg_path = jsonObject.get("CIMG_PATH").toString();
                    String cimg_type = jsonObject.get("CIMG_TYPE").toString();
                    if (Integer.valueOf(cimg_type)==1){
                        String path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\doorfirst";
                        strarry[numer] = upload_pictures.upload3(cimg_path,path,cuserid+"_"+ccus_id+"_"+random);
                        jsonObject.put("CIMG_PATH",strarry[numer]);
                    }else if (Integer.valueOf(cimg_type)==2){
                        String path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\display";
                        strarry[numer] = upload_pictures.upload3(cimg_path,path,cuserid+"_"+ccus_id+"_"+random);
                        jsonObject.put("CIMG_PATH",strarry[numer]);
                    }else if (Integer.valueOf(cimg_type)==3){
                        String path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\freezer";
                        strarry[numer] = upload_pictures.upload3(cimg_path,path,cuserid+"_"+ccus_id+"_"+random);
                        jsonObject.put("CIMG_PATH",strarry[numer]);
                    }else if (Integer.valueOf(cimg_type)==4){
                        String path = "E:\\wwwroot\\pic\\sxemall\\"+date[0]+date[1]+"\\shelves";
                        strarry[numer] = upload_pictures.upload3(cimg_path,path,cuserid+"_"+ccus_id+"_"+random);
                        jsonObject.put("CIMG_PATH",strarry[numer]);
                    }
                    jsonArray1.add(jsonObject);    //赋值
                    numer++;
                }
                JSONArray jsonArray2 = JSONArray.fromObject(json);
                List<ResultDto> result = new ArrayList<>();
                for (Object ob : jsonArray2) {
                    JSONObject jsonObject2 = JSONObject.fromObject(ob.toString());
                    jsonObject2.put("PHOTOS",jsonArray1);   //将图片赋值给jsonvisit
                    result = sxFllowVisitService.insertFllowVisit("["+jsonObject2.toString()+"]");  //调用方法
                    logger.info("调用新增拜访接口，参数为："+"["+jsonObject2.toString()+"]"+"\t返回的结果："+result);
                    for (ResultDto resultDto : result) {
                        if (!resultDto.getMsg().equals("保存成功")){       //如果返回的不是保存成功，则删除掉上传的图片
                            for (int i = 0; i < strarry.length; i++) {
                                if (strarry[i]!=null && !strarry[i].equals("")){
                                    String fullFilePath = "E:\\wwwroot\\pic\\sxemall\\"+strarry[i].replace("/","\\");    //获得图片的绝对路径
                                    File deleteFile = new File(fullFilePath);
                                    if (deleteFile.exists() && deleteFile.isFile()) {
                                        deleteFile.delete();    //执行删除操作
                                    }
                                }
                            }
                        }
                    }
                }
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("调用新增拜访记录接口"+"\n返回结果异常："+e);
            for (int i = 0; i < strarry.length; i++) {      //如果抛出异常也需要把上传过的图片删除掉
                if (strarry[i]!=null && !strarry[i].equals("")){
                    String fullFilePath = "E:\\wwwroot\\pic\\sxemall\\"+strarry[i].replace("/","\\");
                    File deleteFile = new File(fullFilePath);
                    if (deleteFile.exists() && deleteFile.isFile()) {
                        deleteFile.delete();
                    }
                }
            }
            return baseApiService.setResultError("图片上传错误");
        }
    }



    /**
     * 查询统计表
     * @param response
     * @return
     */
    @RequestMapping("/selectStatistics")
    public Object selectStatistics(HttpServletResponse response,@RequestBody StatisticsDto statisticsDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String ctypes = statisticsDto.getCtype();
        String userid = statisticsDto.getUserid();
        String dateb = statisticsDto.getDateb();
        String datee = statisticsDto.getDatee();

        String cuserid = statisticsDto.getCuserid();
        String ckey = statisticsDto.getCkey();
        int ilogin_type = statisticsDto.getIlogin_type();

        List<String> ctype = new ArrayList<String>();
        List<String> company = new ArrayList<String>();
        List<Object> datas = new ArrayList<Object>();
        JSONArray main_data = new JSONArray();
        JSONObject result = new JSONObject();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List<StatisDto> statisJson = sxFllowVisitService.selectStatistics(ctypes,userid,dateb,datee);
                int indexs = 0;
                for(Object json : statisJson){
                    JSONObject maleArray = JSONObject.fromObject(json);
                    Iterator male_Iterator = maleArray.keys();
                    List<String> data =new ArrayList<String>();
                    while(male_Iterator.hasNext()){
                        String key = male_Iterator.next().toString();
                        if (key.equals("平均")){
                            key = "拜访";
                        }else if (key.equals("拜访")){
                            key = "平均";
                        }
                        if (indexs==0){
                            ctype.add(""+key+"");
                        }
                        data.add(maleArray.getString(key));
                    }
                    indexs++;
                    datas.add(data);
                }
                if(ctype.size()!=0){
                    ctype.remove(0);
                }
                for(int i = 0;i<ctype.size();i++){
                    List<Object> shuju = new ArrayList<>();
                    for(int j = 0;j<datas.size();j++){
                        List<String> lll = (List<String>) datas.get(j);
                        Object[] data = lll.toArray(new String[0]);
                        if(i==0){
                            company.add(""+data[0].toString()+"");
                        }
                        //shuju.add(Double.valueOf(data[i+1].toString()));
                        shuju.add(Double.valueOf("".equals(data[i+1].toString())?"0.00":data[i+1].toString()));
                    }
                    main_data.add(shuju);
                }
                result.put("ctype", ctype);
                result.put("company", company);
                result.element("data", main_data);
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
     * 查询单个区域的详情
     * @param response
     * @return
     */
    @RequestMapping("/selectStatisalesman")
    public Object selectStatisalesman(HttpServletResponse response,@RequestBody StatisticsDto statisticsDto){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String ctypes = statisticsDto.getCtype();
        String userid = statisticsDto.getUserid();
        String dateb = statisticsDto.getDateb();
        String datee = statisticsDto.getDatee();

        String cuserid = statisticsDto.getCuserid();
        String ckey = statisticsDto.getCkey();
        int ilogin_type = statisticsDto.getIlogin_type();

        List<String> ctype =new ArrayList<String>();
        List<String> company =new ArrayList<String>();
        List<Object> datas =new ArrayList<Object>();
        JSONArray main_data = new JSONArray();
        JSONObject result = new JSONObject();
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                List statisJson = sxFllowVisitService.selectStatisalesman(ctypes,userid,dateb,datee);
                if(statisJson.size()!=0){
                    int indexs = 0;
                    for(Object json : statisJson){
                        JSONObject maleArray = JSONObject.fromObject(json);
                        Iterator male_Iterator = maleArray.keys();
                        List<String> data =new ArrayList<String>();
                        while(male_Iterator.hasNext()){
                            String key = male_Iterator.next().toString();
                            if (indexs==0){
                                ctype.add(key);
                            }
                            data.add(maleArray.getString(key));
                        }
                        indexs++;
                        datas.add(data);
                    }
                    ctype.remove(0);
                    List<Object> shuju = new ArrayList<>();
                    for(int i = 0;i<ctype.size();i++){
                        JSONObject user = new JSONObject();
                        for(int j = 0;j<datas.size();j++){
                            List<String> lll = (List<String>) datas.get(j);
                            Object[] data = lll.toArray(new String[0]);
                            if(i==0){
                                company.add(""+data[0].toString()+"");
                            }
                            shuju.add(Double.valueOf("".equals(data[i+1].toString())?"0.00":data[i+1].toString()));
                            //shuju.add(Double.valueOf(data[i+1].toString()));
                        }
                        user.put("data", shuju);
                        main_data.add(user);
                    }
                    result.put("ctype",ctypes);
                    result.put("company", company);
                    result.element("data", shuju);
                }else {
                    result.put("ctype",ctypes);
                }
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
     * 查询地图
     * @param response
     * @param mapDto
     * @return
     */
    @RequestMapping("/selectMapinfo")
    public Object selectMapinfo(HttpServletResponse response, @RequestBody Map_parameterDto mapDto){
        String ctype = mapDto.getCtype();
        String sales = mapDto.getSales();
        String userid = mapDto.getUserid();
        Date datea = mapDto.getDatea();
        Date datee = mapDto.getDatee();
        String ckey = mapDto.getCkey();
        String coloron = mapDto.getColoron();
        logger.info("ctype："+ctype+"&&sales："+sales+"&&userid："+userid+"&&datea："+datea+"&&datee："+datee+"&&coloron："+coloron);
        try {
            List<MapDto> mapDtoList = sxFllowVisitService.selectMapinfo(ckey,ctype,sales,userid,datea,datee,coloron);
            logger.info("查询地图");
            return baseApiService.setResultResultSuccess(mapDtoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询店铺的位置
     * @param response
     * @param meterDto
     * @return
     */
    @RequestMapping("/selectBusiness")
    public Object selectBusiness(HttpServletResponse response, @RequestBody ParameterDto meterDto){
        String ctype = meterDto.getCtype();
        String stype = meterDto.getStype();
        String userid = meterDto.getUserid();
        Date date1 = meterDto.getDate1();
        Date date2 = meterDto.getDate2();
        String param1 = meterDto.getParam1();
        String param2 = meterDto.getParam2();
        String ckey = meterDto.getCkey();
        try {
            List<BusinessDto> businessDtoList = sxFllowVisitService.selectBusiness(ckey,ctype,stype,userid,date1,date2,param1,param2);
            return baseApiService.setResultResultSuccess(businessDtoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询某日拜访记录
     * @param meterDto
     * @return
     */
    @RequestMapping("/selectVisitInfos")
    public Object selectVisitInfos(@RequestBody ParameterDto meterDto){
        String jsonvist = meterDto.getJsonvist();
        String cuserid = meterDto.getCuserid();
        String ckey = meterDto.getCkey();
        int ilogin_type = meterDto.getIlogin_type();
        String ctype = meterDto.getCtype();
        String results2 = "";
        try {
            if (ctype.equals("hnsx")){
                results2 = "1";
            }else {
                results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            }
            if (results2.equals("1")){
                List<FllowVisitinfoDto> fllowVisitinfoDtoList = sxFllowVisitService.selectVisitInfos(jsonvist);
                for (FllowVisitinfoDto visitinfoDto : fllowVisitinfoDtoList) {
                    if (visitinfoDto.getImg1_1()!=null&&!visitinfoDto.getImg1_1().equals("")){
                        visitinfoDto.setImg1_1("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg1_1());
                    }
                    if (visitinfoDto.getImg1_2()!=null&&!visitinfoDto.getImg1_2().equals("")){
                        visitinfoDto.setImg1_2("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg1_2());
                    }
                    if (visitinfoDto.getImg1_3()!=null&&!visitinfoDto.getImg1_3().equals("")){
                        visitinfoDto.setImg1_3("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg1_3());
                    }
                    if (visitinfoDto.getImg1_4()!=null&&!visitinfoDto.getImg1_4().equals("")){
                        visitinfoDto.setImg1_4("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg1_4());
                    }
                    if (visitinfoDto.getImg1_5()!=null&&!visitinfoDto.getImg1_5().equals("")){
                        visitinfoDto.setImg1_5("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg1_5());
                    }
                    if (visitinfoDto.getImg2_1()!=null&&!visitinfoDto.getImg2_1().equals("")){
                        visitinfoDto.setImg2_1("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg2_1());
                    }
                    if (visitinfoDto.getImg2_2()!=null&&!visitinfoDto.getImg2_2().equals("")){
                        visitinfoDto.setImg2_2("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg2_2());
                    }
                    if (visitinfoDto.getImg2_3()!=null&&!visitinfoDto.getImg2_3().equals("")){
                        visitinfoDto.setImg2_3("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg2_3());
                    }
                    if (visitinfoDto.getImg2_4()!=null&&!visitinfoDto.getImg2_4().equals("")){
                        visitinfoDto.setImg2_4("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg2_4());
                    }
                    if (visitinfoDto.getImg2_5()!=null&&!visitinfoDto.getImg2_5().equals("")){
                        visitinfoDto.setImg2_5("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg2_5());
                    }
                    if (visitinfoDto.getImg3_1()!=null&&!visitinfoDto.getImg3_1().equals("")){
                        visitinfoDto.setImg3_1("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg3_1());
                    }
                    if (visitinfoDto.getImg3_2()!=null&&!visitinfoDto.getImg3_2().equals("")){
                        visitinfoDto.setImg3_2("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg3_2());
                    }
                    if (visitinfoDto.getImg3_3()!=null&&!visitinfoDto.getImg3_3().equals("")){
                        visitinfoDto.setImg3_3("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg3_3());
                    }
                    if (visitinfoDto.getImg3_4()!=null&&!visitinfoDto.getImg3_4().equals("")){
                        visitinfoDto.setImg3_4("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg3_4());
                    }
                    if (visitinfoDto.getImg3_5()!=null&&!visitinfoDto.getImg3_5().equals("")){
                        visitinfoDto.setImg3_5("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg3_5());
                    }
                    if (visitinfoDto.getImg4_1()!=null&&!visitinfoDto.getImg4_1().equals("")){
                        visitinfoDto.setImg4_1("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg4_1());
                    }
                    if (visitinfoDto.getImg4_2()!=null&&!visitinfoDto.getImg4_2().equals("")){
                        visitinfoDto.setImg4_2("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg4_2());
                    }
                    if (visitinfoDto.getImg4_3()!=null&&!visitinfoDto.getImg4_3().equals("")){
                        visitinfoDto.setImg4_3("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg4_3());
                    }
                    if (visitinfoDto.getImg4_4()!=null&&!visitinfoDto.getImg4_4().equals("")){
                        visitinfoDto.setImg4_4("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg4_4());
                    }
                    if (visitinfoDto.getImg4_5()!=null&&!visitinfoDto.getImg4_5().equals("")){
                        visitinfoDto.setImg4_5("http://pic.hnsxtj.com/sxemall/"+visitinfoDto.getImg4_5());
                    }
                }
                return baseApiService.setResultResultSuccess(fllowVisitinfoDtoList);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询销量和售点分布（柱状图和售点图）
     * @return
     */
    @RequestMapping("/selectMaySales")
    public Object selectMaySales(@RequestBody ParameterDto meterDto){
        String ctype = meterDto.getCtype();   //Cellular  销量柱状，MaySell  售点 , AllSell  累计所有售点,PayaVisit   拜访
        String ddate= meterDto.getDdate();
        Date date1 = meterDto.getDate1();
        Date date2 = meterDto.getDate2();
        String cuser_id = meterDto.getCuser_id();
        String cdepartment_id = meterDto.getCdepartment_id();
        String ccus_comid = meterDto.getCcus_comid();
        String ckey = "COH136065916713";
        try {
                if (ctype.equals("Cellular")){
                    List<MapDto> mapDtoList = sxFllowVisitService.selectMapinfo(ckey,"Cellular","01","01227",date1,date2,"");
                    return baseApiService.setResultResultSuccess(mapDtoList);
                }else if (ctype.equals("MaySell")){
                    List<BusinessDto> businessDtoList = sxFllowVisitService.selectMaySellDot(ddate,cuser_id,cdepartment_id,ccus_comid);
                    return baseApiService.setResultResultSuccess(businessDtoList);
                }else if (ctype.equals("AllSell")){
                    List<BusinessDto> businessDtoList = sxFllowVisitService.selectAllSellDot();
                    return baseApiService.setResultResultSuccess(businessDtoList);
                }else if (ctype.equals("PayaVisit")){
                    List<BusinessDto> businessDtoList = sxFllowVisitService.selectFllowDto(ddate,cuser_id,cdepartment_id,ccus_comid);
                    return baseApiService.setResultResultSuccess(businessDtoList);
                }
                else {
                    return baseApiService.setResultResultSuccess("类型为空，无法查询");
                }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据工号查询客户
     * @return
     */
    @RequestMapping("/getStaffCus")
    public Object getStaffCus(@RequestBody ParameterDto meterDto){
        String ccode = meterDto.getCcode();
        try {
            List<StaffCus> staffCusList = sxFllowVisitService.getStaffCus(ccode);
            return baseApiService.setResultResultSuccess(staffCusList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询所有客户的坐标或将腾讯坐标修改为百度坐标
     * @return
     */
    @RequestMapping("/getCusAddress")
    public Object getCusAddress(@RequestBody ParameterDto meterDto){
        String ctype = meterDto.getCtype();
        String ccus_address = meterDto.getCcus_address();
        String autoid = meterDto.getAutoid();
        try {
            if (ctype.equals("01")){
                List<StaffCus> staffCusList = sxFllowVisitService.getCusAddress();
                return baseApiService.setResultResultSuccess(staffCusList);
            }else {
                int count = sxFllowVisitService.updateCusAddress(ccus_address,autoid);
                String result = count>0?"修改成功":"修改失败";
                return baseApiService.setResultResultSuccess(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询今日每个业务员的最新拜访位置
     * @param fllowVisit
     * @return
     */
    @RequestMapping("/getFllowVistList")
    public Object getFllowVistList(@RequestBody FllowVisitList fllowVisit){
        String ccomcode = fllowVisit.getCcomcode();
        String cfllow_pid = fllowVisit.getCfllow_pid();
        String centre_lat = "";
        String centre_lng = "";
        try {
            Map<Object,Object> map = new HashMap<>();
            List<FllowVisitList> fllowVisitLists = sxFllowVisitService.getFllowVistList(ccomcode,cfllow_pid);
            for (FllowVisitList visitList : fllowVisitLists) {
                //将腾讯坐标转换为百度坐标
                Double lat = visitList.getCfllow_xpoint().doubleValue(); //纬度 lat
                Double lng = visitList.getCfllow_ypoint().doubleValue();  //经度 lng
                String res = map_tx2bd(lat,lng);
                String ylng = res.substring(0,res.indexOf(","));
                String xlat = res.substring(res.indexOf(",")+1,res.length());
                visitList.setCfllow_xpoint(BigDecimal.valueOf(Double.valueOf(xlat)));
                visitList.setCfllow_ypoint(BigDecimal.valueOf(Double.valueOf(ylng)));
                //获取图片地址
                int autoid = visitList.getAutoid();
                List<CImagePathDto> cImagePathDtoList = wxgzOrderService.getCimgPath(autoid);
                List<String> lists = new ArrayList<>();
                for (CImagePathDto pathDto : cImagePathDtoList) {
                    String cimg_poth = "http://pic.hnsxtj.com/sxemall/"+pathDto.getCimg_path();
                    lists.add(cimg_poth);
                    visitList.setCimg_path(lists);
                }
            }
            if (ccomcode.equals("")||ccomcode.equals("20")){ //全图和河东都以总部为中心
                centre_lat = "28.184248";
                centre_lng = "112.996925";
            }else if (ccomcode.equals("05")){  //河西以汽车西站为中心
                centre_lat = "28.206541";
                centre_lng = "112.914281";
            }
            String update_time = sxPersonareaService.getInformCvalues("fllow_update_time"); //数据刷新时间
            map.put("update_time",update_time);
            map.put("centre_lat",centre_lat);
            map.put("centre_lng",centre_lng);
            map.put("fllowList",fllowVisitLists);
            return baseApiService.setResultResultSuccess(map);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 坐标转换，腾讯地图转换成百度地图坐标
     * @param lat 腾讯纬度
     * @param lon 腾讯经度
     * @return 返回结果：经度,纬度
     */
    public String map_tx2bd(double lat, double lon){
        double bd_lat;
        double bd_lon;
        double x_pi=3.14159265358979324;
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        bd_lon = z * Math.cos(theta) + 0.0065;
        bd_lat = z * Math.sin(theta) + 0.006;
        return bd_lon+","+bd_lat;
    }



}
