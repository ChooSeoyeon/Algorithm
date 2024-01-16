package 정렬.버블정렬;

import java.util.Scanner;

/*
[설명]
- N개의 숫자가 입력되면 오름차순으로 정렬하여 출력
- 단, 정렬 방법은 버블 정렬
[접근] 버블 정렬
- 연속된 두 숫자씩 정렬해주면 맨 끝자리는 무조건 가장 큰 수가 들어옴
- 그렇게 끄터머리에 확정된 가장 큰 수들을 하나씩 놓아주면서 정렬
[매모] 설명 듣기
- 0 ~ 5, 0 ~ 4, 0 ~ 3, 0 ~ 2, 0 ~ 1 보고 매번 최대값을 끝에 오게 하기
- 0 ~ 5 는 0 vs 1, 1 vs 2, 2 vs 3, 3 vs 4, 4 vs 5 순으로 봄
- 0 ~ 4 는 0 vs 1, 1 vs 2, 2 vs 3, 3 vs 4 순으로 봄
- 0 ~ 1 은 0 vs 1 순으로 봄
- i = 5~1
	i = 5 j = 0~4 -> j+1과 swap
	i = 4 j = 0~3
	i = 1 j = 0
*/
public class Inflearn0602_버블정렬 {
	private static void solution(int n, int[] numbers) {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		solution(n, numbers);

		for (int number : numbers) {
			System.out.print(number + " ");
		}
		sc.close();
	}
}
