package com.shunxin.shunxin_salesman_visit.service.clientservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxOutRetained;
import com.shunxin.shunxin_salesman_visit.mapper.clientmapper.SxOutBoundMapper;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxOutboundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SxOutbounds")
public class SxOutboundServiceImpl implements SxOutboundService {


    @Resource
    private SxOutBoundMapper sxOutBoundMapper;

    @Override
    public List<ResultDto> addOutBoundLists(String jsonvist) {
        return sxOutBoundMapper.addOutBoundLists(jsonvist);
    }

    @Override
    public List<SxOutRetained> getOutBoundList(String cperson_id, String ddate1, String ddate2, String cstate,String csotype) {
        return sxOutBoundMapper.getOutBoundList(cperson_id,ddate1,ddate2,cstate,csotype);
    }

    @Override
    public List<SxOutRetained> getSxOutRetained(String cperson_id) {
        return sxOutBoundMapper.getSxOutRetained(cperson_id);
    }

    @Override
    public List<SxOutRetained> getSxSoorderList(String cperson_id) {
        return sxOutBoundMapper.getSxSoorderList(cperson_id);
    }

    @Override
    public int updateSxSoorder(String jsonvist) {
        return sxOutBoundMapper.updateSxSoorder(jsonvist);
    }

    @Override
    public List<SxOutRetained> getStaffpsnHold(String ccode,String cperson_id,String ddate1,String ddate2,String cstate) {
        return sxOutBoundMapper.getStaffpsnHold(ccode,cperson_id,ddate1,ddate2,cstate);
    }

    @Override
    public List<SxOutRetained> getStaffpsnList(String cperson_id, String ccus_id, String ddate1, String ddate2, String cstate) {
        return sxOutBoundMapper.getStaffpsnList(cperson_id,ccus_id,ddate1,ddate2,cstate);
    }

    @Override
    public List<SxOutRetained> getSxSoorderPlace(String cperson_id,String ccus_id) {
        return sxOutBoundMapper.getSxSoorderPlace(cperson_id,ccus_id);
    }


    /*@Override
    public int addOutBoundList(List<SxOutBoundDto> boundDtos) {
        return sxOutBoundMapper.addOutBoundList(boundDtos);
    }*/


    /*@Override
    public int addOutBoundList(String csocode, String cperson_id, String cstate, String ccus_id, String csotype, String cinvcode, String iquantity, String iprice, String imoney) {
        return sxOutBoundMapper.addOutBoundList(csocode,cperson_id,cstate,ccus_id,csotype,cinvcode,iquantity,iprice,imoney);
    }*/




}
