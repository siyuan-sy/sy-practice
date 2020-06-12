package com.sy.common;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* *
 * @Description 前后端统一消息定义协议 Message  之后前后端数据交互都按照规定的类型进行交互
 * {
 *   meta:{"code":code,“msg”:message}
 *   data:{....}
 * }
 */

/**
 * @Descriptioin 前后端统一消息定义协议 Message  之后前后端数据交互都按照规定的类型进行交互
 * {
 *   meta:{"code":code,“msg”:message}
 *   data:{....}
 * @Author DINGLAN
 * @Date 2019/2/19 15:33
 */
public class Message {
Map<Integer, String> statusCodeMap = new HashMap<>();
    {
        statusCodeMap.put(612, "待删除资源不存在");
        statusCodeMap.put(599, "服务端操作失败");
        statusCodeMap.put(401, "管理凭证无效");
        statusCodeMap.put(400, "文件格式不正确");
        statusCodeMap.put(200, "删除成功");
    }
    // 消息头meta 存放状态信息 code message
    private Map<String,Object> meta = new HashMap<String,Object>();
    // 消息内容  存储实体交互数据
    private Map<String,Object> data = new HashMap<String,Object>();

    public Map<String, Object> getMeta() {
        return meta;
    }

    public Message setMeta(Map<String, Object> meta) {
        this.meta = meta;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Message setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
    public Message addMeta(String key, Object object) {
        this.meta.put(key,object);
        return this;
    }
    public Message addData(String key,Object object) {
        this.data.put(key,object);
        return this;
    }
    public Message ok(int statusCode,String statusMsg) {
        this.addMeta("success",Boolean.TRUE);
        this.addMeta("code",statusCode);
        this.addMeta("msg",statusMsg);
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }

    public Message ok(KeyValuePair<String, String> ret){
        this.addMeta("success",Boolean.TRUE);
        this.addMeta("code",ret.getKey());
        this.addMeta("msg",ret.getValue());
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }

    public Message error(int statusCode,String statusMsg) {
        this.addMeta("success",Boolean.FALSE);
        this.addMeta("code",statusCode);
        this.addMeta("msg",statusMsg);
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }

    public Message error(KeyValuePair<String, String> ret){
        this.addMeta("success",Boolean.FALSE);
        this.addMeta("code",ret.getKey());
        this.addMeta("msg",ret.getValue());
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }

    //初始化一个返回对象
    public static Message initial(){
        return new Message();
    }

    public Message error(int statusCode) {
        this.addMeta("success",Boolean.FALSE);
        this.addMeta("code",statusCode);
        this.addMeta("msg", statusCodeMap.get(statusCode));
        this.addMeta("timestamp",new Timestamp(new Date().getTime()));
        return this;
    }
}
