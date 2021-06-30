package com.shunxin.shunxin_salesman_visit.entity.cliententity;

import lombok.Data;

@Data
public class LinenameTotal {
    private int column_id;
    private String column_name;
    private int column_width;
    private String column_color;
    private int column_order;
    private String tables_name;
    private String column_value;

    @Override
    public String toString() {
        return "LinenameTotal{" +
                "column_id=" + column_id +
                ", column_name='" + column_name + '\'' +
                ", column_width=" + column_width +
                ", column_color='" + column_color + '\'' +
                ", column_order=" + column_order +
                ", tables_name='" + tables_name + '\'' +
                ", column_value='" + column_value + '\'' +
                '}';
    }
}
