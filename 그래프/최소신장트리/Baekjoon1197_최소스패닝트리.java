package 그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
-
[접근]
-
[메모]
*/
public class Baekjoon1197_최소스패닝트리 {
	private static int solution(int n) {
		return n;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}

		System.out.println(solution(n));

		br.close();
	}
}