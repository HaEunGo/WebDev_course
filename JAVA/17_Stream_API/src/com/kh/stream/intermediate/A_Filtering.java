package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class A_Filtering {
	/*
	 * 필터링
	 * 	- 중간 처리 기능으로 요소(배열의 요소, 리스트의 요소, 숫자 범위에 있는 요소 하나하나들)를 걸러내는 역할을 한다.
	 * 	  - distinct() : 중복을 제거하는 메소드, Stream의 경우는 Object.equals()가 true를 리턴하면 동일 객체로 판단한다.
	 * 	  - filter(Predicate) : 매개 값으로 전달되는 Predicate가 false를 리턴하는 요소를 제거한다.
	 */
	
	// 중복제거
	public void method1() {
		List<String> names = Arrays.asList("홍길동", "동동이", "달래", "홍길동", "초코", "바닐라");
		Stream<String> stream = names.stream();
		
		// 최종 처리 메소드 (forEach)
		stream.forEach(str -> System.out.println(str));
		
		// 이미 최종 처리 메소드까지 호출된 스트림은 다시 사용할 수 없다.(컬렉션(배열)로부터 다시 스트림을 얻어와야 한다.) -> 에러발생
//		stream.forEach(str -> System.out.println(str));
		System.out.println();
		
		// 중간 처리 메소드 (distinct)
		// 스트림을 이어서 쓰는 것 -> 스트림 파이프라인 (distinct의 결과값을 가지고 다음 작업의 입력에 사용됨)
		names.stream().distinct().forEach(str -> System.out.println(str));
	}
	
	// 필터링
	public void method2() {
		List<String> names = Arrays.asList("홍길동", "동동이", "달래", "홍길동", "초코", "바닐라", "달달이");
		
		names.stream()
			  .filter(name -> name.startsWith("달"))	// 걸러낼 조건
			  .forEach(name -> System.out.println(name));
		
		System.out.println();
		
		names.stream()	// parallelstream으로 병렬처리도 가능
			.distinct()
			.filter(name -> name.endsWith("이"))	// 필터 조건
			.forEach(name -> System.out.println(name));
	}
}
