package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class ExpirationTimeDto {
    private String cuser_id;


    @Override
    public String toString() {
        return "ExpirationTimeDto{" +
                "cuser_id='" + cuser_id + '\'' +
                '}';
    }
}
