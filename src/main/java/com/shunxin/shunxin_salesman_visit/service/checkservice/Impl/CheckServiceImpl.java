package com.shunxin.shunxin_salesman_visit.service.checkservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.checkdto.CcomcodeDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.CheckDto;
import com.shunxin.shunxin_salesman_visit.dto.checkdto.WorkCheckGroupDto;
import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PersonNameDto;
import com.shunxin.shunxin_salesman_visit.entity.checkentity.*;
import com.shunxin.shunxin_salesman_visit.mapper.checkmapper.CheckMapper;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CheckService")
public class CheckServiceImpl implements CheckService {


    @Resource
    private CheckMapper checkMapper;


    @Override
    public int addCheckin(String cpersoncode,String cworkrule, String cworktype, String dstandtime, String dchecktime, String clocation_title, String clocation_detail, String cworkdevice, String cnotes, Double lat, Double lng, String ccheckimg,String dchecktype) {
        return checkMapper.addCheckin(cpersoncode, cworkrule,cworktype,dstandtime,dchecktime,clocation_title,clocation_detail,cworkdevice,cnotes,lat,lng,ccheckimg,dchecktype);
    }

    @Override
    public List<ResultDto> updateCheckin(String jsonvist) {
        return checkMapper.updateCheckin(jsonvist);
    }

    @Override
    public String charmKeyValidity(String cuserid, String ckey, int ilogin_type) {
        return checkMapper.charmKeyValidity(cuserid,ckey,ilogin_type);
    }

    @Override
    public List<CcomcodeDto> getPersonCcomcode() {
        return checkMapper.getPersonCcomcode();
    }

    @Override
    public int updateDstandTime(int dstandtime, String cworkrule) {
        return checkMapper.updateDstandTime(dstandtime,cworkrule);
    }

    @Override
    public List<CcomcodeDto> getCworkrule() {
        return checkMapper.getCworkrule();
    }


    @Override
    public int addWorkCheckRule(String cpersoncode, String cworkrule, int dstandtime,String ctype) {
        return checkMapper.addWorkCheckRule(cpersoncode,cworkrule,dstandtime,ctype);
    }

    @Override
    public List<CheckIng> getWorkCheckList(String jsonvist) {
        return checkMapper.getWorkCheckList(jsonvist);
    }

    @Override
    public List<Workcheck> getWorkCheckNext(String jsonvist) {
        return checkMapper.getWorkCheckNext(jsonvist);
    }


    @Override
    public List<WorkCheckGroupDto> getStaffWorkCheck() {
        return checkMapper.getStaffWorkCheck();
    }


    @Override
    public List<WorkCheckClass> getWorkCheckClass() {
        return checkMapper.getWorkCheckClass();
    }

    @Override
    public List<PersonNameDto> selectPersonNameList(String cname) {
        return checkMapper.selectPersonNameList(cname);
    }

    @Override
    public List<Workcheck> selectCpersonCodeList() {
        return checkMapper.selectCpersonCodeList();
    }

    @Override
    public List<CheckIng> selectWorkCheeckClassId(String cpersoncode) {
        return checkMapper.selectWorkCheeckClassId(cpersoncode);
    }

    @Override
    public int addWorkCheckLog(String ccode, String cstate) {
        return checkMapper.addWorkCheckLog(ccode,cstate);
    }

    @Override
    public List<WorkcheckLog> getWorkCheckLog() {
        return checkMapper.getWorkCheckLog();
    }

    @Override
    public int updateWorkCheckLog( String ccode, String cstate) {
        return checkMapper.updateWorkCheckLog(ccode,cstate);
    }

    @Override
    public int updateStaffWorkcheck(String cworktype,String iwctype,long starttime) {
        return checkMapper.updateStaffWorkcheck(cworktype,iwctype,starttime);
    }

    @Override
    public List<ResultDto> changeWorkClass(String jsonvist) {
        return checkMapper.changeWorkClass(jsonvist);
    }

    @Override
    public List<CheckDto> getCheckDtoList(String cpersoncode) {
        return checkMapper.getCheckDtoList(cpersoncode);
    }

    @Override
    public List<WorkCheckList> selectWorkCheckV(String ccomcode, String cdepcode, String cname,String ddate1,String ddate2) {
        return checkMapper.selectWorkCheckV(ccomcode,cdepcode,cname,ddate1,ddate2);
    }

    @Override
    public int getUserHold(String cusercode) {
        return checkMapper.getUserHold(cusercode);
    }

    @Override
    public int addWorkCheckGroup(String cgroupcode, String cgroupname, String cpcode) {
        return checkMapper.addWorkCheckGroup(cgroupcode,cgroupname,cpcode);
    }

    @Override
    public int deleteWorkCheckGroup(String cpcode, String cgroupcode) {
        return checkMapper.deleteWorkCheckGroup(cpcode,cgroupcode);
    }

    @Override
    public List<WorkCheckMonSta> getStaffWorkcheckDay(String cuserid,String cpersoncode, String iperiod, String ccomcode,String cdepcode,String czjcode) {
        return checkMapper.getStaffWorkcheckDay(cuserid,cpersoncode,iperiod,ccomcode,cdepcode,czjcode);
    }

    @Override
    public List<WorkcheckRecord> getWorkcheckRecordList() {
        return checkMapper.getWorkcheckRecordList();
    }


}
