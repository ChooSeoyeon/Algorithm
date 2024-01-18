package 정렬.버블정렬;

import java.util.Arrays;
import java.util.HashMap;

/*
[설명] https://www.acmicpc.net/problem/1377
- 버블 정렬의 swap이 한 번도 일어나지 않은 루프가 언제인지 인덱스 알아내기
[접근]
- 버블 정렬은 사용 불가 (10^5^2=10^10)
- 변화 많이 일어나야 하는 초반일 수록 인덱스 많이 이동할 거임
- 끝으로 갈 수록 인덱스 적게 이동할 거임
- 값들에 대해 정렬 후 인덱스와 정렬 전 인덱스를 비교했을 때 가장 인덱스 이동이 적은 값의 정렬 전 인덱스가 정답임
- 인덱스 이동이 가장 적은 값이 두 개라면, 그 중 정렬 전 인덱스가 큰 녀석이 정답임
[메모]
*/
public class Baekjoon1377_버블소트 {
	private static int solution(int[] numbers, int n) {
		HashMap<Integer, Integer> before = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			before.put(numbers[i], i);
		}
		Arrays.sort(numbers);

		HashMap<Integer, Integer> after = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			after.put(numbers[i], i);
		}
		int minIndex = 100;
		int minSub = 10_000_000;
		for (int i = 1; i <= n; i++) {
			int number = numbers[i];
			int sub = Math.abs(before.get(number) - after.get(number));
			if (sub < minSub) {
				minSub = sub;
				minIndex = before.get(number);
			} else if (sub == minSub) {
				if (before.get(number) > minIndex) {
					minIndex = before.get(number);
				}
			}
		}

		return minIndex;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			numbers[i] = sc.nextInt();
		}

		System.out.println(solution(numbers, n));

		sc.close();
	}
}

// private static int solution(int[] numbers, int n) {
// 	for (int i = 1; i <= n; i++) {
// 		System.out.println("i = " + i);
// 		for (int number : numbers) {
// 			System.out.print(" " + number);
// 		}
// 		System.out.println();
// 		boolean changed = false;
// 		for (int j = 1; j <= n - i; j++) {
// 			if (numbers[j] > numbers[j + 1]) {
// 				changed = true;
// 				int temp = numbers[j];
// 				numbers[j] = numbers[j + 1];
// 				numbers[j + 1] = temp;
// 			}
// 		}
// 		if (!changed) {
// 			return i;
// 		}
// 	}
// 	return 0;
// }