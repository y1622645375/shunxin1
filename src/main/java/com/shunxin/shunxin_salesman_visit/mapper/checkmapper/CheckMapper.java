package com.shunxin.shunxin_salesman_visit.mapper.checkmapper;


import com.shunxin.shunxin_salesman_visit.dto.checkdto.CcomcodeDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.CheckDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.WorkCheckGroupDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PersonNameDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CheckMapper {

    //获取企业微信端打卡记录到本地
    int addCheckin(@Param("cpersoncode") String cpersoncode,@Param("cworkrule") String cworkrule, @Param("cworktype") String cworktype, @Param("dstandtime") String dstandtime, @Param("dchecktime") String dchecktime,
                   @Param("clocation_title") String clocation_title, @Param("clocation_detail") String clocation_detail, @Param("cworkdevice") String cworkdevice,
                   @Param("cnotes") String cnotes, @Param("lat") Double lat, @Param("lng") Double lng, @Param("ccheckimg") String ccheckimg,@Param("dchecktype") String dchecktype);


    //获取企业微信端打卡记录到本地(新接口)
    List<ResultDto> updateCheckin(@Param("jsonvist") String jsonvist);


    //补全每日未打卡人的数据
    int updateStaffWorkcheck(@Param("cworktype") String cworktype,@Param("iwctype") String iwctype,@Param("starttime") long starttime);


    //效验key是否正确
    String charmKeyValidity(@Param("cuserid") String cuserid,@Param("ckey") String ckey,@Param("ilogin_type") int ilogin_type);


    //获取所有人的工号
    List<CcomcodeDto> getPersonCcomcode();


    //根据工号写入当天的打卡规则
    int updateDstandTime(@Param("dstandtime") int dstandtime,@Param("cworkrule") String cworkrule);


    //获取打卡规则的种类
    List<CcomcodeDto> getCworkrule();



    /*List<CheckIng> getPunchRecord(@Param("ddate1") String ddate1,@Param("ddate2") String ddate2,@Param("cpersoncode") String cpersoncode,
                                  @Param("cworktype") String cworktype,@Param("cworkrule") String cworkrule,@Param("clocation_title") String clocation_title,
                                  @Param("dchecktype") String dchecktype,@Param("ccomcode") String ccomcode);*/


    //更新打卡规则数据
    int addWorkCheckRule(@Param("cpersoncode") String cpersoncode,@Param("cworkrule") String cworkrule,@Param("dstandtime") int dstandtime,@Param("ctype") String ctype);


    //获取某天的上班 或 下班打卡记录
    List<CheckIng> getWorkCheckList(@Param("jsonvist") String jsonvist);


    //获取考勤统计
    List<Workcheck> getWorkCheckNext(@Param("jsonvist") String jsonvist);


    //查询消息组
    List<WorkCheckGroupDto> getStaffWorkCheck();


    //获取所有的班次
    List<WorkCheckClass> getWorkCheckClass();


    //获取所有的员工姓名和工号
    List<PersonNameDto> selectPersonNameList(@Param("cname") String cname);


    //获取下一轮需要排班的工号
    List<Workcheck> selectCpersonCodeList();


    //根据工号查询下一轮的排班班次ID
    List<CheckIng> selectWorkCheeckClassId(@Param("cpersoncode") String cpersoncode);


    //将考勤调动写入日志表
    int addWorkCheckLog(@Param("ccode") String ccode,@Param("cstate") String cstate);


    //查询修改日志
    List<WorkcheckLog> getWorkCheckLog();


    //修改完成回写日志表
    int updateWorkCheckLog(@Param("ccode") String ccode,@Param("cstate") String cstate);


    //更改考勤班次
    List<ResultDto> changeWorkClass(@Param("jsonvist") String jsonvist);


    //通过工号查询今日以后的排班信息
    List<CheckDto> getCheckDtoList(@Param("cpersoncode") String cpersoncode);


    //获取所有考勤数据
    List<WorkCheckList> selectWorkCheckV(@Param("ccomcode") String ccomcode,@Param("cdepcode") String cdepcode,@Param("cname") String cname,
                                         @Param("ddate1") String ddate1,@Param("ddate2") String ddate2);


    //考勤数据只允许人事查询
    int getUserHold(@Param("cusercode") String cusercode);


    //新增关注
    int addWorkCheckGroup(@Param("cgroupcode") String cgroupcode,@Param("cgroupname") String cgroupname,@Param("cpcode") String cpcode);


    //取消关注
    int deleteWorkCheckGroup(@Param("cpcode") String cpcode,@Param("cgroupcode") String cgroupcode);


    //查询月统计表
    List<WorkCheckMonSta> getStaffWorkcheckDay(@Param("cuserid") String cuserid,@Param("cpersoncode") String cpersoncode,@Param("iperiod") String iperiod,@Param("ccomcode") String ccomcode,
                                               @Param("cdepcode") String cdepcode,@Param("czjcode") String czjcode);


    //每月考勤统计
    List<WorkcheckRecord> getWorkcheckRecordList();

}