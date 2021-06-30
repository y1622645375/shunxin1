package com.shunxin.shunxin_salesman_visit.service.promotservice.Impl;

import com.shunxin.shunxin_salesman_visit.mapper.promotmapper.TrajectoryMapper;
import com.shunxin.shunxin_salesman_visit.service.promotservice.TrajectoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("/TrajectoryService")
public class TrajectoryServiceImpl implements TrajectoryService {

    @Resource
    private TrajectoryMapper trajectoryMapper;






}
