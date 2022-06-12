package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.model.vo.Student;

public class C_Sorted {
	/*
	 * 정렬
	 * 	- 스트림은 요소가 최종 처리 되기전에 중간 단계에서 요소를 정렬해서 최종 처리 순서를 변경할 수 있다.
	 * 	- Stream<T>은 요소 객체가 Comparable을 구현하지 않을 경우 예외가 발생한다.
	 * 	- IntStream, LongStream, DoubleStream은 별도로 Comparable 인터페이스를 구현할 필요는 없고, 요소를 오름차순으로 정렬한다.
	 */
	
	// 요소가 객체일 때 정렬
	public void method1() {
		List<String> names = Arrays.asList("와인", "막걸리", "위스키", "소주", "고량주", "맥주");
//		List<Student> students = Arrays.asList(
//				new Student("봉봉이", 20, "여자", 86, 97),
//				new Student("땅땅이", 20, "여자", 45, 68),
//				new Student("쑥쑥이", 20, "남자", 100, 100)
//		);
		
		//  Comparable 구현 내용에 따라서 정렬된다.
		names.stream()
//		 	 .sorted()
//		 	 .sorted((n1, n2) -> n1.compareTo(n2))
		 	 .sorted(Comparator.naturalOrder())
		 	 .forEach(name -> System.out.println(name));
		
		// Comparable 구현이 되어 있지 않아서 사용 불가 -> 구현시켜주면 됨 : Student.java에서 implements Comparable<Student>
//		students.stream()
//				.sorted()
//				.forEach(student -> System.out.println(student));
		
		System.out.println();
		
		//  Comparable 구현 내용에 따라서 반대로 정렬된다. (역순 정렬)
		names.stream()
//			 .sorted((n1, n2) -> n2.compareTo(n1))
			 .sorted((Comparator.reverseOrder()))
			 .forEach(name -> System.out.println(name));
	}
	
	
	// 요소가 기본 자료형일 때 정렬 (정수, 실수 등) : 오름차순밖에 안됨
	public void method2() {
		// 기본 자료형의 요소를 가지는 스트림은 오름차순으로 정렬한다.
		Arrays.stream(new int[] {3, 4, 7, 1, 9, 6, 2, 5})
			  .sorted()
			  .forEach(value -> System.out.println(value));
		
		// 기본 자료형을 내림차순으로 정렬하는 방법 (boxed로 객체로 매핑 후 sorted)
		Arrays.stream(new int[] {3, 4, 7, 1, 9, 6, 2, 5})
			  .boxed()
			  .sorted(Comparator.reverseOrder())
//			  .mapToInt(value -> value.intValue()) // 정수형으로 바꿔주고
//			  .forEach(value -> System.out.println(value));	// 최종적으로 출력  
			  .forEach(value -> System.out.println(value.intValue()));
	}
}
