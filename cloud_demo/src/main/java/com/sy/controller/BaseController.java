package com.sy.controller;

import com.alibaba.fastjson.JSON;
import com.sy.common.DataEntity;
import com.sy.common.HttpUtils;
import com.sy.common.PostData;
import com.sy.common.redis.config.RedisStringUtils;
import com.sy.common.QgdzContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseController {
    @Autowired
     protected RedisStringUtils redisStringUtils;

    public String getObject(String orgId) throws IOException {
        String result;
        String accessToken = QgdzContext.accessToken;
        String url = "http://59.231.9.81/gateway-dzz/Dzz001MainCtrl/getDzzList" + "?1=1&access_token=" + accessToken;
        PostData postData = getPostData(orgId);
        String string = JSON.toJSONString(postData);
        result = HttpUtils.httpJsonPost(url,string );
        return result;
    }


    private PostData getPostData(String orgId) {
        PostData postData = new PostData();
        postData.setCtrl("http://59.231.9.81/gateway-dzz/Dzz001MainCtrl/getDzzList");
        List<DataEntity> data = new ArrayList<>();

        data.add(new DataEntity("pageNumStr", "1", "attr"));
        data.add(new DataEntity("orgId", orgId, "attr"));
        data.add(new DataEntity("rowsStr", "15", "attr"));
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("orgId", new JSONObject());

        Map middle = new HashMap();
        Map inner1 = new HashMap();
        inner1.put("value", "");
        middle.put("dzzmc", inner1);

        Map inner2 = new HashMap();
        inner2.put("value", "");
        middle.put("dwxzlbDm", inner2);

        Map inner3 = new HashMap();
        inner3.put("value", "");
        middle.put("sfbhxj", inner3);

        DataEntity dataInner = new DataEntity();
        dataInner.setName("queryForm");
        dataInner.setSword("SwordForm");
        dataInner.setData(middle);
        data.add(dataInner);
        postData.setData(data);
        return postData;
    }
}
