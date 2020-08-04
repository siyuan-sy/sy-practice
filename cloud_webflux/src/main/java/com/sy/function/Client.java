package com.sy.function;

import com.sy.function.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author siyuan
 * @create 2020/7/27
 */
public class Client {

	public static void main(String[] args) {
		//调用服务器地址
		WebClient webClient = WebClient.create("http://127.0.0.1:52773");

		//根据id查询
		String id = "1";
		User block = webClient.get().uri("/user/getById/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();
		System.out.println("id = " + block);

		Flux<User> userFlux = webClient.get().uri("/user/getAll", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);

		userFlux.map(x -> x.getName()).buffer().doOnNext(System.out::print).blockFirst();
	}

	public static void getStatus(String a, String d, String c, String b) {

	}
}
