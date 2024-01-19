package 정렬.퀵정렬;

/*
[설명] 퀵 정렬 구현
- 매 단계마다 pivot을 제자리로 보내는 작업 반복
	- 여기서, 제자리란 pivot의 왼쪽엔 pivot보다 작은 수들만, 오른쪽엔 pivot보다 큰 수들만 존재하는 것을 의미함
- pivot을 제자리로 보내고 나서 왼쪽 구간과 오른쪽 구간을 재귀적으로 정렬
	- 리스트 크기가 1 이하가 되면 base condition에 도달
[접근]
- left와 right 라는 포인터 2개로 정렬에 방해가 되는 원소를 찾음 (left와 right가 교차할 때까지 반복)
	- left는 pivot보다 큰 값 나올 때까지 1씩 증가 (pivot의 왼쪽엔 pivot보다 큰 값 존재하면 안되기에)
	- right는 pivot보다 작은 값 나올 때까지 1씩 감소 (pivot의 오른쪽엔 pivot보다 작은 값 존재하면 안되기에)
	- left와 right 둘다 방해가 되는 요소를 찾으면 그 두 값을 swap 하고, left는 1 증가, right는 1 감소
- left보다 right이 작아진 순간, pivot과 right을 swap
[메모]
*/
public class Practice_퀵정렬구현 {
	static int[] numbers = new int[1_000_001];

	private static void quickSort(int start, int end) {
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

			swap(left, right);
		}

		swap(start, right);
		quickSort(start, right);
		quickSort(right + 1, end);
	}

	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		quickSort(0, n);

		for (int i = 0; i < n; i++) {
			System.out.println(numbers[i] + " ");
		}

		sc.close();
	}
}