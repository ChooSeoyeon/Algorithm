package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 주사위 3개 돌린 경우 결과 모두 츌력하기
[접근] 재귀
- i=1, j=1, k=1~6 -> k가 6이 될 때까지 (i,j,k+1) 하다가 6이 되면 (i,j+1,1)해서 i=1,j=2,k=1~6 반복
- i=1, j=1~6, k=1~6 -> j가 6이 될 때까지 (i,j+1,1) 하다가 6이 되면 (i+1,1,1)해서 i=2,j=1~6,k=1~6 반복
- i=1~6, j=1~6, k=1~6 -> i가 6이 될 때까지 (i+1,1,1) 하다가 6이 되면 종료
[메모]
- 재귀를 이용해 구현한 dice 함수와 반복문을 이용해 구현한 diceWithLoop 함수는 동일한 동작을 한다.
*/
public class Practice_주사위3개 {
	private static void solution() {
		dice(1, 1, 1);
		diceWithLoop();
	}

	private static void dice(int i, int j, int k) {
		System.out.println(i + " " + j + " " + k);
		if (k == 6) {
			if (j == 6) {
				if (i == 6) {
					return;
				}
				dice(i + 1, 1, 1);
				return;
			}
			dice(i, j + 1, 1);
			return;
		}
		dice(i, j, k + 1);
	}

	private static void diceWithLoop() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				for (int k = 1; k <= 6; k++) {
					System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		solution();

		br.close();
	}
}