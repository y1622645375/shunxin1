package com.shunxin.shunxin_salesman_visit.dto.clientdto;

import lombok.Data;

@Data
public class TouristDto {
    private int ccus_id;
    private String ccus_name;
    private String ccompany_id;
    private String ccus_level;
    private String ccus_address;
    private String copenid;
    private String ckey;

    @Override
    public String toString() {
        return "TouristDto{" +
                "ccus_id='" + ccus_id + '\'' +
                ", ccus_name='" + ccus_name + '\'' +
                ", ccompany_id='" + ccompany_id + '\'' +
                ", ccus_level='" + ccus_level + '\'' +
                ", ccus_address='" + ccus_address + '\'' +
                '}';
    }
}
