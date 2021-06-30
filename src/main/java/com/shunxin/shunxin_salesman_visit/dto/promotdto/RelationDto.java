package com.shunxin.shunxin_salesman_visit.dto.promotdto;


import lombok.Data;

@Data
public class RelationDto {
    private String jsonvist;
    private String copenid;
    private String ccode;
    private String wxopenid;

    @Override
    public String toString() {
        return "RelationDto{" +
                "jsonvist='" + jsonvist + '\'' +
                ", copenid='" + copenid + '\'' +
                ", ccode='" + ccode + '\'' +
                ", wxopenid='" + wxopenid + '\'' +
                '}';
    }
}
