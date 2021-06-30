package com.shunxin.shunxin_salesman_visit.service.checkservice;

import com.shunxin.shunxin_salesman_visit.dto.checkdto.CcomcodeDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.CheckDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.WorkCheckGroupDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PersonNameDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.*;

import java.util.List;

public interface CheckService {


    //获取企业微信端打卡记录到本地
    int addCheckin( String cpersoncode,String cworkrule, String cworktype, String dstandtime, String dchecktime, String clocation_title, String clocation_detail,
                    String cworkdevice, String cnotes, Double lat, Double lng, String ccheckimg,String dchecktype);


    //获取企业微信端打卡记录到本地(新接口)
    List<ResultDto> updateCheckin(String jsonvist);


    //效验key是否正确
    String charmKeyValidity(String cuserid,String ckey,int ilogin_type);


    //获取所有人的工号
    List<CcomcodeDto> getPersonCcomcode();


    //根据工号写入当天的打卡规则
    int updateDstandTime(int dstandtime,String cworkrule);


    //获取打卡规则的种类
    List<CcomcodeDto> getCworkrule();


    //List<CheckIng> getPunchRecord(String ddate1,String ddate2,String cpersoncode,String cworktype,String cworkrule,String clocation_title,String dchecktype,String ccomcode);


    //更新打卡规则数据
    int addWorkCheckRule(String cpersoncode,String cworkrule,int dstandtime,String ctype);

    //获取当天的上班打卡记录
    List<CheckIng> getWorkCheckList(String jsonvist);


    //获取考勤统计
    List<Workcheck> getWorkCheckNext(String jsonvist);



    //查询消息组
    List<WorkCheckGroupDto> getStaffWorkCheck();


    //获取所有的班次
    List<WorkCheckClass> getWorkCheckClass();


    //获取所有的员工姓名和工号
    List<PersonNameDto> selectPersonNameList(String cname);


    //获取下一轮需要排班的工号
    List<Workcheck> selectCpersonCodeList();


    //根据工号查询下一轮的排班班次ID
    List<CheckIng> selectWorkCheeckClassId(String cpersoncode);


    //将考勤调动写入日志表
    int addWorkCheckLog(String ccode,String cstate);


    //查询修改日志
    List<WorkcheckLog> getWorkCheckLog();


    //修改完成回写日志表
    int updateWorkCheckLog(String ccode, String cstate);


    //补全每日未打卡人的数据
    int updateStaffWorkcheck(String cworktype,String iwctype,long starttime);


    //更改考勤班次
    List<ResultDto> changeWorkClass(String jsonvist);


    //通过工号查询今日以后的排班信息
    List<CheckDto> getCheckDtoList(String cpersoncode);


    //获取所有考勤数据
    List<WorkCheckList> selectWorkCheckV(String ccomcode, String cdepcode, String cname,String ddate1,String ddate2);


    //考勤数据只允许人事查询
    int getUserHold(String cusercode);


    //新增关注
    int addWorkCheckGroup(String cgroupcode,String cgroupname,String cpcode);


    //取消关注
    int deleteWorkCheckGroup(String cpcode,String cgroupcode);


    //查询月统计表
    List<WorkCheckMonSta> getStaffWorkcheckDay(String cuserid,String cpersoncode,String iperiod,String ccomcode,String cdepcode,String czjcode);


    //每月考勤统计
    List<WorkcheckRecord> getWorkcheckRecordList();

}
