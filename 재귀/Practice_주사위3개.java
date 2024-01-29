package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
-
[접근]
-
[메모]
*/
public class Practice_주사위3개 {
	private static void solution() {
		dice(1, 1, 1);
	}

	private static void dice(int i, int j, int k) {
		System.out.println(i + " " + j + " " + k);
		if (k == 6) {
			if (j == 6) {
				if (i == 6) {
					return;
				}
				dice(i + 1, j, k);
				return;
			}
			dice(i, j + 1, k);
			return;
		}
		dice(i, j, k + 1);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		solution();

		br.close();
	}
}