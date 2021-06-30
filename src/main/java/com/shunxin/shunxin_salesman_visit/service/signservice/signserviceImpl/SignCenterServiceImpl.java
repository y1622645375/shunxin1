package com.shunxin.shunxin_salesman_visit.service.signservice.signserviceImpl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.ResultDto;
import com.shunxin.shunxin_salesman_visit.dto.signdto.PersonalCenter;
import com.shunxin.shunxin_salesman_visit.entity.signentity.Information;
import com.shunxin.shunxin_salesman_visit.entity.signentity.IntegralRecord;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignCommod;
import com.shunxin.shunxin_salesman_visit.entity.signentity.SignRecord;
import com.shunxin.shunxin_salesman_visit.mapper.signmapper.SignCenterMapper;
import com.shunxin.shunxin_salesman_visit.service.signservice.SignCenterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/SignCenterService")
public class SignCenterServiceImpl implements SignCenterService {

    @Resource
    private SignCenterMapper signCenterMapper;


    @Override
    public ResultDto insertSignRecord(String jsonvisit) {
        return signCenterMapper.insertSignRecord(jsonvisit);
    }

    @Override
    public IntegralRecord selectSignIntegral(String integral_cid) {
        return signCenterMapper.selectSignIntegral(integral_cid);
    }

    @Override
    public IntegralRecord getTodayIntegral(String csign_cid) {
        return signCenterMapper.getTodayIntegral(csign_cid);
    }

    @Override
    public int getSignTodayRecord(String csign_cid) {
        return signCenterMapper.getSignTodayRecord(csign_cid);
    }


    @Override
    public List<SignRecord> selectSignRecord(String csign_cid) {
        return signCenterMapper.selectSignRecord(csign_cid);
    }

    @Override
    public List<SignCommod> selectCommodList() {
        return signCenterMapper.selectCommodList();
    }

    @Override
    public List<IntegralRecord> selectCreditsExchange(String integral_type, String integral_cid) {
        return signCenterMapper.selectCreditsExchange(integral_type,integral_cid);
    }


    @Override
    public List<IntegralRecord> selectCommodExchange(String integral_type, String integral_cid) {
        return signCenterMapper.selectCommodExchange(integral_type,integral_cid);
    }

    @Override
    public SignCommod getSignCommods(int autoid) {
        return signCenterMapper.getSignCommods(autoid);
    }

    @Override
    public int updateCommodQuan(int iquan, int rquan, int autoid) {
        return signCenterMapper.updateCommodQuan(iquan,rquan,autoid);
    }

    @Override
    public int addIntegralCommod(String integral_cid, String integral_type, int integral_Dr, int integral_Cr, int integral_Ye, int commod_id) {
        return signCenterMapper.addIntegralCommod(integral_cid,integral_type,integral_Dr,integral_Cr,integral_Ye,commod_id);
    }

    @Override
    public Information selectInformation(String cname) {
        return signCenterMapper.selectInformation(cname);
    }

    /*@Override
    public int selectFllowRecord(String integral_cid, String integral_type) {
        return signCenterMapper.selectFllowRecord(integral_cid,integral_type);
    }

    @Override
    public int addIntegralFllow(String integral_cid, String integral_type, int integral_Dr, int integral_Cr, int integral_Ye, int fllow_id) {
        return signCenterMapper.addIntegralFllow(integral_cid,integral_type,integral_Dr,integral_Cr,integral_Ye,fllow_id);
    }

    @Override
    public int selectSxFllowToday(String cfllow_cid) {
        return signCenterMapper.selectSxFllowToday(cfllow_cid);
    }*/

    @Override
    public int updateIntegral(int integral_dr, int integral_ye, int autoid) {
        return signCenterMapper.updateIntegral(integral_dr,integral_ye,autoid);
    }

    @Override
    public IntegralRecord selectFllowIntegral(int fllow_id) {
        return signCenterMapper.selectFllowIntegral(fllow_id);
    }

    @Override
    public IntegralRecord selectOrderIntegral(int order_id) {
        return signCenterMapper.selectOrderIntegral(order_id);
    }

    @Override
    public List<PersonalCenter> selectPersonal(String copenid) {
        return signCenterMapper.selectPersonal(copenid);
    }

    /*@Override
    public IntegralRecord selectIntegralAutoid(int autoid) {
        return signCenterMapper.selectIntegralAutoid(autoid);
    }*/


}
