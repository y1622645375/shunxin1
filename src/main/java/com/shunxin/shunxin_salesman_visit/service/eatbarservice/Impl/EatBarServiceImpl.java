package com.shunxin.shunxin_salesman_visit.service.eatbarservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.*;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.*;
import com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper.EatBarMapper;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.EatBarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EatBarService")
public class EatBarServiceImpl implements EatBarService {

    @Resource
    private EatBarMapper eatBarMapper;

    @Override
    public List<BirthdayDto> getBirthdayList() {
        return eatBarMapper.getBirthdayList();
    }

    @Override
    public int addBirthday(String greeting) {
        return eatBarMapper.addBirthday(greeting);
    }

    @Override
    public List<EatMenus> selectMenusList(String me_dtime) {
        return eatBarMapper.selectMenusList(me_dtime);
    }

    @Override
    public String getApDtime() {
        return eatBarMapper.getApDtime();
    }

    @Override
    public int addMenus(String me_name) {
        return eatBarMapper.addMenus(me_name);
    }

    @Override
    public int updateMenus(String me_name, int me_id) {
        return eatBarMapper.updateMenus(me_name,me_id);
    }

    @Override
    public int getMenusCount(String me_dtime) {
        return eatBarMapper.getMenusCount(me_dtime);
    }

    @Override
    public int addStaff(String st_code, String st_name, String st_remark) {
        return eatBarMapper.addStaff(st_code,st_name,st_remark);
    }

    @Override
    public List<EatStaff> selectStaff(String st_code, String st_name) {
        return eatBarMapper.selectStaff(st_code,st_name);
    }

    @Override
    public int insertWxBinds(String st_code) {
        return eatBarMapper.insertWxBinds(st_code);
    }

    @Override
    public int addApply(String ap_code,String ap_type) {
        return eatBarMapper.addApply(ap_code,ap_type);
    }

    @Override
    public List<EatApplyDto> selectApply(String ap_dtime) {
        return eatBarMapper.selectApply(ap_dtime);
    }

    @Override
    public List<EatMenus> selectMenusName(String me_name) {
        return eatBarMapper.selectMenusName(me_name);
    }

    @Override
    public int getApplyInfo(String ap_code, String ap_dtime) {
        return eatBarMapper.getApplyInfo(ap_code,ap_dtime);
    }

    @Override
    public String getCname(String ccode) {
        return eatBarMapper.getCname(ccode);
    }

    @Override
    public List<PersonNameDto> getPersons(String cname) {
        return eatBarMapper.getPersons(cname);
    }

    @Override
    public int deleteStaff(int st_id) {
        return eatBarMapper.deleteStaff(st_id);
    }

    @Override
    public String selectStcode(int st_id) {
        return eatBarMapper.selectStcode(st_id);
    }

    @Override
    public String getWxCode(String wx_openid) {
        return eatBarMapper.getWxCode(wx_openid);
    }

    @Override
    public List<EatApplyDto> getApplyCode(String ap_dtime) {
        return eatBarMapper.getApplyCode(ap_dtime);
    }

    @Override
    public int updateAppleCode(String ap_type, String ap_code, String ap_dtime) {
        return eatBarMapper.updateAppleCode(ap_type,ap_code,ap_dtime);
    }

    @Override
    public int bandingWxOpen(String wx_code, String wx_openid) {
        return eatBarMapper.bandingWxOpen(wx_code,wx_openid);
    }

    @Override
    public String selectWxCode(String wx_code) {
        return eatBarMapper.selectWxCode(wx_code);
    }

    @Override
    public List<TmpSxDayrepory> selectDayrepory(String ddate, String cpcode) {
        return eatBarMapper.selectDayrepory(ddate,cpcode);
    }

    @Override
    public List<TmpSxDayrepory> selectDayreporyTwo(String ddate, String cpcode) {
        return eatBarMapper.selectDayreporyTwo(ddate,cpcode);
    }


    @Override
    public int addDayrepory(String cpcode, String ctoday, String ctomrrow, String creport,String creporter1,String creporter2) {
        return eatBarMapper.addDayrepory(cpcode,ctoday,ctomrrow,creport,creporter1,creporter2);
    }

    @Override
    public int deltDayrepory(int autoid) {
        return eatBarMapper.deltDayrepory(autoid);
    }

    @Override
    public int updateDayrepory(String ctoday, String ctomrrow, String creport,String creporter1,String creporter2, String cpcode, String ddate) {
        return eatBarMapper.updateDayrepory(ctoday,ctomrrow,creport,creporter1,creporter2,cpcode,ddate);
    }

    @Override
    public List<SxCharges> selectCharge() {
        return eatBarMapper.selectCharge();
    }

    @Override
    public String selectCreporter(String cpcode) {
        return eatBarMapper.selectCreporter(cpcode);
    }

    @Override
    public List<Empty> selectEmpty(String cperson_id) {
        return eatBarMapper.selectEmpty(cperson_id);
    }

    @Override
    public int addStaffTmp(String cname, String ccode, String xpoint, String ypoint, String cadress) {
        return eatBarMapper.addStaffTmp(cname,ccode,xpoint,ypoint,cadress);
    }

    @Override
    public int updateStaffTmp(String xpoint, String ypoint, String cadress, String ccode) {
        return eatBarMapper.updateStaffTmp(xpoint,ypoint,cadress,ccode);
    }

    @Override
    public List<staffTmpDto> getStaffTmp(String ccode) {
        return eatBarMapper.getStaffTmp(ccode);
    }

    @Override
    public List<CustomerAddress> getLinsiAddress() {
        return eatBarMapper.getLinsiAddress();
    }

    @Override
    public int addMapTmp(String lat, String lng, String param1) {
        return eatBarMapper.addMapTmp(lat,lng,param1);
    }

    @Override
    public List<MapTmps> getMapTmp() {
        return eatBarMapper.getMapTmp();
    }

    @Override
    public int deleteMapTmp(String param1) {
        return eatBarMapper.deleteMapTmp(param1);
    }

    @Override
    public List<ResultDto> addStaffPayVisit(String jsonvist) {
        return eatBarMapper.addStaffPayVisit(jsonvist);
    }

    @Override
    public int getStaffPayCount(String cfllow_cid, String cfllow_pid) {
        return eatBarMapper.getStaffPayCount(cfllow_cid,cfllow_pid);
    }

    @Override
    public List<TempFllowVisit> getTempFllowVisit(String cname, String ddate1, String ddate2, String ccompany_id, String cfllow_cid, String cdefine1, String cdefine2, String cdefine3, String cdefine4) {
        return eatBarMapper.getTempFllowVisit(cname,ddate1,ddate2,ccompany_id,cfllow_cid,cdefine1,cdefine2,cdefine3,cdefine4);
    }

    @Override
    public List<FllowImgDto> getFllowImg(String fllowid) {
        return eatBarMapper.getFllowImg(fllowid);
    }

    @Override
    public List<FllowStatis> getFllowStatistics() {
        return eatBarMapper.getFllowStatistics();
    }

    @Override
    public int getFllowCount(String cfllow_pid) {
        return eatBarMapper.getFllowCount(cfllow_pid);
    }

    @Override
    public List<PersonNameDto> selectPersons() {
        return eatBarMapper.selectPersons();
    }

}
