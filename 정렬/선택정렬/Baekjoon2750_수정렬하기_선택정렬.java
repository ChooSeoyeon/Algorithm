package 정렬.선택정렬;

/*
[설명]
- N개의 수를 정렬하기. 이때, 선택 정렬로 정렬해보자.
[접근] 선택 정렬
- 최대값/최소값을 선택해 맨 앞의 녀석과 교체
- 앞에 하나씩 확정해가면서 위 단계 반복
[메모]
- i=0, j=0,1,2,3,4
- i=1, j=1,2,3,4
- i=2, j=2,3,4
- i=3, j=3,4
*/
public class Baekjoon2750_수정렬하기_선택정렬 {
	private static void solution(int n, int[] numbers) {
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (numbers[j] < numbers[minIndex]) {
					minIndex = j;
				}
			}
			int temp = numbers[minIndex];
			numbers[minIndex] = numbers[i];
			numbers[i] = temp;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		solution(n, numbers);
		for (int number : numbers) {
			System.out.println(number);
		}

		sc.close();
	}
}