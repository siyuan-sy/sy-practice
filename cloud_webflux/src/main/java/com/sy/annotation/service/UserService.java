package com.sy.annotation.service;

import com.sy.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author siyuan
 * @create 2020/7/27
 */
public interface UserService {
    public Mono<User> getById(Integer id);
    public Flux<User> getAll();
    public Mono<Void> save(Mono<User> userMono);
}
