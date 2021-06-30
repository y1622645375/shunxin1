package com.shunxin.shunxin_salesman_visit.controller.CheckController;


import com.shunxin.shunxin_salesman_visit.dto.checkdto.CheckDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.WorkCheckDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.WorkCheckGroupDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PersonNameDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.*;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.util.CallUrl;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/checkRecord")
public class CheckController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CheckService checkService;
    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private UserInfoUtil userInfoUtil;


    /**
     * @Title : 获取打卡记录
     * @Description : 获取某天的上班或下班打卡记录
     * @author : yyang
     * @date: 11:11 2021/2/22
     * @return
     */
    @RequestMapping("/getWorkCheckList")
    public Object getWorkCheckList(@RequestBody CheckDto checkDto){
        String jsonvist = checkDto.getJsonvist();
        try {
            JSONObject jsonObject = JSONObject.fromObject(jsonvist);
            String ctype = jsonObject.get("ctype").toString();
            if (ctype.equals("01")){
                List<CheckIng> checkIngs = checkService.getWorkCheckList(jsonObject.toString());
                logger.info("获取某天的上班或下班打卡记录");
                return baseApiService.setResultResultSuccess(checkIngs);
            }else if (ctype.equals("02")||ctype.equals("03")){
                List<Workcheck>  workcheckList = checkService.getWorkCheckNext(jsonvist);
                logger.info("查询正常、迟到、早退、缺卡等详细数据");
                return baseApiService.setResultResultSuccess(workcheckList);
            }else {
                return "服务器繁忙......";
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询消息组
     * @return
     */
    @RequestMapping("/getStaffWorkCheck")
    public Object getStaffWorkCheck(){
        try {
            List<WorkCheckGroupDto> workCheckGroupDtos = checkService.getStaffWorkCheck();
            return baseApiService.setResultResultSuccess(workCheckGroupDtos);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 更改排班
     * @return
     */
    @RequestMapping("/arrangeHaveHoliday")
    public Object arrangeHaveHoliday(@RequestBody CheckDto checkDto){
        String result = "";
        String cpersoncode = checkDto.getCpersoncode();  //需要更改的工号,可以为多个，但需要用英文的逗号隔开，例如：01227,01228
        String dstandtime = checkDto.getDstandtime();   //需要更改的日期,可以为多个日期，但需要用英文的逗号隔开，例如：2021-01-13,2021-01-14
        String schedule_id = checkDto.getSchedule_id(); //需要更改为的班次id (autoid)，可以为多个班次，但需要用英文的逗号隔开，例如：177,145
        String [] codearray = cpersoncode.substring(1,cpersoncode.length()-1).split(",");
        String [] dstanarray = dstandtime.substring(1,dstandtime.length()-1).split(",");
        String [] schedarray = schedule_id.substring(1,schedule_id.length()-1).split(",");
        try {
            for (int i = 0; i < codearray.length; i++) {
                for (int i1 = 0; i1 < dstanarray.length; i1++) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("ctype","01");
                    jsonObject.put("ccode",codearray[i]);
                    jsonObject.put("iclass",schedarray[i1]);
                    jsonObject.put("dstandtime",dstanarray[i1]+" 00:00:00");
                    List<ResultDto> resultDtos = checkService.changeWorkClass(jsonObject.toString());
                    for (ResultDto dto : resultDtos) {
                        result = dto.getResult();
                    }
                }
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    //每天0点过后从Log表读取数据，更改企业微信端的排班
    //@RequestMapping("/changeCheckClass")
    public String changeCheckClass(){
        String result = "";
        String tokenDaka = userInfoUtil.getQywxTokenDaka();
        String [] codearray = new String[800];    //存工号的数组
        String [] dstanarray = new String[100];   //存日期的数组
        String [] schedarray = new String[100];   //存班次的数组
        try {
            List<WorkcheckLog> workcheckLogList = checkService.getWorkCheckLog();
            int i = 0;
            for (WorkcheckLog log : workcheckLogList) {
                codearray[i] = log.getCcode();
                i++;
            }
            for (int i1 = 0; i1 < codearray.length; i1++) {
                if (codearray[i1]!=null){
                    List<CheckDto> checkDtos = checkService.getCheckDtoList(codearray[i1]);
                    int i2 = 0;
                    for (CheckDto dto : checkDtos) {
                        dstanarray[i2] = dto.getDstandtime();
                        schedarray[i2] = dto.getCworkclasscode();
                        i2++;
                    }
                }
            }
            for (int i1 = 0; i1 < codearray.length; i1++) {
                for (int i2 = 0; i2 < dstanarray.length; i2++) {
                    if (codearray[i1]!=null){
                        if (dstanarray[i2]!=null){
                            String [] items = new String[1];
                            JSONObject object = new JSONObject();
                            object.put("userid",codearray[i1]);
                            object.put("day",dstanarray[i2].substring(6,dstanarray[i2].length()));
                            object.put("schedule_id",schedarray[i2]);
                            items[0] = object.toString();
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("groupid","4");  //打卡规则的规则id
                            jsonObject.put("items",items);
                            jsonObject.put("yearmonth",dstanarray[i2].substring(0,6));
                            result = CallUrl.sendPost("https://qyapi.weixin.qq.com/cgi-bin/checkin/setcheckinschedulist?access_token="+tokenDaka,jsonObject.toString());
                            JSONObject jsonObject1 = JSONObject.fromObject(result);
                            String errmsg = jsonObject1.get("errmsg").toString();
                            System.out.println("执行结果："+errmsg);
                            if (errmsg.equals("ok")){
                                result = "执行成功";
                            }else {
                                result = "执行失败";
                            }
                            if (result.equals("执行成功")){
                                checkService.updateWorkCheckLog(codearray[i1],errmsg);
                            }
                        }
                    }
                }
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }


    /**
     * 更改企业微信端的排班
     * @param checkDto
     * @return
     */
    @PostMapping("/updateWoekWxCheckClass")
    public Object updateWoekWxCheckClass(@RequestBody CheckDto checkDto){
        String cpersoncode = checkDto.getCpersoncode();
        String result = "";
        try {
            String tokenDaka = userInfoUtil.getQywxTokenDaka();
            //通过工号查询今日以后的排班信息
            List<CheckDto> checkDtos = checkService.getCheckDtoList(cpersoncode);
            List<Object> arrays = new ArrayList<>();
            String yearmonth = "";
            for (CheckDto dto : checkDtos) {
                JSONObject object = new JSONObject();
                object.put("userid",cpersoncode);
                object.put("day",dto.getDstandtime().substring(6,dto.getDstandtime().length()));
                object.put("schedule_id",dto.getCworkclasscode());
                arrays.add(object.toString());
                yearmonth = dto.getDstandtime().substring(0,6);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("groupid","4");  //打卡规则的规则id
            jsonObject.put("items",arrays);
            jsonObject.put("yearmonth",yearmonth);
            result = CallUrl.sendPost("https://qyapi.weixin.qq.com/cgi-bin/checkin/setcheckinschedulist?access_token="+tokenDaka,jsonObject.toString());
            JSONObject jsonObject1 = JSONObject.fromObject(result);
            String errmsg = jsonObject1.get("errmsg").toString();
            checkService.updateWorkCheckLog(cpersoncode,errmsg);
            if (errmsg.equals("ok")){
                result = "执行成功";
            }else {
                result = "执行失败";
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }



    /**
     * 获取所有的班次
     * @return
     */
    @RequestMapping("/getWorkCheckClass")
    public Object getWorkCheckClass(){
        try {
            List<WorkCheckClass> workCheckClassList = checkService.getWorkCheckClass();
            logger.info("获取所有的班次");
            return baseApiService.setResultResultSuccess(workCheckClassList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 获取所有的员工姓名和工号
     * @param checkDto
     * @return
     */
    @RequestMapping("/selectPersonNameList")
    public Object selectPersonNameList(@RequestBody CheckDto checkDto){
        String cname = checkDto.getCname();
        try {
            List<PersonNameDto> personNameDtoList = checkService.selectPersonNameList(cname);
            logger.info("获取所有的员工姓名和工号");
            return baseApiService.setResultResultSuccess(personNameDtoList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 获取所有考勤数据
     * @return
     */
    @RequestMapping("/selectWorkCheckV")
    public Object selectWorkCheckV(@RequestBody WorkCheckDto workCheckDto){
        String cname = workCheckDto.getCname();
        String ccomcode = workCheckDto.getCcomcode();
        String cdepcode = workCheckDto.getCdepcode();
        String ddate1 = workCheckDto.getDdate1();
        String ddate2 = workCheckDto.getDdate2();
        String cusercode = workCheckDto.getCusercode();  //查询者工号
        try {
            int count = checkService.getUserHold(cusercode);
            if (count>0){
                List<WorkCheckList> workCheckLists = checkService.selectWorkCheckV(ccomcode,cdepcode,cname,ddate1,ddate2);
                return baseApiService.setResultResultSuccess(workCheckLists);
            }else {
                return baseApiService.setResultError("服务器繁忙...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 新增关注或者取消关注
     * @return
     */
    @RequestMapping("/concernCharity")
    public Object concernCharity(@RequestBody WorkCheckGroupDto groupDto){
        String result ="";
        String cgroupcode = groupDto.getCgroupcode();
        String cpcode = groupDto.getCpcode();
        String ctype = groupDto.getCtype();
        try {
            if (ctype.equals("01")){  //新增关注
                int count = checkService.addWorkCheckGroup(cgroupcode,"G"+cgroupcode,cpcode);
                if (count>0){
                    result = "操作成功";
                }
            }else if(ctype.equals("02")){ //取消关注
                int count = checkService.deleteWorkCheckGroup(cpcode,cgroupcode);
                if (count>0){
                    result = "操作成功";
                }
            }
            return baseApiService.setResultResultSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询月统计表
     * @return
     */
    @RequestMapping("/getStaffWorkcheckDay")
    public Object getStaffWorkcheckDay(@RequestBody WorkCheckMonSta checkMonSta){
        String cpersoncode = checkMonSta.getCpersoncode();  //工号或姓名
        String iperiod = checkMonSta.getIperiod();      //年月 202101
        String ccomcode = checkMonSta.getCcomcode();    //公司编号
        String cdepcode = checkMonSta.getCdepcode();    //部门编号
        String cuserid = checkMonSta.getCuserid();      //查询者工号
        String czjcode = checkMonSta.getCzjcode();
        try {
            List<WorkCheckMonSta> workCheckMonStaList = checkService.getStaffWorkcheckDay(cuserid,cpersoncode,iperiod,ccomcode,cdepcode,czjcode);
            return baseApiService.setResultResultSuccess(workCheckMonStaList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    //每月考勤统计
    //@RequestMapping("/getWorkcheckRecordList")
    public Object getWorkcheckRecordList(){
        try {
            List<WorkcheckRecord> workcheckRecordList = checkService.getWorkcheckRecordList();
            for (WorkcheckRecord record : workcheckRecordList) {
                String ccode = record.getCcode();
                String cname = record.getCname();
                int ydk_day = record.getYdk_day();
                int sdk_day = record.getSdk_day();
                int qk_day = record.getQk_day();
                int cd_count = record.getCd_count();
                int zt_count = record.getZt_count();
                CallUrl.sendPost("http://emall.hnsxtj.com/sendmsg.php?userid="+ccode+"&cpocode=123456&" +
                        "logs="+cname+"您好，您本月考勤记录请查收：应考勤天数："+ydk_day+"天，实打卡天数："+sdk_day+"天，" +
                        "缺勤次数："+qk_day+"次，迟到次数："+cd_count+"次，早退次数："+zt_count+"次&ctype=free","");
            }
            return baseApiService.setResultResultSuccess("执行成功");
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }




}
