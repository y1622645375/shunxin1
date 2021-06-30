package com.shunxin.shunxin_salesman_visit.service.eatbarservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.eatbardto.StatKsCusDto;
import com.shunxin.shunxin_salesman_visit.dto.eatbardto.TmpKsCusDto;
import com.shunxin.shunxin_salesman_visit.mapper.eatbarmapper.TmpKsCusMapper;
import com.shunxin.shunxin_salesman_visit.service.eatbarservice.TmpKsCusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("TmpKsCusService")
public class TmpKsCusServiceImpl implements TmpKsCusService {

    @Resource
    private TmpKsCusMapper tmpKsCusMapper;


    @Override
    public List<TmpKsCusDto> selectTmpKsCus() {
        return tmpKsCusMapper.selectTmpKsCus();
    }

    @Override
    public List<StatKsCusDto> selectStatKsCus() {
        return tmpKsCusMapper.selectStatKsCus();
    }

    @Override
    public String getPageUrl(String device_id) {
        return tmpKsCusMapper.getPageUrl(device_id);
    }

    @Override
    public int getUnionidExist(String unionid) {
        return tmpKsCusMapper.getUnionidExist(unionid);
    }

}
