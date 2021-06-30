package com.shunxin.shunxin_salesman_visit.service.clientservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.FllowTotalDto;
import com.shunxin.shunxin_salesman_visit.mapper.clientmapper.SxFllowTotalMapper;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxFllowTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("SxFllowTotalService")
public class SxFllowTotalServiceImpl implements SxFllowTotalService {

    @Resource
    private SxFllowTotalMapper sxFllowTotalMapper;

    @Override
    public List<FllowTotalDto> selectFllowTotaCount(String ctotal_pid, Date dtotal_time) {
        return sxFllowTotalMapper.selectFllowTotaCount(ctotal_pid,dtotal_time);
    }

    @Override
    public int renewalExpirationTime(String ddate,String cuser_id) {
        return sxFllowTotalMapper.renewalExpirationTime(ddate,cuser_id);
    }

}
