package 정렬.기본정렬커스텀;

import java.util.Arrays;

/*
[설명]
- 100억 이하의 수의 각 자리수를 내림차순으로 정렬하기
[접근] 일단 기본 정렬로 구현하고, 선택 정렬로도 구현해보기
- long으로 받아도 되지만, scanner 써서 편하게 받기 위해 string으로 받음
[메모]
- 기본 정렬:  47개 이하일 땐 삽입 소트, 몇개이하일 때 퀵 소트, 더 많을 땐 머지 소트, 완전많을땐 카운팅 소트
*/
public class Baekjoon1427_소트인사이드_기본정렬커스텀 {
	private static String solution(String n) {
		Integer[] numbers = new Integer[n.length()];
		for (int i = 0; i < n.length(); i++) {
			numbers[i] = (int)n.charAt(i) - '0';
		}
		//Arrays.sort(numbers, Collections.reverseOrder());
		Arrays.sort(numbers, (o1, o2) -> o2 - o1);

		StringBuilder stringBuilder = new StringBuilder();
		for (Integer number : numbers) {
			stringBuilder.append(number);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		String n = sc.next();
		System.out.println(solution(n));

		sc.close();
	}
}