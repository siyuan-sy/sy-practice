package com.sy.function.service;

import com.sy.function.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author siyuan
 * @create 2020/7/27
 */
@Service
public class UserFunctionServiceImpl implements UserFunctionService {

    private static final Map<Integer, User> userMap = new HashMap();


    static {
        userMap.put(1, new User("siyuan", 22, "saiwei"));
        userMap.put(2, new User("wangdong", 27, "saiwei"));
        userMap.put(3, new User("xuxin", 26, "saiwei"));
    }

    /**
     * 根据id查看
     */
    @Override
    public Mono<User> getById(Integer id) {
        return Mono.justOrEmpty(this.userMap.get(id));
    }

    /**
     * 拿到全部
     *
     * @return
     */
    @Override
    public Flux<User> getAll() {
        return Flux.fromIterable(userMap.values());
    }

    /**
     * 新增
     *
     * @param userMono
     * @return
     */
    @Override
    public Mono<Void> save(Mono<User> userMono) {
        return userMono.doOnNext(x -> {
            //往map中放对象
            int num = userMap.size() + 1;
            userMap.put(num, x);
        }).thenEmpty(Mono.empty());
    }
}
