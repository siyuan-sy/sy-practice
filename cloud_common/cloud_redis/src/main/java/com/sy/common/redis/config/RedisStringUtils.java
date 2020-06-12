package com.sy.common.redis.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis string操作工具类
 * @author ckf
 *
 */
@Service
public class RedisStringUtils {

    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    public void setMap(String key, Map value){
        template.opsForHash().putAll(key,value);
    }

    public Map getList(String key){
        return template.opsForHash().entries(key);
    }

    public void setKey(String key,String value,int timeOut,TimeUnit unitEnum){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value,timeOut,unitEnum);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }

    public boolean hasKey(String key){
        return  template.hasKey(key);
    }

    public void removeKey(String key){
        template.delete(key);
    }


    public Long getExpireMinByKey(String key,TimeUnit unitEnum){
        return  template.getExpire(key,unitEnum);
    }


}