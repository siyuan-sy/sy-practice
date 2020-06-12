package com.sy.common;

import com.alibaba.fastjson.JSON;
import com.sy.controller.BaseController;
import com.sy.pojo.QudjEntiy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class TestClass  extends BaseController {


    public  List<QudjEntiy>  loadzzjgTree(String params){
        Map data = JSON.parseObject(params, Map.class);
        List<Map> maps = JSON.parseArray(data.get("data").toString(), Map.class);
        List<QudjEntiy> values = JSON.parseArray(maps.get(0).get("value").toString(), QudjEntiy.class);
        return  values;
    }

    public  Object  getDzzList(String params) throws  Exception{
        Set<String> set = new HashSet();
        setSet(params, set);
        return  set;
    }

    private  void setSet(String params, Set<String> set) {
        Map data = JSON.parseObject(params, Map.class);
        List<Map> maps = JSON.parseArray(data.get("data").toString(), Map.class);
        List<Map> trs = JSON.parseArray(maps.get(0).get("trs").toString(), Map.class);
        if(trs.size()==1){
            Map map = JSON.parseObject(trs.get(0).get("tds").toString(), Map.class);
            Map dzzdm = JSON.parseObject(map.get("dzzdm").toString(), Map.class);
            Map dwId = JSON.parseObject(map.get("orgId").toString(), Map.class);
            String code = dzzdm.get("value").toString();
            String id = dwId.get("value").toString();
            set.add(code+":"+id);
        }else {
            for (Map vo : trs) {
                {
                    Map map = JSON.parseObject(vo.get("tds").toString(), Map.class);
                    Map dzzdm = JSON.parseObject(map.get("dzzdm").toString(), Map.class);
                    Map dwId = JSON.parseObject(map.get("orgId").toString(), Map.class);
                    String code = dzzdm.get("value").toString();
                    String id = dwId.get("value").toString();
                    if(redisStringUtils.getValue("orgId").equals(id)){
                        set.add(code+":"+id);
                        continue;
                    }

                    /**
                     * 拿每个id去循环调用当前方法,如果size>1 说明还有子级
                     */
                    String result = null;
                    try {
                        redisStringUtils.setKey("orgId",id);
                        result = super.getObject(id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.setSet(result,set);
                }
            }
        }
    }

    public  Object  queryZhcxDzzxx(String params){
        Map data = JSON.parseObject(params, Map.class);
        Map map = JSON.parseObject(data.get("jsonresult").toString(), Map.class);
        List<Map> maps = JSON.parseArray(map.get("data").toString(), Map.class);
        List<Map> trs = JSON.parseArray(maps.get(0).get("trs").toString(), Map.class);
        Map value = JSON.parseObject(trs.get(0).get("tds").toString(), Map.class);
        return  value;
    }



    public  Object  queryZhcxDyxx(String params){
        Map data = JSON.parseObject(params, Map.class);
        Map map = JSON.parseObject(data.get("jsonresult").toString(), Map.class);
        List<Map> maps = JSON.parseArray(map.get("data").toString(), Map.class);
        List<Map> trs = JSON.parseArray(maps.get(2).get("trs").toString(), Map.class);
        //List<Map> values = JSON.parseArray(trs.get(0).get("tds").toString(), Map.class);
        return  trs;
    }




    public static void main(String[] args) {
//        Object dzzList = TestClass.getDzzList(QgdzContext.qudj);
//        System.out.println("dzzList = " + dzzList);
//        Object o = TestClass.queryZhcxDzzxx(QgdzContext.queryZhcxDzzxx);
//        Object o = this.queryZhcxDyxx(QgdzContext.queryZhcxDyxxcopy);
//        System.out.println("o = " + o);

    }

}
