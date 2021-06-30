package com.shunxin.shunxin_salesman_visit.service.eatbarservice.Impl;

import com.shunxin.shunxin_salesman_visit.entity.cliententity.Inventory;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.Compay;
import com.shunxin.shunxin_salesman_visit.entity.eatbarentity.PriceEnter;
import com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper.PriceEnterMapper;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.PriceEnterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("PriceEnterService")
public class PriceEnterServiceImpl implements PriceEnterService {

    @Resource
    private PriceEnterMapper priceEnterMapper;

    @Override
    public List<PriceEnter> selectPriceEnter(String ccus_account,String ddate,String cuserid) {
        return priceEnterMapper.selectPriceEnter(ccus_account,ddate,cuserid);
    }


    @Override
    public List<Compay> selectCompay(String cusercode, String ctype) {
        return priceEnterMapper.selectCompay(cusercode,ctype);
    }

    @Override
    public List<Compay> selectEnumdataLists(String ctype, String cuser_id) {
        return priceEnterMapper.selectEnumdataLists(ctype,cuser_id);
    }

    @Override
    public int addInventoryExt(String ccomcode, String cinvcode, String ccus_level, BigDecimal ccus_price, Float igoldrate, Date ddateb, Date ddatee, int igrade) {
        return priceEnterMapper.addInventoryExt(ccomcode,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,igrade);
    }

    @Override
    public List<Inventory> getInvents(String cInvName) {
        return priceEnterMapper.getInvents(cInvName);
    }

    @Override
    public int updateInvents(String ccomcode, String cinvcode, String ccus_level, BigDecimal ccus_price, Float igoldrate, Date ddateb, Date ddatee, int igrade, int autoid) {
        return priceEnterMapper.updateInvents(ccomcode,cinvcode,ccus_level,ccus_price,igoldrate,ddateb,ddatee,igrade,autoid);
    }


}
