package com.sy.function;

import com.sy.function.entity.User;
import com.sy.function.service.UserFunctionService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.EntityResponse.fromObject;

/**
 * @author siyuan
 * @create 2020/7/27
 */
public class UserFunction {


    private final UserFunctionService userService;

    public UserFunction(UserFunctionService userService) {
        this.userService = userService;
    }

    /**
     * 根据id查看
     */
    public Mono<ServerResponse> getById(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        Mono<User> userMono = this.userService.getById(id);
        return
                userMono.flatMap(x->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userMono,User.class));

    }

    /**
     * 拿到全部
     *
     * @return
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<User> all = userService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(all,User.class);
    }

    /**
     * 新增
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<User> userMono =  request.bodyToMono(User.class);
        return  ServerResponse.ok().build(userService.save(userMono));
    }

}
