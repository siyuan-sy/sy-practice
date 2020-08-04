package com.sy.function.service;

import com.sy.function.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author siyuan
 * @create 2020/7/27
 */
public interface UserFunctionService {
    public Mono<User> getById(Integer id);
    public Flux<User> getAll();
    public Mono<Void> save(Mono<User> user);
}
