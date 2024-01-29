package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
[설명]
- 칵테일에 들어가는 재료 N개, 재료의 양은 정수
- 재료 쌍 N-1개의 비율을 이용해서 칵테일에 들어가는 전체 재료의 비율 알아낼 수 있음
- 총 재료 쌍 N-1개의 비율이 주어졌을 때, 칵테일을 만드는데 들어가는 각 재료의 양을 구하기
	- 들어가는 재료의 질량 모두 더한 총질량이 최소가 되어야 함 (총질량은 0보단 큼)
[접근]
- 주어지는 비율을 저장할 땐 미리 소수꼴로 바꿔서 넣음 -> 9:3이면 3:1로 저장 (최대공약수로 나눠서)
- N개인데 N-1쌍이 주어지는 거면, 각 쌍에서 둘 중 하나는 무조건 다른 쌍에서도 등장함. 그 녀석이 둘중 메인임
- 겹치는 쌍들끼리 아래 연산 수행함
	- 겹치는 인덱스에 있는 값들의 최소공배수 구함 (전부 소수일거라서, 그냥 곱하면 됨)
	- 각 쌍의 나머지 값은 본인 짝꿍이 최소공배수가 되기 위해 곱해져야 하는 수만큼 본인도 곱함
	- 바뀐 값들로 갱신한 상태에서 다음 겹치는 쌍들을 찾아 반복함
[메모]
- 주어지는 비율
	- 4 1 3 1 -> 4번 재료의 질량:1번 재료의 질량 = 3:1
- N개인데 N-1쌍이 주어지는 거면, 각 쌍에서 둘 중 하나는 무조건 다른 쌍에서도 등장함. 그 녀석이 둘중 메인임
- 본인 짝꿍이 최소공배수가 되기 위해 곱해져야 하는 수만큼 본인도 곱해짐
- 9 : 3 처럼 주어지면 3 : 1로 미리 바꾸고 넣는 게 좋을 듯
	- 최대공약수로 나누기
- 꼭 두쌍씩 해야 하나? 그냥 인덱스 0부터 사용하는 애들 싹다 뒤지고, 해서 여러 개 한 번에 갱신해도 될 듯?
	- 인덱스 0 봤는데 두 개 이상 존재하면 ㄱㄱ
- 겹치는 애들을 쉽게 찾기 위해 인덱스 쌍 저장하는 방법 : int[][] 에서 0,1,2,3,4 순으로 검색
	- N이 10보다 작거나 같고, a와 b는 9보다 작거나 같아서 한자리수니 그냥 string으로 저장해두고 숫자 검색해도 될 듯
*/
public class Baekjoon1033_칵테일 {
	private static int[][] numbers;

	private static int[] solution(int n) {
		int[] answer = new int[n];
		Arrays.fill(answer, 1);

		for (int i = 0; i < n - 1; i++) {
			int gcd = gcd(numbers[i][2], numbers[i][3]);
			numbers[i][2] /= gcd;
			numbers[i][3] /= gcd;
		}

		for (int i = 0; i < n; i++) {
			Queue<Integer> mainIndex = new LinkedList<>();
			Queue<Integer> targetIndex = new LinkedList<>();
			int gcd = 1;
			for (int j = 0; j < n - 1; j++) {
				for (int k = 0; k < 2; k++) {
					if (numbers[j][k] == i) {
						mainIndex.add(k);
						targetIndex.add(j);
						gcd *= numbers[j][k + 2];
					}
				}
			}
			if (targetIndex.size() >= 2) {
				System.out.println("gcd = " + gcd);
				for (int target : targetIndex) {
					int main = mainIndex.remove() + 2;
					int sub = (main == 2) ? 3 : 2;
					System.out.println("numbers[target][main] = " + numbers[target][main]);
					int multiple = gcd / numbers[target][main];
					System.out.println("multiple = " + multiple);
					numbers[target][main] = gcd;
					numbers[target][sub] *= multiple;
				}
			}
		}

		for (int i = 0; i < n - 1; i++) {
			System.out.println(numbers[i][0] + " " + numbers[i][2]);
			System.out.println(numbers[i][1] + " " + numbers[i][3]);
			System.out.println();
		}

		return answer;
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		numbers = new int[n - 1][4];
		for (int i = 0; i < n - 1; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				numbers[i][j] = Integer.parseInt(input[j]);
			}
		}

		int[] answers = solution(n);
		for (int answer : answers) {
			System.out.println(answer);
		}

		br.close();
	}
}