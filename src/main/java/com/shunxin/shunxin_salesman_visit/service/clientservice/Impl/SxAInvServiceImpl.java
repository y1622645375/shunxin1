package com.shunxin.shunxin_salesman_visit.service.clientservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.TouristDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.AutoChar;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.InventoryClass;
import com.shunxin.shunxin_salesman_visit.mapper.clientmapper.SxAInvMapper;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxAInvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SxAInvService")
public class SxAInvServiceImpl implements SxAInvService {

    @Resource
    private SxAInvMapper sxAInvMapper;


    @Override
    public List<InventoryClass> getInventClass() {
        return sxAInvMapper.getInventClass();
    }

    @Override
    public List<Inventory> getInventory(String ccomcode,String ccus_level,String cInvCCode) {
        return sxAInvMapper.getInventory(ccomcode,ccus_level,cInvCCode);
    }

    @Override
    public List<AutoChar> selectAutoChar(String ctype, String userid, String ddate1, String ddate2) {
        return sxAInvMapper.selectAutoChar(ctype,userid,ddate1,ddate2);
    }

    @Override
    public String getCcusAccount(String autoid) {
        return sxAInvMapper.getCcusAccount(autoid);
    }

    @Override
    public List<TouristDto> selectCcompanyId(String autoid) {
        return sxAInvMapper.selectCcompanyId(autoid);
    }


}
