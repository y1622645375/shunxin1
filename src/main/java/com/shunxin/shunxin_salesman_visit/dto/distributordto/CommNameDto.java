package com.shunxin.shunxin_salesman_visit.dto.distributordto;

import lombok.Data;

import java.util.List;

@Data
public class CommNameDto {
    private List<String> cinvname;

    @Override
    public String toString() {
        return "CommNameDto{" +
                "cinvname='" + cinvname + '\'' +
                '}';
    }
}
