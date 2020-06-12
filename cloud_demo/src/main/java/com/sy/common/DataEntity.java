package com.sy.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Description TODO
 * @Author DingLan
 * @Date 2020/5/19 19:03
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataEntity {
    /**
     * sword : attr
     * name : pageNumber
     * value : 1
     */
    private String sword;
    private String name;
    private String value;
    private String type;
    private Map<String, Map<String, String>> data;
//    private JSONObject data;

    public DataEntity(String name, String value, String sword) {
        this.name = name;
        this.value = value;
        this.sword= sword;
    }
}
