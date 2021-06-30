package com.shunxin.shunxin_salesman_visit.service.promotservice;

import com.shunxin.shunxin_salesman_visit.dto.promotdto.OrderSubSum;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.AmountQuantity;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SettleDetailed;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SxJsqd;

import java.util.Date;
import java.util.List;

public interface SettleAccountService {


    //生成结算清单
    int createDetailedList(String cjscode,String cacc_id,String ccompand_id,String cpersoncode,String dbegin,String dend, String istate,int iquan, Double imoney,
                           Double iqrmoney, Double ixjmoney, String cmemo);


    //根据工号查询所属公司和账套
    SxJsqd getCcompands(String cperson_id);


    //检查该业务员是否有未审核的账单
    int selectIstates(String cpersoncode);


    //查询账单
    List<SettleDetailed> selectOrderDetailed(String cperson_id, String dbegin, String dend);


    //核对数量和金额
    List<AmountQuantity> calculationAmount(String cperson_id,String dbegin, String dend);


    //查询子表的数据合计
    OrderSubSum selectOrderSubQuan(String cperson_id, String dbegin, String dend);


    //生成过结算清单的订单做好记号
    int updateOrderCdefine(int autoid,String cperson_id,String dbegin,String dend);


    //查询清单号是否存在
    int selectCjscodes(String cjscode);


    //根据清单号查询autoid
    int selectAutoids(String cjscode);


    //根据工号查询核算的时间
    Date selectMinDate(String cperson_id);


    //查询结算清单表
    List<SxJsqd> selectSxJsqds(String cpersoncode, String istate, String dbegin, String dend);


    //查询核算订单的合计
    List<SxJsqd> getjOrderCount(String cpersoncode, String istate, String dbegin, String dend);


    //查询未生成结算清单的订单
    List<SxJsqd> selectJsqdOrders(String cperson_id,String dbegin,String dend);


    //查询订单合计
    List<SxJsqd> getJsOrderSum(String cperson_id,String dbegin,String dend);


    //根据工号查询未打印的结算单号
    String getCjcodeStr(String cpersoncode);


    //扫码之后写入日志
    int insertRemoteprints(String ccode,String cuser_id,String ccomputer);


    //查询该结算单号是否存在
    int selectOpenrowset(String ccode);
}
