package com.shunxin.shunxin_salesman_visit.controller.CheckController;

import com.shunxin.shunxin_salesman_visit.dto.checkdto.CcomcodeDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.CheckIng;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.Workcheck;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.distributor.Distr_OrderService;
import com.shunxin.shunxin_salesman_visit.util.CallUrl;
import com.shunxin.shunxin_salesman_visit.util.DateUtils;
import com.shunxin.shunxin_salesman_visit.util.UserInfoUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 从微信端提取数据
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/punch")
public class PunchController {

    @Autowired
    private UserInfoUtil userInfoUtil;
   /* @Autowired
    private DateUtils datetimes;*/
    @Autowired
    private CheckService checkService;
    @Autowired
    private Distr_OrderService distrOrderService;


    /**
     * 从云端获取数据并存入A表  ctype  //BeOnDuty 上班，OffDuty 下班
     * @return
     */
    public Object getCheckinData(String opencheckindatatype,long starttime,long endtime,String ctype){
        String result = "";
        try {
            String tokenDaka = userInfoUtil.getQywxTokenDaka();
            String CheckinUrl = "https://qyapi.weixin.qq.com/cgi-bin/checkin/getcheckindata?access_token="+tokenDaka;
            String [] useridlist = new String[95];
            List<CcomcodeDto> ccomcodeDto = checkService.getPersonCcomcode();
            int i = 0;
            for (CcomcodeDto dto : ccomcodeDto) {
                if (i==90){
                    getcheckindata(opencheckindatatype,starttime,endtime,useridlist,CheckinUrl,ctype);
                    useridlist = new String[95];
                    i = 0;
                }
                useridlist[i] = dto.getCcode();  //将工号全部赋值给数组
                i++;
            }
            getcheckindata(opencheckindatatype,starttime,endtime,useridlist,CheckinUrl,ctype);
            //将未打卡人员的信息补全，不让数据出现NULL值
            if (ctype.equals("BeOnDuty")){  //上班
                checkService.updateStaffWorkcheck("1","1",starttime);
            }else if (ctype.equals("OffDuty")){ //下班
                checkService.updateStaffWorkcheck("2","2",starttime);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }



    //获取打卡数据
    private String getcheckindata(String t1,long t2,long t3,String [] t4,String t5,String t6) throws Exception{
        String result = "";
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("opencheckindatatype",t1);
        jsonObject2.put("starttime",t2);
        jsonObject2.put("endtime",t3);
        jsonObject2.put("useridlist",t4);
        String checkinfo = CallUrl.post(t5,jsonObject2.toString());
        JSONObject jsonObject = JSONObject.fromObject(checkinfo);
        String checkindata = jsonObject.get("checkindata").toString();
        JSONArray jsonArray = JSONArray.fromObject(checkindata);
        for (Object obj : jsonArray) {
                JSONObject job = JSONObject.fromObject(obj.toString());
                String checkin_type = job.get("checkin_type").toString();  //上班下班打卡
                String userid = job.get("userid").toString();   //工号
                String cworktype = "";
                if (checkin_type.equals("上班打卡")){
                    cworktype = "1";
                }else if (checkin_type.equals("下班打卡")){
                    cworktype = "2";
                }else if (checkin_type.equals("外出打卡")){
                    cworktype = "3";
                }
                /*long current=System.currentTimeMillis();//当前时间毫秒数
                long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
                long datetimes =zero/1000;*/
                String stamp = DateUtils.stampToDate(t2);  //将时间戳转换为时间
                String str = stamp.substring(0,10)+" 00:00:00";
                String as = DateUtils.dateToStamp(str);
                long datetimes = Long.parseLong(as);    //获取传入日期当天零点零分零秒的时间戳
                String checkin_time = String.valueOf(datetimes);
                if (job.get("checkin_time")!=null){
                    checkin_time = job.get("checkin_time").toString();  //打卡时间戳
                }
                //String groupname = job.get("groupname").toString();     //打卡规则名称
                String location_title = job.get("location_title").toString();   //打卡地点title
                String location_detail = job.get("location_detail").toString();   //打卡地点详情
                Double lat = Double.parseDouble(job.get("lat").toString())/1000000;   //纬度
                Double lng = Double.parseDouble(job.get("lng").toString())/1000000;   //经度
                String deviceid = job.get("deviceid").toString();  //打卡设备ID
                String notes = job.get("notes").toString();  //打卡备注
                String dstandtime = String.valueOf(datetimes);
                if (job.get("sch_checkin_time")!=null){
                    dstandtime = job.get("sch_checkin_time").toString();   //标准时间（应该打卡的时间）
                }
                String dchecktype = "";    //考勤状态
                int dchecktime = Integer.parseInt(checkin_time);   //打卡时间
                int dstandtimes = Integer.parseInt(dstandtime);    //应打卡时间
                if (cworktype.equals("1")){  //上班卡
                    if (dchecktime<=dstandtimes){
                        dchecktype = "正常";
                    }else {
                        dchecktype = "迟到";
                    }
                }else if (cworktype.equals("2")){ //下班卡
                    if (dchecktime<dstandtimes){
                        dchecktype = "早退";
                    }else {
                        dchecktype = "正常";
                    }
                }else if (cworktype.equals("3")){ //外出卡
                    if (t6.equals("BeOnDuty")){  //外出打上班卡
                        if (dchecktime<=dstandtimes){
                            dchecktype = "正常";
                        }else {
                            dchecktype = "迟到";
                        }
                    }else if (t6.equals("OffDuty")){ //外出打下班卡
                        if (dchecktime<dstandtimes){
                            dchecktype = "早退";
                        }else {
                            dchecktype = "正常";
                        }
                    }
                }
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("ctype","04");
                jsonObject1.put("cpersoncode",userid);
                jsonObject1.put("cworktype",cworktype);
                jsonObject1.put("clocation_title",location_title);
                jsonObject1.put("clocation_detail",location_detail);
                jsonObject1.put("cworkdevice",deviceid);
                jsonObject1.put("cnotes",notes);
                jsonObject1.put("lat",lat);
                jsonObject1.put("lng",lng);
                if (t6.equals("BeOnDuty")){  //获取上班数据
                    if (checkin_type.equals("上班打卡")){
                        if (job.get("exception_type").toString().equals("未打卡")){
                            SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String checkin_time2 = sdf.format(new Date(Long.parseLong(String.valueOf(t2))*1000L));
                            //先通过时间戳获取当天的日期，再通过日期获取当天0点的时间戳
                            long time2 = getStartOfToday(checkin_time2);
                            jsonObject1.put("dchecktime",time2);
                            jsonObject1.put("dchecktype","缺卡");
                            checkService.updateCheckin(jsonObject1.toString());
                        }else {
                            jsonObject1.put("dchecktime",checkin_time);
                            jsonObject1.put("dchecktype",dchecktype);
                            checkService.updateCheckin(jsonObject1.toString());
                        }
                        result = "执行成功";
                    }else if (checkin_type.equals("外出打卡")){
                        jsonObject1.put("dchecktime",checkin_time);
                        jsonObject1.put("dchecktype",dchecktype);
                        jsonObject1.put("dstandtime",dstandtimes);
                        checkService.updateCheckin(jsonObject1.toString());
                        result = "执行成功";
                    }
                }else if (t6.equals("OffDuty")){  //获取下班数据
                    if (checkin_type.equals("下班打卡")){
                        if (job.get("exception_type").toString().equals("未打卡")){
                            SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String checkin_time2 = sdf.format(new Date(Long.parseLong(String.valueOf(t2))*1000L));
                            //先通过时间戳获取当天的日期，再通过日期获取当天0点的时间戳
                            long time2 = getStartOfToday(checkin_time2);
                            jsonObject1.put("dchecktime",time2);
                            jsonObject1.put("dchecktype","缺卡");
                            checkService.updateCheckin(jsonObject1.toString());
                        }else {
                            jsonObject1.put("dchecktime",checkin_time);
                            jsonObject1.put("dchecktype",dchecktype);
                            checkService.updateCheckin(jsonObject1.toString());
                        }
                        result = "执行成功";
                    }else if (checkin_type.equals("外出打卡")){
                        jsonObject1.put("dchecktime",checkin_time);
                        jsonObject1.put("dchecktype",dchecktype);
                        jsonObject1.put("dstandtime",dstandtimes);
                        checkService.updateCheckin(jsonObject1.toString());
                        result = "执行成功";
                    }
               }
        }
        return result;
    }


    public static Long getStartOfToday(String date) {
        if (StringUtils.isEmpty(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.format(date);
        }
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
        LocalDate parse = LocalDate.parse(date, ofPattern);
        return parse.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli()/1000;
    }



    /**
     * 更新打卡规则数据表
     * @return
     */
    @RequestMapping("/getWorkcheckRule")
    public Object getWorkcheckRule(){
        try {
            String tokenDaka = userInfoUtil.getQywxTokenDaka();
            String getcheckUrl = "https://qyapi.weixin.qq.com/cgi-bin/checkin/getcheckinoption?access_token="+tokenDaka;
            String [] useridlist = new String[800];
            List<CcomcodeDto> ccomcodeDto = checkService.getPersonCcomcode();
            String ctype = "OffDuty";
            int i = 0;
            for (CcomcodeDto dto : ccomcodeDto) {
                useridlist[i] = dto.getCcode();  //将工号全部赋值给数组
                updateWorkcheckRule(useridlist,getcheckUrl,ctype);
                useridlist = new String[800];
                i++;
            }
            return "执行成功";
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }



    //更新打卡规则数据表
    private String updateWorkcheckRule(String [] t1,String t2,String t3){
        String result = "";
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long datetime =zero/1000;
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("datetime",datetime);
        jsonObject3.put("useridlist",t1);
        String checkinfo2 = CallUrl.post(t2,jsonObject3.toString());  //调用微信接口，获取打卡规则
        JSONObject fromObject = JSONObject.fromObject(checkinfo2);
        String info = fromObject.get("info").toString();
        JSONArray jsonArray2 = JSONArray.fromObject(info);
        for (Object obje : jsonArray2) {
            JSONObject job = JSONObject.fromObject(obje.toString());
            String userid = job.get("userid").toString();   //工号
            String group = job.get("group").toString();
            JSONObject jsonObject1 = JSONObject.fromObject(group);
            String checkindate = jsonObject1.get("checkindate").toString();
            JSONArray jsonArray3 = JSONArray.fromObject(checkindate);
            for (Object o : jsonArray3) {
                JSONObject jo = JSONObject.fromObject(o.toString());
                String workdays = jo.get("workdays").toString();
                //获取当前日期为周几
                Date today = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                int weekday = c.get(Calendar.DAY_OF_WEEK)-1;  //0为周天，其余按顺序周一至周六
                String weekstr = String.valueOf(weekday);
                if (workdays.contains(weekstr)){
                    String checkintime = jo.get("checkintime").toString();
                    String sub = checkintime.substring(1,checkintime.length()-1);
                    JSONObject object = JSONObject.fromObject(sub);
                    String groupname = jsonObject1.get("groupname").toString();   //打卡规则名称
                    if (t3.equals("BeOnDuty")){   //获取上班打卡规则
                        String work_sec = object.get("work_sec").toString();  //上班打卡时间戳
                        int work_int = Integer.parseInt(work_sec);
                        checkService.addWorkCheckRule(userid,groupname,work_int,"01");
                    }else if (t3.equals("OffDuty")){   //获取下班打卡规则
                        String off_work_sec = object.get("off_work_sec").toString();  //下班打卡时间戳
                        int work_int = Integer.parseInt(off_work_sec);
                        checkService.addWorkCheckRule(userid,groupname,work_int,"02");
                    }
                    result = "执行完成";
                }
            }
        }
        return result;
    }



    /**
     * 每天00:30将未配送完成的订单重新划至新订单
     * @return
     */
    public String clearUpOrder(){
        String result = "";
        try {
            int count = distrOrderService.clearUpOrder();
            result = count>0?"操作成功":"操作失败";
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }


    /**
     * 为打卡规则为“按班次上下班”规则的指定员工排班
     * @return
     */
    @RequestMapping("/setCheckInscheDulist")
    public String setCheckInscheDulist(){
        String result = "";
        String tokenDaka = userInfoUtil.getQywxTokenDaka();
        try {
            List<Workcheck> workcheckList = checkService.selectCpersonCodeList();
            for (Workcheck dto : workcheckList) {
                String [] str = new String[31];  //用于储存下一个月的排班班次ID
                List<CheckIng> checkIngList = checkService.selectWorkCheeckClassId(dto.getCpersoncode());
                int i1 = 0;
                for (CheckIng checkIng : checkIngList) {
                    //将下一个月的排班班次ID值赋给数组
                    str[i1] = checkIng.getIclass();
                    i1++;
                }
                for (int i = 0; i < i1; i++) {  //循环排班
                    Calendar calendar2 = Calendar.getInstance();
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
                    calendar2.add(Calendar.DATE, i+1);
                    String three_days_after = sdf2.format(calendar2.getTime());
                    String yeerMoth = three_days_after.substring(0,6);   //年月
                    String days = three_days_after.substring(6,three_days_after.length());  //日
                    String [] items = new String[1];
                    JSONObject object = new JSONObject();
                    object.put("userid",dto.getCpersoncode());
                    object.put("day",days);
                    object.put("schedule_id",str[i]);
                    items[0] = object.toString();
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("groupid","4");  //打卡规则的规则id
                    jsonObject.put("items",items);
                    jsonObject.put("yearmonth",yeerMoth);
                    result = CallUrl.sendPost("https://qyapi.weixin.qq.com/cgi-bin/checkin/setcheckinschedulist?access_token="+tokenDaka,jsonObject.toString());
                    JSONObject jsonObject1 = JSONObject.fromObject(result);
                    String errmsg = jsonObject1.get("errmsg").toString();
                    //System.out.println("结果："+errmsg);
                    if (errmsg.equals("ok")){
                        System.out.println("执行成功");
                    }
                }
            }
            return "执行成功";
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }




}
