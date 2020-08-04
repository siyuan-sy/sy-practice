package com.sy.function;

import com.sy.annotation.service.UserService;
import com.sy.function.service.UserFunctionService;
import com.sy.function.service.UserFunctionServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @author siyuan
 * @create 2020/7/27
 */
public class UserRouterFunction {

    public static void main(String[] args) throws  Exception {
        UserRouterFunction server = new UserRouterFunction();
        server.createReactorServer();
        System.out.println("end");
        System.in.read();
    }

    //创建router路由
    public RouterFunction<ServerResponse> routingFouction(){

        //创建hander对象
        UserFunctionService userService = new UserFunctionServiceImpl();
        UserFunction hander = new UserFunction(userService);
        //设置路由
        return RouterFunctions.route(
                GET("/user/getById/{id}").and(accept(APPLICATION_JSON)),hander::getById)
                .andRoute(GET("/user/getAll").and(accept(APPLICATION_JSON)),hander::getAll);
    }

    //创建服务器完成适配
    public void createReactorServer(){
        //路由和handler配置
        RouterFunction<ServerResponse> route = routingFouction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }
}
