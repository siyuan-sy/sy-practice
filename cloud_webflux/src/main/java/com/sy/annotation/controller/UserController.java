package com.sy.annotation.controller;

import com.sy.annotation.service.UserService;
import com.sy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author siyuan
 * @create 2020/7/27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getById/{id}")
    public Mono<User> getById(@PathVariable Integer id){
        return  userService.getById(id);
    }

       @GetMapping("/getAll")
    public Flux<User> getAll(){
        return  userService.getAll();
    }
       @PostMapping("/save")
    public Mono<Void> save(@RequestBody User user){
           Mono<User> just = Mono.just(user);
           return  userService.save(just);
    }


}
