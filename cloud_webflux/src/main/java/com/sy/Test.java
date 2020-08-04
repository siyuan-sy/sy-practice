package com.sy;

import com.sy.function.entity.User;
import javafx.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author siyuan
 * @create 2020/7/27
 */
public class Test {

	public static void main(String[] args) {


		/*List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
		pairArrayList.add(new Pair<>("version", 6.19));
		pairArrayList.add(new Pair<>("version", 10.24));
		pairArrayList.add(new Pair<>("version", 13.14));
		Map<String, Double> map = pairArrayList.stream().collect(
		// 生成的 map 集合中只有一个键值对：{version=13.14}
				Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
		System.out.println("map = " + map);

		String[] departments = new String[] {"iERP", "iERP", "EIBU"};
// 抛出 IllegalStateException 异常
		Map<Integer, String> map1 = Arrays.stream(departments)
				.collect(Collectors.toMap(String::hashCode, str -> str));
		System.out.println("map1 = " + map1);*/
		/*String[] str = new String[] { "yang", "hao" };
		List list = new ArrayList(Arrays.asList(str));
		list.add("1");
		System.out.println("list = " + list);*/
		/*List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");*/
		/*Iterator<String> iterator = list.iterator();
		System.out.println("list = " + iterator);
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("1".equals(item)) {
				iterator.remove();
			} }
		System.out.println("iterator = " + iterator);*/
	/*	for (String item : list) {
			if ("2".equals(item)) {
				list.remove(item);
			} }
		System.out.println("list = " + list);*/
	}
}
