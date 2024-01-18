package 정렬.기본정렬;

import java.util.Arrays;

/*
[설명]
- 100억 이하의 수의 각 자리수를 내림차순으로 정렬하기
[접근]
- long으로 받아도 되지만, scanner 써서 편하게 받기 위해 string으로 받음
[메모]
*/
public class Baekjoon1427_소트인사이드_기본정렬 {
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