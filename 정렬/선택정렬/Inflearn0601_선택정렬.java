package 정렬.선택정렬;

import java.util.Scanner;

/*
[설명]
- N개의 숫자가 입력되면 오름차순으로 정렬하여 출력
- 단, 정렬 방법은 선택 정렬
[접근] 선택 정렬
- 최소값을 찾아서 맨 앞에거 부터 교환
	- 전체 다 보고서, 가장 최소값을 첫 번째 자리에 두기 (이때 swap을 이용해 자리 재배치함)
	- 두번째부터 끝까지 다 보고서, 가장 최소값을 두 번째 자리에 두기 (이때도 마찬가지로 swap을 이용해 자리 재배치함)
	- 마지막에서 두번째부터 끝까지 다 보고서, 가장 최소값을 마지막에서 두 번째 자리에 두기
[매모]
- 0 ~ 5, 1 ~ 5, ... 4 ~ 5 보고 매번 최소값 찾기
*/
public class Inflearn0601_선택정렬 {
	private static void solution(int n, int[] numbers) {
		for (int i = 0; i < n - 1; i++) {
			int smallIndex = i; // small 값 굳이 안 쓰고 인덱스만 업데이트 하게 해도 굳
			for (int j = i; j < n; j++) {
				if (numbers[j] < numbers[smallIndex]) {
					smallIndex = j;
				}
			}
			if (i != smallIndex) {
				int temp = numbers[i];
				numbers[i] = numbers[smallIndex];
				numbers[smallIndex] = temp;
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
