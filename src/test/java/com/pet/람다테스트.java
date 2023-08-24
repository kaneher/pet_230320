package com.pet;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.ToString;

public class 람다테스트 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// @Test
	// B로 시작하는 과일명 출력
	void 테스트1() {
		List<String> list = List.of("apple", "banana", "grape");
		list
		.stream()
		.filter(element -> element.startsWith("b"))
		.forEach(element -> logger.info(element));
		
	}
	
	// 리스트의 모든 요소를 대문자로 변경
	// @Test
	void 테스트2() {
		List<String> list = List.of("apple", "banana", "grape");
		list = list
		.stream()
		.map(fruit -> fruit.toUpperCase())
		.collect(Collectors.toList()); // stream to list
		
		logger.info(list.toString());
	}
	
	// 메소드 레퍼런스 - 리스트의 모든 요소를 대문자로 변경
	// @Test
	void 테스트3() {
		List<String> list = List.of("apple", "banana", "grape");
		list = list
		.stream()
		.map(String::toUpperCase) // = fruit -> fruit.toUpperCase()
		.collect(Collectors.toList());
		
		logger.info(list.toString());
	}
	
	@Test
	void 테스트4() {
		List<Person> people = List.of(
				new Person("신보람", 30),
				new Person("김바다", 5));
		
		// 객체 안에 있는 메소드 호출
		// people.forEach(p -> p.print()); // lambda
		// people.forEach(Person::print); // method reference
		
		// 객체를 println으로 출력하기
		people.forEach(p -> System.out.println(p)); // lambda
		people.forEach(System.out::println); // method reference
	}
	
	@ToString
	class Person {
		private String name;
		private int age;
		
		Person(String name, int age) {
			this.name = name;
			this.age = age;
			
		}
		
		void print() {
			System.out.println(this); // Person@sdfsdf
		}
	}
}
