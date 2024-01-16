package 구간합_투포인터_슬라이딩윈도우.구간합;

import java.util.Scanner;

/*
[설명] https://www.acmicpc.net/problem/11659
- N개의 수 중 i~j 번째 수들의 합 구하기
[접근] 구간합
- i~j번째 수들의 합을 매번 새로 구하지 않고, 구간합을 이용해 구하자
	- 매번 새로 구하면 -> O(N*M) 100/0000/0000 -> 100억 (예를 들어 0~N까지 합을 M번 구하라 한다면)
	- 구간합으로 구하면 -> O(N+M) 20/0000
- s[i..j] = s[0..j] - s[0..i-1]
- s[0..0~j]를 미리 구해두기
*/
public class Baekjoon11659_구간합구하기4 {
	private static int[] solution(int[] numbers, int[][] targets) {
		int[] answer = new int[targets.length];

		int[] sum = new int[numbers.length + 1];
		for (int i = 1; i <= numbers.length; i++) {
			sum[i] = numbers[i - 1] + sum[i - 1];
		}

		for (int i = 0; i < targets.length; i++) {
			int targetI = targets[i][0];
			int targetJ = targets[i][1];
			answer[i] = sum[targetJ] - sum[targetI - 1];
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		int[][] targets = new int[m][2];
		for (int i = 0; i < m; i++) {
			targets[i][0] = sc.nextInt();
			targets[i][1] = sc.nextInt();
		}

		int[] answers = solution(numbers, targets);
		for (int answer : answers) {
			System.out.println(answer);
		}

		sc.close();
	}
}
