package com.shunxin.shunxin_salesman_visit.service.signservice.signserviceImpl;

import com.shunxin.shunxin_salesman_visit.entity.signentity.CallCenter;
import com.shunxin.shunxin_salesman_visit.mapper.signmapper.CallCenterMapper;
import com.shunxin.shunxin_salesman_visit.service.signservice.CallCenterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("/CallCenterService")
public class CallCenterServiceImpl implements CallCenterService {


    @Resource
    private CallCenterMapper centerMapper;

    @Override
    public List<CallCenter> selectCallService(String copenid) {
        return centerMapper.selectCallService(copenid);
    }

    @Override
    public List<CallCenter> selectAllService(String copenid) {
        return centerMapper.selectAllService(copenid);
    }

    @Override
    public int insertCallService(String copenid, String csource, String cmsgtext) {
        return centerMapper.insertCallService(copenid,csource,cmsgtext);
    }

    @Override
    public String sendMessages(String cperson_id, String msgtext) {
        return centerMapper.sendMessages(cperson_id,msgtext);
    }

    @Override
    public int updateCdefine5(String copenid) {
        return centerMapper.updateCdefine5(copenid);
    }

    @Override
    public Date selectMaxCdefine5(String copenid) {
        return centerMapper.selectMaxCdefine5(copenid);
    }

}
