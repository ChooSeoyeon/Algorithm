package 구간합;

import java.util.Scanner;

/*
[설명] https://www.acmicpc.net/problem/11660
- N*N 개의 수 중 (x1, y1)~(x2, y2)까지 합을 구하는 프로그램
[접근] 구간합
- 구간합을 항상 구간의 최하단우측 위치에 저장
- (x1,y1)~(x2,y2)까지 합 = s(x2,y2) - s(x1-1, y2) - s(x2, y1-1) + s(x1-1, y1-1)
	- (3,3)~(3,3)까지 합 = s(3,3) - s(2,3) - s(3,2) + s(2,2)
	- (2,2)~(4,3)까지 합 = s(4,3) - s(1,3) - s(4,1) + s(1,1)
- s(i,j) = a(i,j) + s(i-1,j) + s(i,j-1) - s(i-1,j-1)
*/
public class Baekjoon11660_구간합구하기5 {
	private static int[] solution(int n, int m, int[][] numbers, int[][] targets) {
		int[] answer = new int[m];

		int[][] sum = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum[i][j] = numbers[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
			}
		}

		for (int i = 0; i < m; i++) {
			int x1 = targets[i][0];
			int y1 = targets[i][1];
			int x2 = targets[i][2];
			int y2 = targets[i][3];
			answer[i] = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] numbers = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}

		int[][] targets = new int[m][4];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 4; j++) {
				targets[i][j] = sc.nextInt();
			}
		}

		int[] answers = solution(n, m, numbers, targets);
		for (int answer : answers) {
			System.out.println(answer);
		}

		sc.close();
	}
}
