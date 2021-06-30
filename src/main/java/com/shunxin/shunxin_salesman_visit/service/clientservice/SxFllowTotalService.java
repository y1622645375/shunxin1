package com.shunxin.shunxin_salesman_visit.service.clientservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.FllowTotalDto;

import java.util.Date;
import java.util.List;

public interface SxFllowTotalService {

    /**
     * 查询今日该拜访数量和已拜访数量
     * @param ctotal_pid
     * @param dtotal_time
     * @return
     */
    List<FllowTotalDto> selectFllowTotaCount(String ctotal_pid, Date dtotal_time);


    /**
     * 更新key的过期时间
     * @param ddate
     * @return
     */
    int renewalExpirationTime(String ddate,String cuser_id);


}
