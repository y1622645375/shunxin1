package com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.*;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EatBarMapper {


    //查询今日菜单
    List<EatMenus> selectMenusList(@Param("me_dtime") String me_dtime);


    //查询上一次报餐时间
    String getApDtime();


    //新增今日菜单
    int addMenus(@Param("me_name") String me_name);


    //修改菜单
    int updateMenus(@Param("me_name") String me_name,@Param("me_id") int me_id);


    //检测今日菜单是否已经录入
    int getMenusCount(@Param("me_dtime") String me_dtime);


    //新增允许吃饭人员名单
    int addStaff(@Param("st_code") String st_code,@Param("st_name") String st_name,@Param("st_remark") String st_remark);


    //查询允许吃饭人员名单
    List<EatStaff> selectStaff(@Param("st_code") String st_code,@Param("st_name") String st_name);


    //新增人员时绑定微信Openid
    int insertWxBinds(@Param("st_code") String st_code);


    //新增今日报餐人员
    int addApply(@Param("ap_code") String ap_code,@Param("ap_type") String ap_type);


    //查询今日报餐人员
    List<EatApplyDto> selectApply(@Param("ap_dtime") String ap_dtime);


    //查询历史菜名
    List<EatMenus> selectMenusName(@Param("me_name") String me_name);


    //检测今日是否已经报餐
    int getApplyInfo(@Param("ap_code") String ap_code,@Param("ap_dtime") String ap_dtime);


    //通过工号查询姓名
    String getCname(@Param("ccode") String ccode);


    //通过工号，公司，姓名查询业务员信息
    List<PersonNameDto> getPersons(@Param("cname") String cname);


    //删除报餐人员
    int deleteStaff(@Param("st_id") int st_id);


    //根据st_id查询报餐人员工号
    String selectStcode(@Param("st_id") int st_id);


    //通过微信openid查询工号
    String getWxCode(@Param("wx_openid") String wx_openid);


    //查询每日报餐的人员
    List<EatApplyDto> getApplyCode(@Param("ap_dtime") String ap_dtime);


    //修改报餐状态
    int updateAppleCode(@Param("ap_type") String ap_type,@Param("ap_code") String ap_code,@Param("ap_dtime") String ap_dtime);


    //扫码绑定Openid
    int bandingWxOpen(@Param("wx_code") String wx_code,@Param("wx_openid") String wx_openid);


    //查询是否绑定过Openid
    String selectWxCode(@Param("wx_code") String wx_code);


    //查询今日所有员工的工作汇报
    List<TmpSxDayrepory> selectDayrepory(@Param("ddate") String ddate,@Param("cpcode") String cpcode);


    //查询自己今日汇报
    List<TmpSxDayrepory> selectDayreporyTwo(@Param("ddate") String ddate,@Param("cpcode") String cpcode);


    //新增今日工作汇报
    int addDayrepory(@Param("cpcode") String cpcode,@Param("ctoday") String ctoday,
                     @Param("ctomrrow") String ctomrrow,@Param("creport") String creport,
                     @Param("creporter1") String creporter1,@Param("creporter2") String creporter2);


    //删除工作汇报
    int deltDayrepory(@Param("autoid") int autoid);


    //修改工作汇报
    int updateDayrepory(@Param("ctoday") String ctoday,@Param("ctomrrow") String ctomrrow,@Param("creport") String creport,
                        @Param("creporter1") String creporter1,@Param("creporter2") String creporter2,@Param("cpcode") String cpcode,@Param("ddate") String ddate);

    //查询所有主管及以上人员
    List<SxCharges> selectCharge();

    //查询上次汇报人的工号
    String selectCreporter(@Param("cpcode") String cpcode);


    //根据工号查询空瓶数量
    List<Empty> selectEmpty(@Param("cperson_id") String cperson_id);


    //生日祝福弹幕
    List<BirthdayDto> getBirthdayList();


    //新增祝福弹幕
    int addBirthday(@Param("greeting") String greeting);


    //新增住址信息
    int addStaffTmp(@Param("cname") String cname,@Param("ccode") String ccode,@Param("xpoint") String xpoint,@Param("ypoint") String ypoint,@Param("cadress") String cadress);


    //修改地址
    int updateStaffTmp(@Param("xpoint") String xpoint,@Param("ypoint") String ypoint,@Param("cadress") String cadress,@Param("ccode") String ccode);


    //查询员工住址信息
    List<staffTmpDto> getStaffTmp(@Param("ccode") String ccode);

    //查询店铺地址
    List<CustomerAddress> getLinsiAddress();

    //保存范围点
    int addMapTmp(@Param("lat") String lat,@Param("lng") String lng,@Param("param1") String param1);

    //查询范围点
    List<MapTmps> getMapTmp();

    //删除范围点
    int deleteMapTmp(@Param("param1") String param1);


    //新增员工拜访（短时间内使用）
    List<ResultDto> addStaffPayVisit(String jsonvist);


    //根据客户编号查询拜访次数
    int getStaffPayCount(@Param("cfllow_cid") String cfllow_cid,@Param("cfllow_pid") String cfllow_pid);

    //查询员工拜访记录
    List<TempFllowVisit> getTempFllowVisit(@Param("cname") String cname,@Param("ddate1") String ddate1,@Param("ddate2") String ddate2,@Param("ccompany_id") String ccompany_id,
                                           @Param("cfllow_cid") String cfllow_cid,@Param("cdefine1") String cdefine1,@Param("cdefine2") String cdefine2,
                                           @Param("cdefine3") String cdefine3,@Param("cdefine4") String cdefine4);

    //查询拜访图片
    List<FllowImgDto> getFllowImg(@Param("fllowid") String fllowid);


    //查询拜访统计
    List<FllowStatis> getFllowStatistics();


    int getFllowCount(@Param("cfllow_pid") String cfllow_pid);


    List<PersonNameDto> selectPersons();

}
