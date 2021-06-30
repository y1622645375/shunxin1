package com.shunxin.shunxin_salesman_visit.mapper.clientmapper;

import com.shunxin.shunxin_salesman_visit.dto.clientdto.*;
import com.shunxin.shunxin_salesman_visit.entity.cliententity.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SxPersonareaMapper {

    //根据业务员ID查询其所属公司
    String selectCompand(String cuser_id);


    //查询A 表中某公司已录点业务员
    List<ParameterDto> selectCuserTemp(String cuser_id);


    //增加A 表数据
    int insertPersonareaTemp(@Param("ccompand_id") String ccompand_id,@Param("cuser_id") String cuser_id,@Param("xpoint") BigDecimal xpoint,
                         @Param("ypoint") BigDecimal ypoint,@Param("param1") String param1);


    //查询A 表中该业务员的信息是否已经存在
    int selectExistTemp(@Param("cuser_id") String cuser_id,@Param("param1") String param1);


    //删查A 表中某业务员的数据
    int delectPersonareaTemp(String cuser_id);


    //查询B 表中某公司已录点业务员
    List<ParameterDto> selectCuser(String cuser_id);


    //增加B 表数据
    int insertPersonarea(@Param("ccompand_id") String ccompand_id,@Param("cuser_id") String cuser_id,@Param("xpoint") BigDecimal xpoint,
                             @Param("ypoint") BigDecimal ypoint, @Param("param1") String param1);


    //查询B 表中该业务员的信息是否已经存在
    int selectExist(@Param("cuser_id") String cuser_id);


    //删查B 表中某业务员的数据
    int delectPersonarea(String cuser_id);


    //复制A表数据到B表
    int duplication(String cuser_id);


    //查询A表中某业务员的所有点
    List<SxPersonarea> selectCusersTemp(String cuser_id);


    //查询B表中某业务员的所有点
    List<SxPersonarea> selectCusers(String cuser_id);


    //查询A表第一个点和最后一个点
    List<SxPersonarea> selectDistance(String cuser_id);


    //查询B表第一个点和最后一个点
    List<SxPersonarea> selectDistance2(String cuser_id);


    //查询B表中所有业务员的表
    List<SxPersonarea> selectAllCusers();


    //查询业务员区域的中心点
    List<SxPersonarea> selectCenterPoint(@Param("cuser_id") String cuser_id);


    //在最小列的后面加上总列数
    int updateParam2(@Param("cuser_id") String cuser_id,@Param("param2") String param2);


    //查询所有业务员
    List<ParameterDto> getPersonList(@Param("ccomcode") String ccomcode,@Param("cdepcode") String cdepcode,
                                     @Param("ccode") String ccode,@Param("cname") String cname);


    //检查userid和ckey是否合法
    int detectionKey(@Param("ckey") String ckey,@Param("userid") String userid);


    //查询前五条订单
    List<SxOrderInfo> getOrderList(@Param("userid") String userid,@Param("csocode") String csocode);


    //查询单个信息
    List<OrdervDto> getOrderOne(String csocode);


    //根据客户编号查询客户所属公司
    SxCustomer getCustomerPanyID(@Param("autoid") String autoid);


    //获取客户允许绑定微信数量
    String getInformCvalues(@Param("cname") String cname);


    //判断查询人绑定的客户是否和被查询的客户一致
    int getTomerWxbind(@Param("ccusid") String ccusid,@Param("copenid") String copenid);


    //判断被查看客户是否已绑定
    int getCcusidBind(@Param("ccusid") String ccusid);



    //通过客户ID查询微信openid
    List<SxcustomerWxbind> selectCopenid(@Param("ccusid") String ccusid);


    //查询游客信息
    List<TouristDto> selectTouristInfo();


    //增加打印的日志文件
    int increaseLog(@Param("userid") String userid,@Param("csocode") String csocode);


    //在临时表中绑定openid
    int bindingOPenid(@Param("openid") String openid,@Param("ccode") String ccode,@Param("md5str") String md5str);


    //通过md5查询openid和code
    List<WeixinDto> selectOderOpen(@Param("md5str") String md5str);


    //查询openid是否已经绑定过
    List<SxcustomerWxbind> selectWxbindOpenid(@Param("copenid") String copenid);


    //通过openid查询已绑定的客户信息
    List<SxcustomerWxbind> selectWxbindOpenid2(@Param("copenid") String copenid);


    //先将所有的默认改为0
    int updateDbefault(@Param("copenid") String copenid);


    //再将选择的店铺设置为默认
    int updateDbefault2(@Param("copenid") String copenid,@Param("ccusid") String ccusid);


    //查询店铺绑定的微信数量
    int selectCcusid(@Param("ccusid") String ccusid);


    //绑定店铺信息
    int insertCustomerWx(@Param("ccusid") String ccusid,@Param("copenid") String copenid,@Param("cunitid") String cunitid);


    //绑定成功之后删除临时表中的数据
    int delectWxbind(@Param("openid") String openid);


    //清除所有七天以前的记录
    int deleteWxDate();


    //新增公众号token
    int insertGztoken(@Param("access_token") String access_token);


    //更新公众号token
    int updateGztoken(@Param("access_token") String access_token);


    //校验当前token是否在有效期内
    int validationDEXTIME();


    //查询公众号token是否存在
    String selectGztoken();


    //新增企业微信token
    int insertQytoken(@Param("cuser_id") String cuser_id, @Param("access_token") String access_token);


    //更新企业微信token
    int updateQytoken(@Param("access_token") String access_token,@Param("cuser_id") String cuser_id);


    //校验当前企业微信token是否在有效期内
    int validtionQytoken(@Param("cuser_id") String cuser_id);


    //查询企业微信token是否存在
    String selectQytoken(@Param("cuser_id") String cuser_id);


    //查询订单打印记录
    List<PrintLogDto> selectPrintlog(@Param("ddate") String ddate,@Param("cperson_id") String cperson_id,@Param("ccomcode") String ccomcode);


    //查询订单列表，主要用于公众号中商家查询自己的订单
    List<OrdervDto> selectOrdervList(@Param("ccus_id") String ccus_id,@Param("ddate2") String ddate2,@Param("csocode") String csocode,@Param("cso_state") String cso_state);


    //获取订单状态  1 已付款 0 未付款
    int getOrderStatus(@Param("csocode") String csocode);


    //存储年会二维码的openid
    int insertMd5OpenID(@Param("openid") String openid,@Param("md5str") String md5str);


    //判断openid是否已经存在
    String judgeOpenid(@Param("md5str") String md5str);


    //新增业务员的范围点
    List<ResultDto> addPersonDot(@Param("jsonvisit") String jsonvisit);


    //通过openid和客户ID换取Ckey
    wxlogindataDto exchangeCkey(@Param("cuser_id") String cuser_id,@Param("copenid") String copenid);


    //查询订单的赠品
    List<SxOrderGift> getSxOrderGift(@Param("autoid") int autoid);

}
