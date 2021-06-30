package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

/**
 * 查询客户数量生成的（全部，活跃，留存）
 */
@Data
public class CustNumberDto {
    private String ccus_pid;
    private int status0;
    private int status1;
    private int status2;
    private int status3;
    private int status9;
    private int status10;
    private int statusall;

    @Override
    public String toString() {
        return "CustNumberDto{" +
                "ccus_pid='" + ccus_pid + '\'' +
                ", status0=" + status0 +
                ", status1=" + status1 +
                ", status2=" + status2 +
                ", status3=" + status3 +
                ", status9=" + status9 +
                ", status10=" + status10 +
                ", statusall=" + statusall +
                '}';
    }
}
