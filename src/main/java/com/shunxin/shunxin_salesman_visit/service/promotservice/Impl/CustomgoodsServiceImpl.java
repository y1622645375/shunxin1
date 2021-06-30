package com.shunxin.shunxin_salesman_visit.service.promotservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.CustomerDto;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.CustomGoodDto;
import com.shunxin.shunxin_salesman_visit.mapper.promotmapper.CustomgoodsMapper;
import com.shunxin.shunxin_salesman_visit.service.promotservice.CustomgoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CustomgoodsService")
public class CustomgoodsServiceImpl implements CustomgoodsService {


    @Resource
    private CustomgoodsMapper customgoodsMapper;


    @Override
    public List<CustomGoodDto> selectCustoms(String cperson_id, String ccus_name) {
        return customgoodsMapper.selectCustoms(cperson_id,ccus_name);
    }

    @Override
    public List<CustomGoodDto> selectCommodity(String cinvname) {
        return customgoodsMapper.selectCommodity(cinvname);
    }

    @Override
    public int addCommdityToCustoms(String ccomcode,String ccus_id, String cinvcode, String cperson_id) {
        return customgoodsMapper.addCommdityToCustoms(ccomcode,ccus_id,cinvcode,cperson_id);
    }

    @Override
    public int deleteCommdityToCustoms(String ccus_id) {
        return customgoodsMapper.deleteCommdityToCustoms(ccus_id);
    }

    @Override
    public int deleteCustomsToCommdity(String cinvcode) {
        return customgoodsMapper.deleteCustomsToCommdity(cinvcode);
    }

    @Override
    public String selectCompany(String cperson_id) {
        return customgoodsMapper.selectCompany(cperson_id);
    }

    @Override
    public List<CustomerDto> getCustomCommdity(String ccus_id) {
        return customgoodsMapper.getCustomCommdity(ccus_id);
    }

    @Override
    public List<CustomerDto> getCommdityCustom(String cinvcode,String cperson_id) {
        return customgoodsMapper.getCommdityCustom(cinvcode,cperson_id);
    }


}
