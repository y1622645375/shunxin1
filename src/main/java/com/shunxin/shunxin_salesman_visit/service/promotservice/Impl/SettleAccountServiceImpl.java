package com.shunxin.shunxin_salesman_visit.service.promotservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.promotdto.OrderSubSum;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.AmountQuantity;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SettleDetailed;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SxJsqd;
import com.shunxin.shunxin_salesman_visit.mapper.promotmapper.SettleAccountMapper;
import com.shunxin.shunxin_salesman_visit.service.promotservice.SettleAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service("SettleAccountService")
public class SettleAccountServiceImpl implements SettleAccountService {


    @Resource
    private SettleAccountMapper settleAccountMapper;


    @Override
    public int createDetailedList(String cjscode, String cacc_id,String ccompand_id,String cpersoncode,String dbegin, String dend, String istate, int iquan, Double imoney, Double iqrmoney, Double ixjmoney, String cmemo) {
        return settleAccountMapper.createDetailedList(cjscode,cacc_id,ccompand_id,cpersoncode,dbegin,dend,istate,iquan,imoney,iqrmoney,ixjmoney,cmemo);
    }

    @Override
    public SxJsqd getCcompands(String cperson_id) {
        return settleAccountMapper.getCcompands(cperson_id);
    }

    @Override
    public int selectIstates(String cpersoncode) {
        return settleAccountMapper.selectIstates(cpersoncode);
    }

    @Override
    public List<SettleDetailed> selectOrderDetailed(String cperson_id, String dbegin, String dend) {
        return settleAccountMapper.selectOrderDetailed(cperson_id,dbegin,dend);
    }

    @Override
    public List<AmountQuantity> calculationAmount(String cperson_id, String dbegin, String dend) {
        return settleAccountMapper.calculationAmount(cperson_id,dbegin,dend);
    }

    @Override
    public OrderSubSum  selectOrderSubQuan(String cperson_id, String dbegin, String dend) {
        return settleAccountMapper.selectOrderSubQuan(cperson_id,dbegin,dend);
    }

    @Override
    public int updateOrderCdefine(int autoid, String cperson_id, String dbegin, String dend) {
        return settleAccountMapper.updateOrderCdefine(autoid,cperson_id,dbegin,dend);
    }

    @Override
    public int selectCjscodes(String cjscode) {
        return settleAccountMapper.selectCjscodes(cjscode);
    }

    @Override
    public int selectAutoids(String cjscode) {
        return settleAccountMapper.selectAutoids(cjscode);
    }

    @Override
    public Date selectMinDate(String cperson_id) {
        return settleAccountMapper.selectMinDate(cperson_id);
    }

    @Override
    public List<SxJsqd> selectSxJsqds(String cpersoncode, String istate, String dbegin, String dend) {
        return settleAccountMapper.selectSxJsqds(cpersoncode,istate,dbegin,dend);
    }

    @Override
    public List<SxJsqd> getjOrderCount(String cpersoncode, String istate, String dbegin, String dend) {
        return settleAccountMapper.getjOrderCount(cpersoncode,istate,dbegin,dend);
    }

    @Override
    public List<SxJsqd> selectJsqdOrders(String cperson_id, String dbegin, String dend) {
        return settleAccountMapper.selectJsqdOrders(cperson_id,dbegin,dend);
    }

    @Override
    public List<SxJsqd> getJsOrderSum(String cperson_id, String dbegin, String dend) {
        return settleAccountMapper.getJsOrderSum(cperson_id,dbegin,dend);
    }

    @Override
    public String getCjcodeStr(String cpersoncode) {
        return settleAccountMapper.getCjcodeStr(cpersoncode);
    }

    @Override
    public int insertRemoteprints(String ccode, String cuser_id, String ccomputer) {
        return settleAccountMapper.insertRemoteprints(ccode,cuser_id,ccomputer);
    }

    @Override
    public int selectOpenrowset(String ccode) {
        return settleAccountMapper.selectOpenrowset(ccode);
    }


}
