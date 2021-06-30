package com.shunxin.shunxin_salesman_visit.mapper.clientmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.LinenameTotal;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.SxCustomer;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SxCustomerMapper {

    /**
     * 根据客户类型、客户名称查询客户列表（包含模糊查询）
     * @param ccus_status
     * @param ccus_name
     * @return
     */
    List<SxCustomer> selectCustomerList(@Param("cperson_id") String cperson_id, @Param("ccus_status") String ccus_status, @Param("ccus_name") String ccus_name, @Param("autoid") int autoid);


    /**
     * 根据业务员ID查询其负责商家的数量
     * @param cperson_id
     * @return
     */
     CustNumberDto selectCustomerCount(@Param("cperson_id") String cperson_id);


    /**
     * 新增或修改客户信息
     * @return
     */
    List<ResultDto> insertCustomer(String jsonvisit);


    //查询今日拜访客户列表
    List<FllowCuslistDto> selectFllowCuslistList(@Param("cperson_id") String cperson_id, @Param("xpiont") BigDecimal xpiont, @Param("ypiont") BigDecimal ypiont,
                                                 @Param("distance") int distance, @Param("ccus_name") String ccus_name, @Param("bplan") int bplan);


    //根据不同的条件查询客户级别/客户类型/商品
    List<EnumdataDto> selectEnumdatasList(String ctype);


    //餐饮业务员下单查询客户
    List<FllowCuslistDto> getFllowCusList(@Param("cperson_id") String cperson_id, @Param("xpiont") BigDecimal xpiont, @Param("ypiont") BigDecimal ypiont,
                                          @Param("distance") int distance, @Param("ccus_name") String ccus_name, @Param("bplan") int bplan);


    //查询业务员列表
    List<SalesmanDto> selectSalesmanList(@Param("ccode") String ccode,@Param("cname") String cname);


    //根据客户类型、客户名称查询客户列表及数量（主要用于主管端）
    List<CustomerDto> selectCustomerListcharge(@Param("cperson_id") String cperson_id, @Param("ccus_status") String ccus_status, @Param("ccus_name") String ccus_name, @Param("autoid") int autoid);


    //业务员跟踪
    List<PersonDto> selectPersonList(String cfllow_pid);


    /**
     * 添加评论
     * @param autoid
     * @param cuser_id
     * @param cchecktext
     * @return
     */
    List<ResultDto> updateCuslist(@Param("autoid") int autoid,@Param("cuser_id") String cuser_id,@Param("cchecktext") String cchecktext);


    /**
     * 增加新的拜访周期
     * @param ccus_cid
     * @param ccus_pid
     * @param ccus_visit_type
     * @param ccus_visit_time
     * @return
     */
    int insertPayvisit(@Param("ccus_cid") String ccus_cid ,@Param("ccus_pid") String ccus_pid ,@Param("ccus_visit_type") String ccus_visit_type ,@Param("ccus_visit_time") String ccus_visit_time);


    /**
     * 删除旧的拜访计划
     * @param ccus_cid
     * @param ccus_pid
     * @return
     */
    int deleteCustomer(@Param("ccus_cid") String ccus_cid,@Param("ccus_pid") String ccus_pid);


    /**
     * 查询客户列表（PC 端）
     * @return
     */
    List<SxCustomer> selectCustomerList2(@Param("cperson_id")String cperson_id,@Param("ccus_name")String ccus_name,@Param("ccus_account")String ccus_account,@Param("cperson_name")String cperson_name,
                                         @Param("ccus_type") String ccus_type,@Param("ccus_level") String ccus_level,@Param("ccus_visit_type") String ccus_visit_type,@Param("icus_visit_time") String icus_visit_time,
                                         @Param("ccus_status") String ccus_status,@Param("ccompany_id") String ccompany_id);


    //禁用或启用
    List<ResultDto> updateccusStatus(@Param("customerjson") String customerjson);


    /**
     * 审核客户信息
     * @return
     */
    List<ResultDto> updateAudit(@Param("customerjson") String customerjson);


    /**
     * 查询该人员所属公司的所有在职人员
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
    List<ResultDto> delectCustomers(@Param("autoid") int autoid);


    /**
     * 查询导出表信息
     * @param tables_name
     * @return
     */
    List<LinenameTotal> selectLinenameTotal(String tables_name);


    //批量修改商家所属业务员
    List<ResultDto> batchUpdate(String customerinfo);



    //查询单个店铺信息
    List<CustomerDto> selectCustomer(@Param("autoid") int autoid);


}
