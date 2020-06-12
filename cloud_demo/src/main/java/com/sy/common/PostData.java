package com.sy.common;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author DingLan
 * @Date 2020/5/19 18:58
 **/
@Data
public class PostData {

    /**
     * data : [{"sword":"attr","name":"pageNumber","value":"1"},{"sword":"attr","name":"pageSize","value":"10"},{"sword":"attr","name":"xm","value":""},{"sword":"attr","name":"sfzhm","value":"430621198607045725"},{"sword":"attr","name":"lczx","value":"1"}]
     * ctrl : /gateway-zzgxzj/Zzgxzj005SpwtgCtrl/querySpwtgList
     * bindParam : true
     * tid :
     */
    private List<DataEntity> data;
    private String ctrl;
    private boolean bindParam = true;
    private String tid = "";

}
