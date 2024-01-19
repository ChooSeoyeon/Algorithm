package 정렬.퀵정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- A를 오름차순 정렬했을 때, 앞에서부터 K번째에 있는 수 구하기
[접근] 일단 기본 정렬로 구현하고, 퀵 정렬로 구현해보기
[메모]
[오답]
	- bufferReader 안 쓰고, scanner 써서 시간 초과 남
	- start, end, left, right 용어 나눌 생각 못함
	- while문 break 하는 조건 반대로 걸엇 무한 루프 돔
	- 결국 정답 코드 보고 풀음. 꼭 다시 풀어보기
*/
public class Baekjoon11004_K번째수_퀵정렬 {
	private static int solution(int k, int[] numbers) {
		quickSort(0, numbers.length, numbers);
		return numbers[k - 1];
	}

	private static void quickSort(int start, int end, int[] numbers) {
		if (end <= start + 1) {
			return;
		}
		int pivot = numbers[start];
		int left = start + 1;
		int right = end - 1;

		while (true) {
			while (left <= right && numbers[left] <= pivot) {
				left++;
			}

			while (left <= right && numbers[right] >= pivot) {
				right--;
			}

			if (left > right) {
				break;
			}

			swap(left, right, numbers);
		}

		swap(start, right, numbers);
		quickSort(start, right, numbers);
		quickSort(right + 1, end, numbers);
	}

	private static void swap(int i, int j, int[] numbers) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}

		System.out.println(solution(k, numbers));

		br.close();
	}
}