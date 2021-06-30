package com.shunxin.shunxin_salesman_visit.mapper.clientmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.FllowTotalDto;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SxFllowTotalMapper {

    /**
     *  查询今日该拜访数量和已拜访数量
     * @param ctotal_pid
     * @param dtotal_time
     * @return
     */
    List<FllowTotalDto> selectFllowTotaCount(@Param("ctotal_pid") String ctotal_pid, @Param("dtotal_time") Date dtotal_time);


    /**
     * 更新key的过期时间
     * @param ddate
     * @return
     */
    int renewalExpirationTime(@Param("ddate") String ddate,@Param("cuser_id") String cuser_id);



}
