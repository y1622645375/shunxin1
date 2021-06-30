package com.shunxin.shunxin_salesman_visit.controller.promotcontroller;

import com.shunxin.shunxin_salesman_visit.dto.promotdto.OrderSubSum;
import com.shunxin.shunxin_salesman_visit.dto.promotdto.SettleAccountDto;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.AmountQuantity;
import com.shunxin.shunxin_salesman_visit.entity.promotentity.SxJsqd;
import com.shunxin.shunxin_salesman_visit.service.BaseApiService;
import com.shunxin.shunxin_salesman_visit.service.checkservice.CheckService;
import com.shunxin.shunxin_salesman_visit.service.clientservice.SxPersonareaService;
import com.shunxin.shunxin_salesman_visit.service.promotservice.SettleAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/settleAccount")
public class SettleAccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SettleAccountService settleAccountService;
    @Autowired
    private SxPersonareaService sxPersonareaService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private BaseApiService baseApiService;


    /**
     * 生成结算清单
     * @return
     */
    @RequestMapping("/createDetailedList")
    public Object createDetailedList(@RequestBody SettleAccountDto settleAccountDto){
        //效验Ckey的三个参数
        String cuserid = settleAccountDto.getCuserid();
        String ckey = settleAccountDto.getCkey();
        int ilogin_type = settleAccountDto.getIlogin_type();
        //正常参数
        String result = "";
        String cpersoncode = settleAccountDto.getCpersoncode();
        String dbegin = settleAccountDto.getDbegin();
        String dend = settleAccountDto.getDend()+" 23:59:59";
        String istate = "00";
        String cmemo = "";
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                int shulian = settleAccountService.selectIstates(cpersoncode);
                if (shulian < 1){
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
                    String today = sdf.format(date);
                    String compand = sxPersonareaService.selectCompand(cpersoncode);
                    String csocode = today+compand+String.format("%04d",new Random().nextInt(9999));
                    int count1 = settleAccountService.selectCjscodes(csocode);
                    while (count1>=1){
                        csocode = today+compand+String.format("%04d",new Random().nextInt(9999));
                        count1 = settleAccountService.selectCjscodes(csocode);
                    }
                    List<AmountQuantity> amountQuantityList = settleAccountService.calculationAmount(cpersoncode,dbegin,dend);
                    for (AmountQuantity quantity : amountQuantityList) {
                        if (quantity!=null){
                            int iquan_sum = quantity.getIquan_sum();
                            Double imoney_sum = quantity.getImoney_sum();

                            Double icashmoney = quantity.getIcashmoney();
                            Double iqrcodemoney = quantity.getIqrcodemoney();
                            OrderSubSum iquantity = settleAccountService.selectOrderSubQuan(cpersoncode,dbegin,dend);
                            Double imoneys_sum = iquantity.getImoneys_sum();
                            int iquans_sum = iquantity.getIquans_sum();
                            SxJsqd sxJsqd = settleAccountService.getCcompands(cpersoncode);
                            String cacc_id = sxJsqd.getCacc_id();
                            String ccompand_id = sxJsqd.getCcompand_id();
                            logger.info("主表金额："+imoney_sum+"子表金额："+imoneys_sum);
                            if (Double.doubleToLongBits(imoney_sum) ==Double.doubleToLongBits(imoneys_sum)){   //主表的金额合计是否等于子表的金额合计
                                if (iquan_sum==iquans_sum){   //主表的数量合计是否等于字表的数量合计
                                    int count = settleAccountService.createDetailedList(csocode,cacc_id,ccompand_id,cpersoncode,dbegin,dend,istate,iquan_sum,imoney_sum,iqrcodemoney,icashmoney,cmemo);
                                    result = count >0 ?"保存成功":"保存失败";
                                    if (result.equals("保存成功")){
                                        int autoid = settleAccountService.selectAutoids(csocode);
                                        settleAccountService.updateOrderCdefine(autoid,cpersoncode,dbegin,dend);
                                    }
                                }else {
                                    result = "数量核算不通过";
                                }
                            }else {
                                result = "金额核算不通过";
                            }
                        }else {
                            result = "无可结算订单";
                        }
                    }
                }else {
                    result = "还有单据未审核，无法生成新单据";
                }
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据工号查询核算的时间
     * @return
     * @return
     */
    @RequestMapping("/selectMinDate")
    public Object selectMinDate(@RequestBody SettleAccountDto settleAccountDto){
        String cpersoncode = settleAccountDto.getCpersoncode();
        try {
            Date ddate = settleAccountService.selectMinDate(cpersoncode);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dendtime = sdf.format(ddate);
            return baseApiService.setResultResultSuccess(dendtime);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询结算清单表
     * @return
     */
    @RequestMapping("/selectSxJsqds")
    public Object selectSxJsqds(@RequestBody SettleAccountDto settleAccountDto){
        String cpersoncode = settleAccountDto.getCpersoncode();
        String istate = settleAccountDto.getIstate();
        String dbegin = settleAccountDto.getDbegin();
        String dend = settleAccountDto.getDend() + " 23:59:59";
        try {
            List<SxJsqd> sxJsqdList = settleAccountService.selectSxJsqds(cpersoncode,istate,dbegin,dend);
            List<SxJsqd> sxJsqdList1 = settleAccountService.getjOrderCount(cpersoncode,istate,dbegin,dend);
            for (SxJsqd sxJsqd : sxJsqdList1) {
                sxJsqdList.add(sxJsqd);
            }
            return baseApiService.setResultResultSuccess(sxJsqdList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 查询未生成结算清单的订单
     * @return
     */
    @RequestMapping("/selectJsqdOrders")
    public Object selectJsqdOrders(@RequestBody SettleAccountDto settleAccountDto){
        String cpersoncode = settleAccountDto.getCpersoncode();
        String dbegin = settleAccountDto.getDbegin();
        String dend = settleAccountDto.getDend();
        String dend2 = dend +" 23:59:59";
        try {
            List<SxJsqd> sxJsqdList = settleAccountService.selectJsqdOrders(cpersoncode,dbegin,dend2);
            List<SxJsqd> sxJsqdList1 = settleAccountService.getJsOrderSum(cpersoncode,dbegin,dend2);
            for (SxJsqd sxJsqd : sxJsqdList1) {
                sxJsqdList.add(sxJsqd);
            }
            return baseApiService.setResultResultSuccess(sxJsqdList);
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }


    /**
     * 根据工号查询结算单号
     * @return
     */
    @RequestMapping("/insertRemoteprints")
    public Object insertRemoteprints(@RequestBody SettleAccountDto settleAccountDto){
        String cuserid = settleAccountDto.getCuserid();
        String ckey = settleAccountDto.getCkey();
        int ilogin_type = settleAccountDto.getIlogin_type();
        String result = "";
        String cpersoncode = settleAccountDto.getCpersoncode();    //工号
        String ccomputer = settleAccountDto.getCcomputer();        //电脑名称
        try {
            String results2 = checkService.charmKeyValidity(cuserid,ckey,ilogin_type);
            if (results2.equals("1")){
                String cjcodeStr = settleAccountService.getCjcodeStr(cpersoncode);   //根据工号查询未打印的结算单号
                int exist = settleAccountService.selectOpenrowset(cjcodeStr);        //判断该结算单号是否存在
                if (exist>0){
                    result = "该单号已打印，无法再次打印";
                }else {
                    if (cjcodeStr!=null&&!cjcodeStr.equals("")){
                        int count = settleAccountService.insertRemoteprints(cjcodeStr,cpersoncode,ccomputer);
                        result = count>0 ?"保存成功":"保存失败";
                    }else {
                        result = "未生成结算单号，无法打印";
                    }
                }
                return baseApiService.setResultResultSuccess(result);
            }else {
                return baseApiService.setResultResultSuccess("服务器繁忙中...");
            }
        }catch (Exception e){
            e.printStackTrace();
            return baseApiService.setResultError(e.toString());
        }
    }






}
