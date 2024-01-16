package 정렬.삽입정렬;

import java.util.Scanner;

/*
[설명]
- N개의 숫자가 입력되면 오름차순으로 정렬하여 출력
- 단, 정렬 방법은 삽입 정렬
[접근] 삽입 정렬
- 앞에서부터 정렬된 상태를 만듦
- 정렬 상태를 만들 땐 만들 범위의 가장 마지막 값을 뒤에서부터 보면서 넣을 위치를 찾음
- 자기보다 큰 애들은 인덱스 1씩 늘리면서 찾아가고, 자기 위치 찾으면 거기로 들어감
[매모] 설명 듣기
- 0 ~ 1, 0 ~ 2, 0 ~ 3, 0 ~ 4, 0 ~ 5 순서로 정렬 상태를 만듦
- 0 ~ 1은 1 vs 0 순으로 봄
- 0 ~ 2는 2 vs 1, 1 vs 0 순으로 봄
- 0 ~ 3은 3 vs 2, 2 vs 1, 1 vs 0 순으로 봄
- 0 ~ 5는 5 vs 4, 4 vs 3, 3 vs 2, 2 vs 1, 1 vs 0 순으로 봄
- 단, 중간에 자기 자리 찾아서 swap 안해도 되는 상황 생기면 그 앞은 전부 마찬가지이므로 break
- i = 1 ~ 5
	- i = 1 일 때, j = 1 (j-1과 비교)
	- i = 2 일 때, j = 2~1
	- i = 3 일 때, j = 3~1
	- i = 5 일 떄, j = 5~1
*/
public class Inflearn0603_삽입정렬 {
	private static void solution(int n, int[] numbers) {
		for (int i = 1; i < n; i++) {
			System.out.println("i = " + i);
			for (int j = i; j > 0; j--) {
				System.out.println("j = " + j);
				if (numbers[j] < numbers[j - 1]) {
					System.out.println(numbers[i]);
					System.out.println("numbers[j] = " + numbers[j]);
					int temp = numbers[j];
					numbers[j] = numbers[j - 1];
					numbers[j - 1] = temp;
				} else {
					break;
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
