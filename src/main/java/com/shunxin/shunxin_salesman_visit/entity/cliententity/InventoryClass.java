package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

/**
 * 商品分类表
 */
@Data
public class InventoryClass {
    private String cInvCCode;  //商品分类编号
    private String cInvCName;  //商品分类名称

    public InventoryClass(String cInvCCode, String cInvCName) {
        this.cInvCCode = cInvCCode;
        this.cInvCName = cInvCName;
    }

    public InventoryClass() {

    }

    @Override
    public String toString() {
        return "InventoryClass{" +
                "cInvCCode='" + cInvCCode + '\'' +
                ", cInvCName='" + cInvCName + '\'' +
                '}';
    }
}
