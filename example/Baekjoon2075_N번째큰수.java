package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- N*N 표에 수 채워져 있음
- 모든 수는 자신의 한 칸 위에 있는 수보다 큼
- 표에서 N번째 큰 수를 찾으시오
[접근]
- 맨 뒤에 줄만 우선순위 큐에 넣어두고
- 하나 빼면, 그줄의다음 녀석을 우선순위 큐에 넣기
[메모]
*/
public class Baekjoon2075_N번째큰수 {
	private static int solution(int n) {

		return n;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] numbers = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				numbers[i][j] = Integer.parseInt(input[j]);
			}
		}

		solution(n);

		br.close();
	}
}