package com.shunxin.shunxin_salesman_visit.util;


import com.shunxin.shunxin_salesman_visit.controller.CheckController.CheckController;
import com.shunxin.shunxin_salesman_visit.controller.CheckController.PunchController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PrinTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private PunchController punchController;
    @Resource
    private CheckController checkController;


    // 获取上班数据，每天 10:30 定时执行
    // ctype:  BeOnDuty 上班，OffDuty 下班
    /*@Scheduled(cron = "00 30 10 * * ?")
    public void cron() throws Exception{
        logger.info("获取上班数据："+new Date(System.currentTimeMillis()));
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long datetime =zero/1000;
        long starttime=datetime+5*60*60;  //当天时间5点的时间戳
        long endtime = datetime+10*60*60;  //当天时间10点的时间戳
        punchController.getCheckinData("3",starttime,endtime,"BeOnDuty");
    }

    //获取上班数据5分钟后推送消息
    @Scheduled(cron = "00 35 10 * * ?")
    public void crone() throws Exception{
        logger.info("发送上班数据："+new Date(System.currentTimeMillis()));
        CallUrl.sendPost("http://emall.hnsxtj.com/sendmsg.php?userid=01003&cpocode=123456&" +
                "logs=今日上班打卡情况，请点击查看详情http://emall.hnsxtj.com/temp/attendanceTj.html?userid=01003&ctype=free","");
        CallUrl.sendPost("http://emall.hnsxtj.com/sendmsg.php?userid=01004&cpocode=123456&" +
                "logs=今日上班打卡情况，请点击查看详情http://emall.hnsxtj.com/temp/attendanceTj.html?userid=01004&ctype=free","");
    }

    // 每月给每个人发送自己的考勤记录
    // 每月10点50执行
    @Scheduled(cron = "0 50 10 28-31 * ?")
    public void ClockIn() throws Exception{
        final Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
            //是最后一天
            System.out.println("执行任务");
            checkController.getWorkcheckRecordList();
        }
    }

    // 获取中午10点至下午16点上下班的数据，每天 16:00 定时执行
    // ctype:  BeOnDuty 上班，OffDuty 下班
    @Scheduled(cron = "00 00 16 * * ?")
    public void cron5() throws Exception{
        logger.info("获取上班数据："+new Date(System.currentTimeMillis()));
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long datetime =zero/1000;
        long starttime=datetime+10*60*60;  //当天时间10点的时间戳
        long endtime = datetime+16*60*60;  //当天时间16点的时间戳
        punchController.getCheckinData("3",starttime,endtime,"BeOnDuty");
        punchController.getCheckinData("3",starttime,endtime,"OffDuty");
    }


     //获取下班数据，周一至周六 23:00 定时执行
     //ctype: BeOnDuty 上班，OffDuty 下班
    @Scheduled(cron = "00 00 23 * * ?")
    public void cron2() throws Exception{
        logger.info("获取下班数据："+new Date(System.currentTimeMillis()));
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long datetime =zero/1000;
        long starttime=datetime+16*60*60;  //当天时间16点的时间戳
        long endtime = datetime+23*60*60;  //当天时间23点的时间戳
        punchController.getCheckinData("3",starttime,endtime,"OffDuty");
    }


    //获取全天的打卡数据，以防特殊情况导致未获取到数据
    //ctype: BeOnDuty 上班，OffDuty 下班
    @Scheduled(cron = "00 30 23 * * ?")
    public void cron6() throws Exception{
        logger.info("获取下班数据："+new Date(System.currentTimeMillis()));
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long datetime =zero/1000;
        long starttime=datetime+5*60*60;  //当天时间5点的时间戳
        long endtime = datetime+23*60*60;  //当天时间23点的时间戳
        punchController.getCheckinData("3",starttime,endtime,"BeOnDuty");
        punchController.getCheckinData("3",starttime,endtime,"OffDuty");
    }


    //每天00:50将未配送完成的订单重新划至新订单
    @Scheduled(cron = "00 50 00 * * ?")
    public void cron3() throws Exception{
        logger.info("每天00:50将未配送完成的订单重新划至新订单："+new Date(System.currentTimeMillis()));
        punchController.clearUpOrder();
    }*/


    /**
     * 23:00:00 读取log表中的数据，写入到企业微信
     * @throws Exception
     */
    /*@Scheduled(cron = "00 00 23 * * ?")
    public void cron4() throws Exception{
        logger.info("每天23:00:00 读取log表中的数据，写入到企业微信："+new Date(System.currentTimeMillis()));
        checkController.changeCheckClass();
    }*/




}
