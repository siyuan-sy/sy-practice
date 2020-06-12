package com.sy.controller;

import com.alibaba.fastjson.JSON;
import com.sy.common.*;
import com.sy.pojo.QudjEntiy;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/test")
@RestController
public class TestController extends BaseController {

    @Autowired
    TestClass testClass;


    @Autowired
    private StringRedisTemplate template;

    /**
     * 拿到组织树
     *
     * @return
     */
    @PostMapping("/loadzzjgTree")
    public List<QudjEntiy> loadzzjgTree() {
        List<QudjEntiy> list = new ArrayList<>();
        String result = null;
        try {
            String accessToken = "b40d3ad1-ed1d-47ec-bb41-5c41acf69191";
            String url = "http://59.231.9.81/gateway-dzz/Dzz001MainCtrl/loadzzjgTree?" + "?1=1&access_token=" + accessToken;
            result = HttpUtils.httpJsonPost(url, "");

            if (Strings.isNullOrEmpty(result)) {
                return list;
            } else {
                list = testClass.loadzzjgTree(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 根据组织id查询下级组织
     *
     * @return
     */
    @PostMapping("/getDzzList")
    public Object getDzzList(@RequestParam("orgId") String orgId) throws Exception {
        List<Map> list = new ArrayList<>();
        Object obj = null;
        String result = null;
        try {
            redisStringUtils.setKey("orgId",orgId);
            result = getObject(orgId);
            obj = testClass.getDzzList(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }


    /**
     * 根据组织id或组织编码查询组织详情
     *
     * @param orgId
     * @param code
     * @return
     */
    @PostMapping("/queryZhcxDzzxx")
    public Object queryZhcxDzzxx(@RequestParam(value = "orgId", required = false, defaultValue = "") String orgId, @RequestParam(value = "code", required = false, defaultValue = "") String code) {
        List<Map> list = new ArrayList<>();
        Map map = null;
        String result = null;
        try {
            String accessToken = QgdzContext.accessToken;
            String url = "http://59.231.9.81/gateway-xtgl/Xtgl004ZhcxCtrl/queryZhcxDzzxx" + "?1=1&access_token=" + accessToken;
            PostData postData = getQueryZhcxDzzxxData(orgId, code);

            result = HttpUtils.httpJsonPost(url, JSON.toJSONString(postData));
            map = (Map) testClass.queryZhcxDzzxx(result);
          /*  if (Strings.isNullOrEmpty(result)) {
                return list;
            } else {
                list = TestClass.getDzzList(result);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据组织id查询党员列表
     *
     * @param orgId
     * @param code
     * @return
     */
    @PostMapping("/queryZhcxDyxx")
    public Object queryZhcxDyxx(@RequestParam(value = "orgId", required = false, defaultValue = "") String orgId, @RequestParam(value = "code", required = false, defaultValue = "") String code) {
        List<Map> list = new ArrayList<>();
        Map maps = null;
        String result = null;
        try {
            String accessToken = QgdzContext.accessToken;
            String url = "http://59.231.9.81/gateway-xtgl/Xtgl004ZhcxCtrl/queryZhcxDyxx" + "?1=1&access_token=" + accessToken;
            System.out.println("url = " + url);
            PostData postData = getQueryZhcxDyxxData(orgId, code);
            String string = JSON.toJSONString(postData);
            result = HttpUtils.httpJsonPost(url, string);
            list = (List<Map>) testClass.queryZhcxDyxx(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    private PostData getQueryZhcxDyxxData(String orgId, String code) {
        PostData postData = new PostData();
        postData.setCtrl("/gateway-xtgl/Xtgl004ZhcxCtrl/queryZhcxDyxx");
        List<DataEntity> data = new ArrayList<>();
        Map middle = new HashMap();
        Map inner1 = new HashMap();
        inner1.put("value", "");
        middle.put("dzzfwKey", inner1);

        Map inner2 = new HashMap();
        inner2.put("value", orgId);
        middle.put("orgId", inner2);

        Map inner3 = new HashMap();
        inner3.put("value", "中国共产党吉首市石家冲街道机关支部委员会");
        middle.put("dzzfwValue", inner3);

        Map inner4 = new HashMap();
        inner4.put("value", "");
        middle.put("xmKey", inner4);

        Map inner5 = new HashMap();
        inner5.put("value", "");
        middle.put("xm", inner5);

        Map inner6 = new HashMap();
        inner6.put("value", "");
        middle.put("xbKey", inner6);

        Map inner7 = new HashMap();
        inner7.put("value", "");
        middle.put("xbDm", inner7);

        Map inner8 = new HashMap();
        inner8.put("value", "");
        middle.put("sfzhmKey", inner8);

        Map inner9 = new HashMap();
        inner9.put("value", code);
        middle.put("sfzhm", inner9);

        Map inner10 = new HashMap();
        inner10.put("value", "");
        middle.put("nlKey", inner10);

        Map inner11 = new HashMap();
        inner11.put("value", "");
        middle.put("nlqValue", inner11);

        Map inner12 = new HashMap();
        inner12.put("value", "");
        middle.put("nlzValue", inner12);

        Map inner13 = new HashMap();
        inner13.put("value", "");
        middle.put("gzgwKey", inner13);

        Map inner14 = new HashMap();
        inner14.put("value", "");
        middle.put("gzgwDm", inner14);

        Map inner15 = new HashMap();
        inner15.put("value", "");
        middle.put("sfldKey", inner15);

        Map inner16 = new HashMap();
        inner16.put("value", "");
        middle.put("sfld", inner16);

        Map inner17 = new HashMap();
        inner17.put("value", "");
        middle.put("mzKey", inner17);

        Map inner18 = new HashMap();
        inner18.put("value", "");
        middle.put("mzDm", inner18);

        Map inner19 = new HashMap();
        inner19.put("value", "");
        middle.put("dwxzKey", inner19);

        Map inner20 = new HashMap();
        inner20.put("value", "");
        middle.put("dwxzDm", inner20);

        Map inner21 = new HashMap();
        inner21.put("value", "");
        middle.put("rylbKey", inner21);

        Map inner22 = new HashMap();
        inner22.put("value", "");
        middle.put("dylbDm", inner22);

        Map inner23 = new HashMap();
        inner23.put("value", "");
        middle.put("dyztKey", inner23);

        Map inner24 = new HashMap();
        inner24.put("value", "");
        middle.put("dyztDm", inner24);

        Map inner25 = new HashMap();
        inner25.put("value", "");
        middle.put("xlKey", inner25);

        Map inner26 = new HashMap();
        inner26.put("value", "");
        middle.put("xlDm", inner26);

        Map inner27 = new HashMap();
        inner27.put("value", "");
        middle.put("dbwyKey", inner27);

        Map inner28 = new HashMap();
        inner28.put("value", "");
        middle.put("ldbywyDm", inner28);

        Map inner29 = new HashMap();
        inner29.put("value", "");
        middle.put("sfslKey", inner29);


        Map inner30 = new HashMap();
        inner30.put("value", "");
        middle.put("sfsl", inner30);


        Map inner31 = new HashMap();
        inner31.put("value", "");
        middle.put("rdrqKey", inner31);


        Map inner32 = new HashMap();
        inner32.put("value", "");
        middle.put("qsTime", inner32);


        Map inner33 = new HashMap();
        inner33.put("value", "");
        middle.put("zsTime", inner33);

        DataEntity dataInner = new DataEntity();
        dataInner.setName("dyform");
        dataInner.setSword("SwordForm");
        dataInner.setData(middle);
        data.add(dataInner);
        postData.setData(data);
        return postData;
    }


    private PostData getQueryZhcxDzzxxData(String orgId, String code) {
        PostData postData = new PostData();
        postData.setCtrl("http://59.231.9.81/gateway-xtgl/Xtgl004ZhcxCtrl/queryZhcxDzzxx");
        List<DataEntity> data = new ArrayList<>();
        Map middle = new HashMap();
        Map inner1 = new HashMap();
        inner1.put("value", "");
        middle.put("dzzfwKey", inner1);

        Map inner2 = new HashMap();
        inner2.put("value", orgId);
        middle.put("orgId", inner2);

        Map inner3 = new HashMap();
        inner3.put("value", "");
        middle.put("dzzfwValue", inner3);

        Map inner4 = new HashMap();
        inner4.put("value", "");
        middle.put("dzzmcKey", inner4);

        Map inner5 = new HashMap();
        inner5.put("value", "");
        middle.put("dzzmcValue", inner5);

        Map inner6 = new HashMap();
        inner6.put("value", "");
        middle.put("dzzDmKey", inner6);

        Map inner7 = new HashMap();
        inner7.put("value", code);
        middle.put("dzzDmValue", inner7);

        Map inner8 = new HashMap();
        inner8.put("value", "");
        middle.put("dzzdsgxKey", inner8);

        Map inner9 = new HashMap();
        inner9.put("value", "");
        middle.put("dzzsdgxDm", inner9);

        Map inner10 = new HashMap();
        inner10.put("value", "");
        middle.put("zzlbKey", inner10);

        Map inner11 = new HashMap();
        inner11.put("value", "");
        middle.put("zzlbDm", inner11);

        Map inner12 = new HashMap();
        inner12.put("value", "");
        middle.put("dzzgzflKey", inner12);

        Map inner13 = new HashMap();
        inner13.put("value", "");
        middle.put("dzzdwxzlbDm", inner13);

        Map inner14 = new HashMap();
        inner14.put("value", "");
        middle.put("dzbrs", inner14);

        Map inner15 = new HashMap();
        inner15.put("value", "");
        middle.put("dzbrsStartValue", inner15);

        Map inner16 = new HashMap();
        inner16.put("value", "");
        middle.put("dzbrsEndValue", inner16);

        DataEntity dataInner = new DataEntity();
        dataInner.setName("dzzform");
        dataInner.setSword("SwordForm");
        dataInner.setData(middle);
        data.add(dataInner);
        postData.setData(data);
        return postData;
    }


    @PostMapping("/login")
    public String log() throws IOException {
        PostData postData = new PostData();
        postData.setCtrl("/gateway-xtgl/Mh001LoginCtrl/handleLogins");
        List<DataEntity> data = new ArrayList<>();

        data.add(new DataEntity("userName", "hn000428", "attr"));
        data.add(new DataEntity("userPwd", "jss_8520", "attr"));
        postData.setData(data);
        Map map = new HashMap();
        //返回access_token或者空字符串
        String jsonString = JSON.toJSONString(postData);
        System.out.println("jsonString = " + jsonString);
        String url = "http://59.231.9.81/gateway-xtgl/Mh001LoginCtrl/handleLogins?1=1";
        map.put("postData", jsonString);
        String result = HttpUtils.httpFormPost(url, map);
        return result;
    }
}
