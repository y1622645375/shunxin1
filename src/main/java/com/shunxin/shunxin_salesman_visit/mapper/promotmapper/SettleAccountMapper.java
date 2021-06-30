package com.shunxin.shunxin_salesman_visit.mapper.promotmapper;

import com.shunxin.shunxin_salesman_visit.dto.promotdto.OrderSubSum;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.AmountQuantity;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SettleDetailed;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SxJsqd;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SettleAccountMapper {


    //生成结算清单
    int createDetailedList(@Param("cjscode") String cjscode,@Param("cacc_id") String cacc_id,@Param("ccompand_id") String ccompand_id,@Param("cpersoncode") String cpersoncode,@Param("dbegin") String dbegin,
                           @Param("dend") String dend,@Param("istate") String istate,@Param("iquan") int iquan,@Param("imoney") Double imoney,
                           @Param("iqrmoney") Double iqrmoney,@Param("ixjmoney") Double ixjmoney,@Param("cmemo") String cmemo);


    //根据工号查询所属公司和账套
    SxJsqd getCcompands(@Param("cperson_id") String cperson_id);


    //检查该业务员是否有未审核的账单
    int selectIstates(@Param("cpersoncode") String cpersoncode);


    //查询账单
    List<SettleDetailed> selectOrderDetailed(@Param("cperson_id") String cperson_id,@Param("dbegin") String dbegin,@Param("dend") String dend);



    //核对数量和金额
    List<AmountQuantity> calculationAmount(@Param("cperson_id") String cperson_id,@Param("dbegin") String dbegin,@Param("dend") String dend);


    //查询子表的数据合计
    OrderSubSum selectOrderSubQuan(@Param("cperson_id") String cperson_id, @Param("dbegin") String dbegin, @Param("dend") String dend);


    //生成过结算清单的订单做好记号
    int updateOrderCdefine(@Param("autoid") int autoid,@Param("cperson_id") String cperson_id,@Param("dbegin") String dbegin,@Param("dend") String dend);


    //查询清单号是否存在
    int selectCjscodes(@Param("cjscode") String cjscode);


    //根据清单号查询autoid
    int selectAutoids(@Param("cjscode") String cjscode);


    //根据工号查询核算的时间
    Date selectMinDate(@Param("cperson_id") String cperson_id);


    //查询结算清单表
    List<SxJsqd> selectSxJsqds(@Param("cpersoncode") String cpersoncode,@Param("istate") String istate,@Param("dbegin") String dbegin,@Param("dend") String dend);



    //查询核算订单的合计
    List<SxJsqd> getjOrderCount(@Param("cpersoncode") String cpersoncode,@Param("istate") String istate,@Param("dbegin") String dbegin,@Param("dend") String dend);


    //查询未生成结算清单的订单
    List<SxJsqd> selectJsqdOrders(@Param("cperson_id") String cperson_id,@Param("dbegin") String dbegin,@Param("dend") String dend);


    //查询订单合计
    List<SxJsqd> getJsOrderSum(@Param("cperson_id") String cperson_id,@Param("dbegin") String dbegin,@Param("dend") String dend);


    //根据工号查询未打印的结算单号
    String getCjcodeStr(@Param("cpersoncode") String cpersoncode);


    //扫码之后写入日志
    int insertRemoteprints(@Param("ccode") String ccode,@Param("cuser_id") String cuser_id,@Param("ccomputer") String ccomputer);


    //查询该结算单号是否存在
    int selectOpenrowset(@Param("ccode") String ccode);


}
