package com.shunxin.shunxin_salesman_visit.service.clientservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.*;
import com.shunxin.shunxin_salesman_visit.mapper.clientmapper.SxPersonareaMapper;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service("SxPersonareaService")
public class SxPersonareaServiceImpl implements SxPersonareaService {

    @Resource
    private SxPersonareaMapper sxPersonareaMapper;


    @Override
    public String selectCompand(String cuser_id) {
        return sxPersonareaMapper.selectCompand(cuser_id);
    }

    @Override
    public List<ParameterDto> selectCuserTemp(String cuser_id) {
        return sxPersonareaMapper.selectCuserTemp(cuser_id);
    }

    @Override
    public int insertPersonareaTemp(String ccompand_id, String cuser_id, BigDecimal xpoint, BigDecimal ypoint, String param1) {
        return sxPersonareaMapper.insertPersonareaTemp(ccompand_id,cuser_id,xpoint,ypoint,param1);
    }

    @Override
    public int selectExistTemp(String cuser_id,String param1) {
        return sxPersonareaMapper.selectExistTemp(cuser_id,param1);
    }

    @Override
    public int delectPersonareaTemp(String cuser_id) {
        return sxPersonareaMapper.delectPersonareaTemp(cuser_id);
    }

    @Override
    public List<ParameterDto> selectCuser(String cuser_id) {
        return sxPersonareaMapper.selectCuser(cuser_id);
    }

    @Override
    public int insertPersonarea(String ccompand_id, String cuser_id, BigDecimal xpoint, BigDecimal ypoint, String param1) {
        return sxPersonareaMapper.insertPersonarea(ccompand_id,cuser_id,xpoint,ypoint,param1);
    }

    @Override
    public int selectExist(String cuser_id) {
        return sxPersonareaMapper.selectExist(cuser_id);
    }

    @Override
    public int delectPersonarea(String cuser_id) {
        return sxPersonareaMapper.delectPersonarea(cuser_id);
    }

    @Override
    public int duplication(String cuser_id) {
        return sxPersonareaMapper.duplication(cuser_id);
    }

    @Override
    public List<SxPersonarea> selectCusersTemp(String cuser_id) {
        return sxPersonareaMapper.selectCusersTemp(cuser_id);
    }

    @Override
    public List<SxPersonarea> selectCusers(String cuser_id) {
        return sxPersonareaMapper.selectCusers(cuser_id);
    }

    @Override
    public List<SxPersonarea> selectDistance(String cuser_id) {
        return sxPersonareaMapper.selectDistance(cuser_id);
    }

    @Override
    public List<SxPersonarea> selectDistance2(String cuser_id) {
        return sxPersonareaMapper.selectDistance2(cuser_id);
    }

    @Override
    public List<SxPersonarea> selectAllCusers() {
        return sxPersonareaMapper.selectAllCusers();
    }

    @Override
    public List<SxPersonarea> selectCenterPoint(String cuser_id) {
        return sxPersonareaMapper.selectCenterPoint(cuser_id);
    }

    @Override
    public int updateParam2(String cuser_id, String param2) {
        return sxPersonareaMapper.updateParam2(cuser_id,param2);
    }


    @Override
    public List<ParameterDto> getPersonList(String ccomcode,String cdepcode,String ccode, String cname) {
        return sxPersonareaMapper.getPersonList(ccomcode,cdepcode,ccode,cname);
    }

    @Override
    public int detectionKey(String ckey, String userid) {
        return sxPersonareaMapper.detectionKey(ckey,userid);
    }

    @Override
    public List<SxOrderInfo> getOrderList(String userid,String csocode) {
        return sxPersonareaMapper.getOrderList(userid,csocode);
    }

    @Override
    public List<OrdervDto> getOrderOne(String csocode) {
        return sxPersonareaMapper.getOrderOne(csocode);
    }

    @Override
    public int increaseLog(String userid, String csocode) {
        return sxPersonareaMapper.increaseLog(userid,csocode);
    }

    @Override
    public int bindingOPenid(String openid, String ccode, String md5str) {
        return sxPersonareaMapper.bindingOPenid(openid,ccode,md5str);
    }

    @Override
    public List<WeixinDto>  selectOderOpen(String md5str) {
        return sxPersonareaMapper.selectOderOpen(md5str);
    }

    @Override
    public List<SxcustomerWxbind> selectWxbindOpenid(String copenid) {
        return sxPersonareaMapper.selectWxbindOpenid(copenid);
    }

    @Override
    public List<SxcustomerWxbind> selectWxbindOpenid2(String copenid) {
        return sxPersonareaMapper.selectWxbindOpenid2(copenid);
    }

    @Override
    public int updateDbefault(String copenid) {
        return sxPersonareaMapper.updateDbefault(copenid);
    }

    @Override
    public int updateDbefault2(String copenid, String ccusid) {
        return sxPersonareaMapper.updateDbefault2(copenid,ccusid);
    }

    @Override
    public int selectCcusid(String ccusid) {
        return sxPersonareaMapper.selectCcusid(ccusid);
    }

    @Override
    public SxCustomer getCustomerPanyID(String autoid) {
        return sxPersonareaMapper.getCustomerPanyID(autoid);
    }

    @Override
    public String getInformCvalues(String cname) {
        return sxPersonareaMapper.getInformCvalues(cname);
    }

    @Override
    public int getTomerWxbind(String ccusid, String copenid) {
        return sxPersonareaMapper.getTomerWxbind(ccusid,copenid);
    }

    @Override
    public int getCcusidBind(String ccusid) {
        return sxPersonareaMapper.getCcusidBind(ccusid);
    }

    @Override
    public List<SxcustomerWxbind> selectCopenid(String ccusid) {
        return sxPersonareaMapper.selectCopenid(ccusid);
    }

    @Override
    public List<TouristDto> selectTouristInfo() {
        return sxPersonareaMapper.selectTouristInfo();
    }

    @Override
    public int insertCustomerWx(String ccusid, String copenid, String cunitid) {
        return sxPersonareaMapper.insertCustomerWx(ccusid,copenid,cunitid);
    }

    @Override
    public int delectWxbind(String openid) {
        return sxPersonareaMapper.delectWxbind(openid);
    }

    @Override
    public int deleteWxDate() {
        return sxPersonareaMapper.deleteWxDate();
    }


    @Override
    public int insertGztoken(String access_token) {
        return sxPersonareaMapper.insertGztoken(access_token);
    }

    @Override
    public int updateGztoken(String access_token) {
        return sxPersonareaMapper.updateGztoken(access_token);
    }

    @Override
    public int validationDEXTIME() {
        return sxPersonareaMapper.validationDEXTIME();
    }

    @Override
    public String selectGztoken() {
        return sxPersonareaMapper.selectGztoken();
    }

    @Override
    public int insertQytoken(String cuser_id,String access_token) {
        return sxPersonareaMapper.insertQytoken(cuser_id,access_token);
    }

    @Override
    public int updateQytoken(String access_token,String cuser_id) {
        return sxPersonareaMapper.updateQytoken(access_token,cuser_id);
    }

    @Override
    public int validtionQytoken(String cuser_id) {
        return sxPersonareaMapper.validtionQytoken(cuser_id);
    }

    @Override
    public String selectQytoken(String cuser_id) {
        return sxPersonareaMapper.selectQytoken(cuser_id);
    }

    @Override
    public List<PrintLogDto> selectPrintlog(String ddate, String cperson_id, String ccomcode) {
        return sxPersonareaMapper.selectPrintlog(ddate,cperson_id,ccomcode);
    }

    @Override
    public List<OrdervDto> selectOrdervList(String ccus_id, String ddate2, String csocode, String cso_state) {
        return sxPersonareaMapper.selectOrdervList(ccus_id,ddate2,csocode,cso_state);
    }

    @Override
    public int getOrderStatus(String csocode) {
        return sxPersonareaMapper.getOrderStatus(csocode);
    }

    @Override
    public int insertMd5OpenID(String openid, String md5str) {
        return sxPersonareaMapper.insertMd5OpenID(openid,md5str);
    }

    @Override
    public String judgeOpenid(String md5str) {
        return sxPersonareaMapper.judgeOpenid(md5str);
    }

    @Override
    public List<ResultDto> addPersonDot(String jsonvisit) {
        return sxPersonareaMapper.addPersonDot(jsonvisit);
    }

    @Override
    public wxlogindataDto exchangeCkey(String cuser_id, String copenid) {
        return sxPersonareaMapper.exchangeCkey(cuser_id,copenid);
    }

    @Override
    public List<SxOrderGift> getSxOrderGift(int autoid) {
        return sxPersonareaMapper.getSxOrderGift(autoid);
    }


}
