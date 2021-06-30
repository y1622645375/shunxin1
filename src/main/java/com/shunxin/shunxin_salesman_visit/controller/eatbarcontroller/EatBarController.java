package com.shunxin.shunxin_salesman_visit.controller.eatbarcontroller;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ReqDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.*;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.PromotionDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.*;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.Upload_pictures;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.EatBarService;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/eatBar")
public class EatBarController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EatBarService eatBarService;

    @Autowired
    private BaseApiService baseApiService;

    @Autowired
    private UserInfoUtil userInfoUtil;


    /**
     * 生日祝福弹幕
     * @return
     */
    @RequestMapping("/getCuserCode")
    public Object getCuserCode(){
        try {
            List<BirthdayDto> birthdayDtos = eatBarService.getBirthdayList();
            return baseApiService.setResultResultSuccess(birthdayDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增生日祝福
     * @param birthdayDto
     * @return
     */
    @RequestMapping("/addBirthday")
    public Object addBirthday(@RequestBody BirthdayDto birthdayDto){
        String greeting = birthdayDto.getGreeting();
        String result ="";
        try {
            int count = eatBarService.addBirthday(greeting);
            result = count>0?"成功":"失败";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增或修改地址
     * @return
     */
    @RequestMapping("/addStaffTmp")
    public Object addStaffTmp(@RequestBody BirthdayDto birthdayDto){
        String cname = "";
        String ccode = birthdayDto.getCcode();
        String xpoint = birthdayDto.getXpoint();
        String ypoint = birthdayDto.getYpoint();
        String cadress = birthdayDto.getCadress();
        String ctype = birthdayDto.getCtype();  //01 新增，02 修改
        String result = "";
        try {
            cname = eatBarService.getCname(ccode); //工号获取姓名
            if (ctype.equals("01")){
                eatBarService.addStaffTmp(cname,ccode,xpoint,ypoint,cadress);
                result = "保存成功";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询员工住址信息
     * @return
     */
    @RequestMapping("/getStaffTmp")
    public Object getStaffTmp(@RequestBody BirthdayDto birthdayDto){
        String ctype = birthdayDto.getCtype();
        String ccode = birthdayDto.getCcode();
        try {
            if (ctype.equals("01")){
                if (ccode==null){
                    ccode = "";
                }
                List<staffTmpDto> staffTmpDtoList = eatBarService.getStaffTmp(ccode);
                return baseApiService.setResultResultSuccess(staffTmpDtoList);
            }else {
                List<CustomerAddress> addresses = eatBarService.getLinsiAddress();
                return baseApiService.setResultResultSuccess(addresses);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




    /**
     * 查询今日菜单
     * @param
     * @return
     */
    @RequestMapping("/selectMenusList")
    public Object selectMenusList(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String daytime = sdf.format(d);
        try {
            List<EatMenus> eatMenusList = eatBarService.selectMenusList(daytime);
            return baseApiService.setResultResultSuccess(eatMenusList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增今日菜单
     * @param eatMenus
     * @return
     */
    @RequestMapping("/addMenus")
    public Object addMenus(@RequestBody EatMenus eatMenus){
        String result = "";
        String me_name = eatMenus.getMe_name();
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateTime = sdf.format(date);
            int couns = eatBarService.getMenusCount(dateTime);
            if(couns<=3){
                String [] szName =me_name.split("/");
                for (String str : szName) {
                    int count = eatBarService.addMenus(str);
                    result = count>0?"新增成功":"新增失败";
                }
            }else {
                result = "今日已录入，无法再次录入";
            }
            //String ap_dtime = eatBarService.getApDtime();
            String ap_dtime = "2020-08-08";
            List<EatApplyDto> eatApplies = eatBarService.selectApply(ap_dtime);
            for (int i = 0; i < eatApplies.size(); i++) {
                eatBarService.addApply(eatApplies.get(i).getAp_code(),"1");
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 修改菜单
     * @param eatMenus
     * @return
     */
    @RequestMapping("/updateMenus")
    public Object updateMenus(@RequestBody EatMenus eatMenus){
        String result = "";
        String me_name = eatMenus.getMe_name();
        int me_id = eatMenus.getMe_id();
        try {
            int count = eatBarService.updateMenus(me_name,me_id);
            result = count>0?"修改成功":"修改失败";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }



    /**
     * 新增允许吃饭人员名单
     * @param eatStaff
     * @return
     */
    @RequestMapping("/addStaff")
    public Object addStaff(@RequestBody EatStaff eatStaff){
        String st_code = eatStaff.getSt_code();
        String st_remark = eatStaff.getSt_remark();
        try {
            String result = "";
            String cname = eatBarService.getCname(st_code);
            if(cname!=null){
                List<EatStaff> staffList = eatBarService.selectStaff(st_code,"");
                if (staffList.size()==0){
                    int count = eatBarService.addStaff(st_code,cname,st_remark);
                    //int count2 = eatBarService.insertWxBinds(st_code);
                    result = count>0?"新增成功":"新增失败";
                }else {
                    result = "该人员已存在，请勿重复添加";
                }
            }else {
                result = "工号错误，不存在该人员";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询允许吃饭人员名单
     * @param eatStaff
     * @return
     */
    @RequestMapping("/selectStaff")
    public Object selectStaff(@RequestBody EatStaff eatStaff){
        String st_code = eatStaff.getSt_code();
        String st_name = eatStaff.getSt_name();
        try {
            List<EatStaff> staffList = eatBarService.selectStaff(st_code,st_name);
            return baseApiService.setResultResultSuccess(staffList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 删除允许吃饭人员
     * @param eatStaff
     * @return
     */
    @RequestMapping("/deleteStaff")
    public Object deleteStaff(@RequestBody EatStaff eatStaff){
        String result = "";
        int st_id = eatStaff.getSt_id();
        try {
            int count = eatBarService.deleteStaff(st_id);
            String st_code = eatBarService.selectStcode(st_id);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datetime = sdf.format(date);
            eatBarService.updateAppleCode("4",st_code,datetime);
            result = count>0?"删除成功":"删除失败";
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增今日报餐人员
     * @param eatApply
     * @return
     */
    @RequestMapping("/addApply")
    public Object addApply(@RequestBody EatApply eatApply){
        String result = "";
        String ap_code = eatApply.getAp_code();
        String ap_type = eatApply.getAp_type();
        try {
            if (ap_code!=null){
                List<EatStaff> staffList = eatBarService.selectStaff(ap_code,"");
                if (staffList.size()>0){
                    /*Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String datetime = sdf.format(date);
                    int quantity = eatBarService.getApplyInfo(ap_code,datetime);*/
                        int count = eatBarService.addApply(ap_code,ap_type);
                        result = count>0?"报餐成功":"报餐失败";
                  /*  }else {
                        int count2 = eatBarService.updateAppleCode(ap_type,ap_code,datetime);
                        result = count2>0?"修改成功":"修改失败";
                    }*/
                }else {
                    result = "非本公司就餐人员无法报餐";
                }
            }else {
                result = "工号为空，请重新扫码";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询今日报餐人员
     * @return
     */
    @RequestMapping("/selectApply")
    public Object selectApply(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = sdf.format(date);
        try {
            List<EatApplyDto> applyList = eatBarService.selectApply(dateTime);
            return baseApiService.setResultResultSuccess(applyList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询历史菜名
     * @param eatMenus
     * @return
     */
    @RequestMapping("/selectMenusName")
    public Object selectMenusName(@RequestBody EatMenus eatMenus){
        String me_name = eatMenus.getMe_name();
        try {
            System.out.println(me_name);
            List<EatMenus> menusList = eatBarService.selectMenusName(me_name);
            return baseApiService.setResultResultSuccess(menusList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过Code获取OPenid
     * @param commonDto
     * @return
     */
    @RequestMapping("/getSignOpenid")
    public Object getSignOpenid(@RequestBody CommonDto commonDto){
        String scanCode = commonDto.getScanCode();
        String per_openid = "";
        try {
            if(scanCode!=null||!scanCode.equals("")){
                per_openid = userInfoUtil.getGzOpenid(scanCode);
            }
            return baseApiService.setResultResultSuccess(per_openid);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 通过openid查询工号
     * @param commonDto
     * @return
     */
    @RequestMapping("/selectStaffOne")
    public Object selectStaffOne(@RequestBody CommonDto commonDto){
        String wx_openid = commonDto.getWxOpenid();
        try {
            String wx_code = eatBarService.getWxCode(wx_openid);
            if(wx_code==null){
                wx_code = "";
            }
            logger.info("通过openid查询工号");
            return baseApiService.setResultResultSuccess(wx_code);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 扫码绑定Openid
     * @param eatWxBind
     * @return
     */
    @RequestMapping("/bandingWxOpen")
    public Object bandingWxOpen(@RequestBody EatWxBind eatWxBind){
        String result = "";
        String wx_code = eatWxBind.getWx_code();
        String wx_openid = eatWxBind.getWx_openid();
        try {
            if (wx_code!=null&&!wx_code.equals("")&&wx_openid!=null&&!wx_openid.equals("")){
                String code = eatBarService.selectWxCode(wx_code);
                if (code==null){
                    int count = eatBarService.bandingWxOpen(wx_code,wx_openid);
                    result = count>0?"绑定成功":"绑定失败";
                }else {
                    result = "已绑定，请勿重复绑定";
                }
            }else {
                result = "有参数为空，无法绑定";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询今日所有员工的工作汇报
     * @param dayrepory
     * @return
     */
    @RequestMapping("/selectDayrepory")
    public Object selectDayrepory(@RequestBody DayreporyDto dayrepory){
        String ddate = dayrepory.getDdate();
        String cpcode = dayrepory.getCpcode();
        try {
            String ctype = dayrepory.getCtype();
            logger.info("时间："+ddate+"工号："+cpcode+"类型："+ctype);
            if (ctype.equals("B")){  //查询自己当日工作汇报
                List<TmpSxDayrepory> dayreporyList = eatBarService.selectDayreporyTwo(ddate,cpcode);
                for (TmpSxDayrepory sxDayrepory : dayreporyList) {
                    sxDayrepory.setCpname(eatBarService.getCname(sxDayrepory.getCpcode()));
                }
                return baseApiService.setResultResultSuccess(dayreporyList);
            }else {
                List<TmpSxDayrepory> dayreporyList = eatBarService.selectDayrepory(ddate,cpcode);
                for (TmpSxDayrepory sxDayrepory : dayreporyList) {
                    sxDayrepory.setCpname(eatBarService.getCname(sxDayrepory.getCpcode()));
                }
                return baseApiService.setResultResultSuccess(dayreporyList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增或修改今日工作汇报
     * @param dayrepory
     * @return
     */
    @RequestMapping("/addDayrepory")
    public Object addDayrepory(@RequestBody DayreporyDto dayrepory){
        String result = "";
        String cpcode = dayrepory.getCpcode();
        String ctoday = dayrepory.getCtoday();
        String ctomrrow = dayrepory.getCtomrrow();
        String creport = dayrepory.getCreport();
        String creporter1 = dayrepory.getCreporter1();
        String creporter2 = dayrepory.getCreporter2();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ddate = sdf.format(date);
        try {
            List<TmpSxDayrepory> dayreporyList = eatBarService.selectDayreporyTwo(ddate,cpcode);
            if (dayreporyList.size()!=0){  //存在当日记录则进行修改
                int count = eatBarService.updateDayrepory(ctoday,ctomrrow,creport,creporter1,creporter2,cpcode,ddate);
                result = count>0?"保存成功":"保存失败";
            }else {  //不存在则进行新增
                int count = eatBarService.addDayrepory(cpcode,ctoday,ctomrrow,creport,creporter1,creporter2);
                result = count>0?"保存成功":"保存失败";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询所有主管及以上人员
     * @return
     */
    @RequestMapping("/selectCharge")
    public Object selectCharge(){
        try {
            List<SxCharges> sxChargesList = eatBarService.selectCharge();
            return baseApiService.setResultResultSuccess(sxChargesList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询上次汇报人的工号
     * @param dayreporyDto
     * @return
     */
    @RequestMapping("/selectCreporter")
    public Object selectCreporter(@RequestBody DayreporyDto dayreporyDto){
        String cpcode = dayreporyDto.getCpcode();
        try {
            String creporter1 = eatBarService.selectCreporter(cpcode);
            return baseApiService.setResultResultSuccess(creporter1);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据工号查询空瓶数量
     * @param empty
     * @return
     */
    @RequestMapping("/selectEmpty")
    public Object selectEmpty(@RequestBody Empty empty){
        String  cperson_id = empty.getCperson_id();
        try {
            List<Empty> emptyList = eatBarService.selectEmpty(cperson_id);
            return baseApiService.setResultResultSuccess(emptyList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询或新增范围点
     * @return
     */
    @RequestMapping("/getMapTmpList")
    public Object getMapTmpList(@RequestBody BirthdayDto birthdayDto){
        String jsonvist = birthdayDto.getJsonvist();
        String ctype = birthdayDto.getCtype();
        String param11 = birthdayDto.getParam1();
        String result = "";
        try {
            if (ctype.equals("01")){
                List<MapTmps> mapTmps = eatBarService.getMapTmp();
                return baseApiService.setResultResultSuccess(mapTmps);
            }else if (ctype.equals("02")){
                JSONArray jsonArray = JSONArray.fromObject(jsonvist);
                String param1 = String.valueOf(new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000);
                for (Object obj : jsonArray) {
                    JSONObject jsonObject = JSONObject.fromObject(obj);
                    String lat = jsonObject.get("lat").toString();
                    String lng = jsonObject.get("lng").toString();
                    int count = eatBarService.addMapTmp(lat,lng,param1);
                    result = count>0?"新增成功":"新增失败";
                }
                return baseApiService.setResultResultSuccess(result);
            }else {
                int count = eatBarService.deleteMapTmp(param11);
                result = count>0?"删除成功":"删除失败";
                return baseApiService.setResultResultSuccess(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增员工拜访（短时间内使用）
     * @return
     */
    @RequestMapping("/addStaffPayVisit")
    public Object addStaffPayVisit(@RequestBody ReqDto reqDto){
        String json = reqDto.getJsonvisit().replace("'","\"");
        String photos = reqDto.getPhotos().replace("'","\"");
        logger.info("进入新增员工拜访，参数为："+json);
        String cuserid = reqDto.getCuserid();   //工号
        String ccus_id = reqDto.getCcus_id();   //客户ID
        String [] strarry = new String[15];   //定义数值存储图片路径
        try {
            Upload_pictures upload_pictures = new Upload_pictures();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String[] date = df.format(new Date()).split("-");// new Date()为获取当前系统时间
            JSONArray jsonArray = JSONArray.fromObject(photos);
            JSONArray jsonArray1 = new JSONArray();  //定义新的JSONArray存储修改后的JSONObject
            int numer = 0;
            for (Object obj : jsonArray) {
                logger.info("进入到图片上传");
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
                result = eatBarService.addStaffPayVisit("["+jsonObject2.toString()+"]");  //调用方法
                logger.info("新增员工拜访（短时间内使用），参数为："+"["+jsonObject2.toString()+"]"+"\t返回的结果："+result);
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
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询员工拜访记录
     * @return
     */
    @RequestMapping("/getTempFllowVisit")
    public Object getTempFllowVisit(@RequestBody PromotionDto reqDto){
        String ccus_id = reqDto.getCcus_id(); //员工id或者员工姓名
        String ddate1 = reqDto.getDdate1();   //开始时间
        String ddate2 = reqDto.getDdate2();   //结束时间
        String ccompany_id = reqDto.getCcompany_id(); //公司
        String cfllow_cid = reqDto.getCfllow_cid();
        String cdefine1 = reqDto.getCdefine1();
        String cdefine2 = reqDto.getCdefine2();
        String cdefine3 = reqDto.getCdefine3();
        String cdefine4 = reqDto.getCdefine4();
        try {
            List<TempFllowVisit> fllowVisits = eatBarService.getTempFllowVisit(ccus_id,ddate1,ddate2,ccompany_id,cfllow_cid,cdefine1,cdefine2,cdefine3,cdefine4);
            for (TempFllowVisit visit : fllowVisits) {
                List<FllowImgDto> imgDtos = eatBarService.getFllowImg(visit.getAutoid());
                for (FllowImgDto imgDto : imgDtos) {
                    if (imgDto.getCimg_path()!=null&&!imgDto.getCimg_path().equals("")){
                        imgDto.setCimg_path("http://pic.hnsxtj.com/sxemall/"+imgDto.getCimg_path());
                    }
                }
                visit.setFllowImglist(imgDtos);
            }
            return baseApiService.setResultResultSuccess(fllowVisits);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询拜访统计
     * @return
     */
    @RequestMapping("/getFllowStatistics")
    public Object getFllowStatistics(){
        try {
            List<FllowStatis> fllowStatis = eatBarService.getFllowStatistics();
            return baseApiService.setResultResultSuccess(fllowStatis);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    @RequestMapping("/selectPersons")
    public Object selectPersons(){
        try {
            List<PersonNameDto> personNameDtoList = eatBarService.selectPersons();
            return baseApiService.setResultResultSuccess(personNameDtoList);
        }catch(Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }





}
