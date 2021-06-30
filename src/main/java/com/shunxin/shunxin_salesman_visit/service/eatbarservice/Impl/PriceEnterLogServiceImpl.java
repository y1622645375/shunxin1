package com.shunxin.shunxin_salesman_visit.service.eatbarservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.PriceAllDto;
import com.shunxin.shunxin_salesman_visit.dto.malldto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnterLog;
import com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper.PriceEnterLogMapper;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.PriceEnterLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("PriceEnterLogService")
public class PriceEnterLogServiceImpl implements PriceEnterLogService {


    @Resource
    private PriceEnterLogMapper logMapper;


    @Override
    public List<PriceAllDto> getCuserCode() {
        return logMapper.getCuserCode();
    }

    @Override
    public List<PriceEnterLog> selectPriceEnterLog(String cuser_id,String ccomcode, String cinvcode, String ccus_level,String ddate) {
        return logMapper.selectPriceEnterLog(cuser_id,ccomcode,cinvcode,ccus_level,ddate);
    }

    @Override
    public int insertPriceEnter(String ccomcode, String cuser_id, String cinvcode, String ccus_level, BigDecimal ccus_price, Float igoldrate, Date ddateb, Date ddatee, String cmemo) {
        return logMapper.insertPriceEnter(ccomcode,cuser_id,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,cmemo);
    }

    @Override
    public int updatePriceEnter(String ccomcode, String cuser_id, String cinvcode, String ccus_level, BigDecimal ccus_price, Float igoldrate, Date ddateb, Date ddatee, String cmemo, int autoid) {
        return logMapper.updatePriceEnter(ccomcode,cuser_id,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,cmemo,autoid);
    }

    @Override
    public String getChecktepy(int autoid) {
        return logMapper.getChecktepy(autoid);
    }


    @Override
    public int forbiddenInventory(String ccloser, String cmemo, int autoid) {
        return logMapper.forbiddenInventory(ccloser,cmemo,autoid);
    }


    @Override
    public PriceEnterLog getExtLogs(int autoid) {
        return logMapper.getExtLogs(autoid);
    }


    @Override
    public int updateBclose(int iext_id) {
        return logMapper.updateBclose(iext_id);
    }


    @Override
    public int checkInventory(String cchecker, int autoid) {
        return logMapper.checkInventory(cchecker,autoid);
    }


    @Override
    public int judgeRepeat(String ccomcode, String ccus_level, String cinvcode, Date ddateb, Date ddatee) {
        return logMapper.judgeRepeat(ccomcode,ccus_level,cinvcode,ddateb,ddatee);
    }

    @Override
    public int judgeInventoryExt(String ccomcode, String ccus_level, String cinvcode) {
        return logMapper.judgeInventoryExt(ccomcode,ccus_level,cinvcode);
    }

    @Override
    public int judgeInventoryExtAutoid(String ccomcode, String ccus_level, String cinvcode) {
        return logMapper.judgeInventoryExtAutoid(ccomcode,ccus_level,cinvcode);
    }

    @Override
    public int updateIextId(int iext_id, int autoid) {
        return logMapper.updateIextId(iext_id,autoid);
    }

    @Override
    public List<ResultDto> stopPriceEnter(String jsonvist) {
        return logMapper.stopPriceEnter(jsonvist);
    }

    @Override
    public List<ResultDto> addPriceEnter(String jsonvist) {
        return logMapper.addPriceEnter(jsonvist);
    }

    @Override
    public List<ResultDto> modificatPriceEnter(String jsonvist) {
        return logMapper.modificatPriceEnter(jsonvist);
    }

    @Override
    public List<ResultDto> auditPriceEnter(String jsonvist) {
        return logMapper.auditPriceEnter(jsonvist);
    }

    @Override
    public int updateInventoryExt(String ddatee, int autoid) {
        return logMapper.updateInventoryExt(ddatee,autoid);
    }

    @Override
    public int updateInventoryExtLog(String ddatee,int autoid) {
        return logMapper.updateInventoryExtLog(ddatee,autoid);
    }


}
