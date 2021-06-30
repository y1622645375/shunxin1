package com.shunxin.shunxin_salesman_visit.service.clientservice;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.LinenameTotal;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxCustomer;

import java.math.BigDecimal;
import java.util.List;

public interface SxCustomerService {



    /**
     * 根据客户类型、客户名称查询客户列表（包含模糊查询）
     * @param ccus_status
     * @param ccus_name
     * @return
     */
    List<SxCustomer> selectCustomerList(String cperson_id, String ccus_status, String ccus_name, int autoid);


    /**
     * 根据业务员ID查询其负责商家的数量
     * @param cperson_id
     * @return
     */
     CustNumberDto selectCustomerCount(String cperson_id);



    /**
     * 新增客户
     * @return
     */
    List<ResultDto> insertCustomer(String jsonvisit);


    /**
     * 查询今日拜访客户列表
     * @param cperson_id
     * @param xpiont
     * @param ypiont
     * @param distance
     * @return
     */
    List<FllowCuslistDto> selectFllowCuslistList(String cperson_id, BigDecimal xpiont, BigDecimal ypiont, int distance, String ccus_name, int bplan);


    /**
     * 根据不同的条件查询客户级别/客户类型/商品
     * @param ctype
     * @return
     */
    List<EnumdataDto> selectEnumdatasList(String ctype);


    //餐饮业务员下单查询客户
    List<FllowCuslistDto> getFllowCusList(String cperson_id, BigDecimal xpiont, BigDecimal ypiont, int distance, String ccus_name, int bplan);


    /**
     * 查询业务员列表
     * @param ccode
     * @param cname
     * @return
     */
    List<SalesmanDto> selectSalesmanList(String ccode, String cname);



    /**
     * 根据客户类型、客户名称查询客户列表及数量（主要用于主管端）
     * @return
     */
    List<CustomerDto> selectCustomerListcharge(String cperson_id, String ccus_status,String ccus_name,int autoid);


    /**
     * 业务员跟踪
     * @param cfllow_pid
     * @return
     */
    List<PersonDto> selectPersonList(String cfllow_pid);


    /**
     * 添加评论
     * @param autoid
     * @param cuser_id
     * @param cchecktext
     * @return
     */
    List<ResultDto> updateCuslist(int autoid, String cuser_id, String cchecktext);


    /**
     * 增加新的拜访周期
     * @param ccus_cid
     * @param ccus_pid
     * @param ccus_visit_type
     * @param ccus_visit_time
     * @return
     */
    int insertPayvisit( String ccus_cid , String ccus_pid , String ccus_visit_type , String ccus_visit_time);


    /**
     * 删除旧的拜访计划
     * @param ccus_cid
     * @param ccus_pid
     * @return
     */
    int deleteCustomer( String ccus_cid, String ccus_pid);


    /**
     * 查询客户列表（PC 端）
     * @return
     */
    List<SxCustomer> selectCustomerList2(String cperson_id,String ccus_name,String ccus_account,String cperson_name, String ccus_type, String ccus_level,String ccus_visit_type, String icus_visit_time,String ccus_status,String ccompany_id);


    //禁用或启用
    List<ResultDto> updateccusStatus(String customerjson);


    /**
     * 审核客户信息
     * @return
     */
    List<ResultDto> updateAudit(String customerjson);


    /**
     * 查询所有业务员
     * @return
     */
    List<ParameterDto> selectPersonName(String cperson_id);


    /**
     * 查询操作员的级别
     * @param cperson_id
     * @return
     */
    List<String> selectCcompany(String cperson_id);


    /**
     * 删除客户
     * @param autoid
     * @return
     */
    List<ResultDto> delectCustomers(int autoid);


    /**
     * 查询导出表信息
     * @param tables_name
     * @return
     */
    List<LinenameTotal> selectLinenameTotal(String tables_name);


    /**
     * 批量修改商家所属业务员
     * @return
     */
    List<ResultDto> batchUpdate(String customerinfo);


    //查询店铺信息
    List<CustomerDto> selectCustomer(int autoid);

}
