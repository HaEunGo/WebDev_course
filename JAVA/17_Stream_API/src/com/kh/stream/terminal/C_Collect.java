package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kh.stream.model.vo.Student;

public class C_Collect {
	/*
	 * 수집 (Collect)
	 * 	- 스트림 요소들은 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 collect()를 제공한다.
	 * 	- collect() 메소드를 사용하면 필요한 요소만 새로운 컬렉션으로 담아서 리턴받을 수 있다.
	 */
	
	public void method1() {
		List<Student> students = Arrays.asList(
				new Student("봉봉이", 19, "여자", 86, 97),
				new Student("땅땅이", 23, "여자", 45, 68),
				new Student("쑥쑥이", 20, "남자", 100, 100),
				new Student("동글이", 29, "여자", 100, 100),
				new Student("콩콩이", 18, "남자", 74, 80)
		);
		
		// 남학생만 뽑을 수 있도록 추출하여 그 요소들을 하나의 새로운 리스트로 생성
		List<Student> maleList = students.stream()
										 .filter(student -> student.getGender().equals("남자"))
										 .collect(Collectors.toList());
		
		// 그 리스트를 활용하여 스트림으로 얻어와서 필요한 작업이 가능하다.
		maleList.stream().forEach(student -> System.out.println(student));
		
		System.out.println();
		
		// 여학생만 뽑을 수 있도록 추출 후 그 요소들을 하나의 set객체로 생성
		Set<Student> femaleList = students.stream()
										  .filter(student -> student.getGender().equals("여자"))
										  // toSet 내부에 자동으로 HashSet이 들어가 있음
//										  .collect(Collectors.toSet());
										  // 필터로 제거된 요소를 새로운 컬렉션으로 만들어 주고, 매개값으로 HashSet 객체로 넘겨준다.
//										  .collect(Collectors.toCollection(() -> {return new HashSet<>();}));
										  // 매개값으로 생성자 참조
										  .collect(Collectors.toCollection(HashSet::new));
										  
		femaleList.stream().forEach(student -> System.out.println(student));
		
		System.out.println();
		
		// 문자열을 키로 저장하고 길이를 값으로 저장 하는 Map에 해당 요소를 수집
		Map<String, Student> studentMap = students.stream()
												  .collect(Collectors.toMap(student -> student.getName(), student -> student));

		System.out.println(studentMap);

	}
}
