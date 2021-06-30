package com.shunxin.shunxin_salesman_visit.service.clientservice.Impl;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.LinenameTotal;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxCustomer;
import com.shunxin.shunxin_salesman_visit.mapper.clientmapper.SxCustomerMapper;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service("SxCustomerService")
public class SxCustomerServiceImpl implements SxCustomerService {

    @Resource
    private SxCustomerMapper sxCustomerMapper;


    @Override
    public List<SxCustomer> selectCustomerList(String cperson_id, String ccus_status, String ccus_name, int autoid) {
        return sxCustomerMapper.selectCustomerList(cperson_id,ccus_status,ccus_name,autoid);
    }


    @Override
    public CustNumberDto selectCustomerCount(String cperson_id) {
        return sxCustomerMapper.selectCustomerCount(cperson_id);
    }

    @Override
    public List<ResultDto> insertCustomer(String jsonvisit) {
        return sxCustomerMapper.insertCustomer(jsonvisit);
    }


    @Override
    public List<FllowCuslistDto> selectFllowCuslistList(String cperson_id, BigDecimal xpiont, BigDecimal ypiont, int distance, String ccus_name, int bplan) {
        return sxCustomerMapper.selectFllowCuslistList(cperson_id,xpiont,ypiont,distance,ccus_name,bplan);
    }


    @Override
    public List<EnumdataDto> selectEnumdatasList(String ctype) {
        return sxCustomerMapper.selectEnumdatasList(ctype);
    }


    @Override
    public List<FllowCuslistDto> getFllowCusList(String cperson_id, BigDecimal xpiont, BigDecimal ypiont, int distance, String ccus_name, int bplan) {
        return sxCustomerMapper.getFllowCusList(cperson_id,xpiont,ypiont,distance,ccus_name,bplan);
    }

    @Override
    public List<SalesmanDto> selectSalesmanList(String ccode, String cname) {
        return sxCustomerMapper.selectSalesmanList(ccode,cname);
    }

    @Override
    public List<CustomerDto> selectCustomerListcharge(String cperson_id, String ccus_status, String ccus_name, int autoid) {
        return sxCustomerMapper.selectCustomerListcharge(cperson_id,ccus_status,ccus_name,autoid);
    }

    @Override
    public List<PersonDto> selectPersonList(String cfllow_pid) {
        return sxCustomerMapper.selectPersonList(cfllow_pid);
    }

    @Override
    public List<ResultDto> updateCuslist(int autoid, String cuser_id, String cchecktext) {
        return sxCustomerMapper.updateCuslist(autoid,cuser_id,cchecktext);
    }

    @Override
    public int insertPayvisit(String ccus_cid, String ccus_pid, String ccus_visit_type, String ccus_visit_time) {
        return sxCustomerMapper.insertPayvisit(ccus_cid,ccus_pid,ccus_visit_type,ccus_visit_time);
    }

    @Override
    public int deleteCustomer(String ccus_cid, String ccus_pid) {
        return sxCustomerMapper.deleteCustomer(ccus_cid,ccus_pid);
    }

    @Override
    public List<SxCustomer> selectCustomerList2(String cperson_id, String ccus_name, String ccus_account, String cperson_name, String ccus_type, String ccus_level, String ccus_visit_type, String icus_visit_time,String ccus_status,String ccompany_id) {
        return sxCustomerMapper.selectCustomerList2(cperson_id,ccus_name,ccus_account,cperson_name,ccus_type,ccus_level,ccus_visit_type,icus_visit_time,ccus_status,ccompany_id);
    }

    @Override
    public List<ResultDto> updateccusStatus(String customerjson) {
        return sxCustomerMapper.updateccusStatus(customerjson);
    }

    @Override
    public List<ResultDto> updateAudit(String customerjson) {
        return sxCustomerMapper.updateAudit(customerjson);
    }

    @Override
    public List<ParameterDto> selectPersonName(String cperson_id) {
        return sxCustomerMapper.selectPersonName(cperson_id);
    }

    @Override
    public List<String> selectCcompany(String cperson_id) {
        return sxCustomerMapper.selectCcompany(cperson_id);
    }

    @Override
    public List<ResultDto> delectCustomers(int autoid) {
        return sxCustomerMapper.delectCustomers(autoid);
    }

    @Override
    public List<LinenameTotal> selectLinenameTotal(String tables_name) {
        return sxCustomerMapper.selectLinenameTotal(tables_name);
    }

    @Override
    public List<ResultDto> batchUpdate(String customerinfo) {
        return sxCustomerMapper.batchUpdate(customerinfo);
    }

    @Override
    public List<CustomerDto> selectCustomer(int autoid) {
        return sxCustomerMapper.selectCustomer(autoid);
    }


}
