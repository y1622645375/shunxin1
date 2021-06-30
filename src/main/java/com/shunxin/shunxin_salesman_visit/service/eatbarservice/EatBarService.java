package com.shunxin.shunxin_salesman_visit.service.eatbarservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.*;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.*;

import java.util.List;

public interface EatBarService {


    //生日祝福弹幕
    List<BirthdayDto> getBirthdayList();


    //新增祝福弹幕
    int addBirthday( String greeting);


    //查询今日菜单
    List<EatMenus> selectMenusList(String me_dtime);


    //查询上一次报餐时间
    String getApDtime();


    //新增菜单
    int addMenus(String me_name);


    //修改菜单
    int updateMenus(String me_name, int me_id);


    //检测今日菜单是否已经录入
    int getMenusCount(String me_dtime);


    //新增允许吃饭人员名单
    int addStaff(String st_code,String st_name,String st_remark);


    //查询允许吃饭人员名单
    List<EatStaff> selectStaff(String st_code, String st_name);


    //新增人员时绑定微信Openid
    int insertWxBinds(String st_code);


    //新增今日报餐人员
    int addApply(String ap_code,String ap_type);


    //查询今日报餐人员
    List<EatApplyDto> selectApply(String ap_dtime);


    //查询历史菜名
    List<EatMenus> selectMenusName(String me_name);


    //检测今日是否已经报餐
    int getApplyInfo(String ap_code,String ap_dtime);

    //通过工号查询姓名
    String getCname(String ccode);


    //通过工号，公司，姓名查询业务员信息
    List<PersonNameDto> getPersons(String cname);


    //删除报餐人员
    int deleteStaff(int st_id);


    //根据st_id查询报餐人员工号
    String selectStcode(int st_id);


    //通过微信openid查询工号
    String getWxCode(String wx_openid);


    //查询每日报餐的人员
    List<EatApplyDto> getApplyCode(String ap_dtime);


    //修改报餐状态
    int updateAppleCode(String ap_type,String ap_code,String ap_dtime);


    //扫码绑定Openid
    int bandingWxOpen(String wx_code,String wx_openid);


    //查询是否绑定过Openid
    String selectWxCode(String wx_code);


    //查询今日所有员工的工作汇报
    List<TmpSxDayrepory> selectDayrepory(String ddate, String cpcode);


    //查询自己今日汇报
    List<TmpSxDayrepory> selectDayreporyTwo(String ddate, String cpcode);


    //新增今日工作汇报
    int addDayrepory(String cpcode,String ctoday,String ctomrrow,String creport,String creporter1,String creporter2);

    //删除工作汇报
    int deltDayrepory(int autoid);

    //修改工作汇报
    int updateDayrepory(String ctoday,String ctomrrow,String creport,String creporter1,String creporter2,String cpcode,String ddate);

    //查询所有主管及以上人员
    List<SxCharges> selectCharge();

    //查询上次汇报人的工号
    String selectCreporter(String cpcode);

    //根据工号查询空瓶数量
    List<Empty> selectEmpty( String cperson_id);

    //新增住址信息
    int addStaffTmp(String cname,String ccode,String xpoint,String ypoint,String cadress);


    //修改地址
    int updateStaffTmp(String xpoint,String ypoint,String cadress,String ccode);

    //查询员工住址信息
    List<staffTmpDto> getStaffTmp(String ccode);

    //查询店铺地址
    List<CustomerAddress> getLinsiAddress();


    //保存范围点
    int addMapTmp(String lat,String lng,String param1);

    //查询范围点
    List<MapTmps> getMapTmp();

    //删除范围点
    int deleteMapTmp(String param1);

    //新增员工拜访（短时间内使用）
    List<ResultDto> addStaffPayVisit(String jsonvist);

    //根据客户编号查询拜访次数
    int getStaffPayCount(String cfllow_cid,String cfllow_pid);

    //查询员工拜访记录
    List<TempFllowVisit> getTempFllowVisit(String cname,String ddate1,String ddate2,String ccompany_id,String cfllow_cid, String cdefine1, String cdefine2, String cdefine3, String cdefine4);

    //查询拜访图片
    List<FllowImgDto> getFllowImg(String fllowid);

    //查询拜访统计
    List<FllowStatis> getFllowStatistics();

    int getFllowCount(String cfllow_pid);

    List<PersonNameDto> selectPersons();
}
