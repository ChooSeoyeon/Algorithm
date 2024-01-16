package temp;

import java.util.Scanner;

/*
[설명]
- N일 동안의 매출 기록 -> 연속된 K일 동안의 매출액 종류를 각 구간별로 구하기
[접근] 해시, 슬라이딩 윈도우
-
[매모]

*/
public class Inflearn0403_해시 {
	private static int solution(int n) {
		int count = 0;
		return count;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(solution(n));
		sc.close();
	}
}
