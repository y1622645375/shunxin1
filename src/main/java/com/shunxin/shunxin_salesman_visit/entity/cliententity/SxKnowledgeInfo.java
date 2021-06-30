package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

@Data
public class SxKnowledgeInfo {
    private int kinfo_id;
    private int kbase_id;           //主键ID
    private String kinfo_content;   //知识详情

    @Override
    public String toString() {
        return "SxKnowledgeInfo{" +
                "kinfo_id=" + kinfo_id +
                ", kbase_id=" + kbase_id +
                ", kinfo_content='" + kinfo_content + '\'' +
                '}';
    }
}
