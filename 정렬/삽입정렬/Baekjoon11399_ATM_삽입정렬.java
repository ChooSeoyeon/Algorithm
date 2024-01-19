package 정렬.삽입정렬;

/*
[설명]
- 1~N번까지 번호 매겨져 있는 N명의 사람들 줄 서있음
- i번 사람이 돈 인출하는데 걸리는 시간은 Pi분
- 줄 서는 순서에 따라 돈 인출하는 데 필요한 시간 합 달라짐
	- p 나열한 게 3, 1, 4, 3, 2 라면, 실제론 3, 4, 8, 11, 13 만큼 시간 걸리고 총 시간은 39분 걸림
	- p 나열한 게 1, 2, 3, 3, 4 라면, 실제론 1, 3, 6, 9, 13 만큼 시간이 걸리고 총 32분이 걸림
- N과 P를 보고 각 사람이 돈을 인출하는 데 필요한 시간 합의 최소값 구하기
[접근] 삽입 정렬로 구현해보기
- 정렬하고 그 값 누적해서 더하기
[메모]
- key 잡고, 정렬된 곳 중 넣을 곳 찾아 삽입
*/
public class Baekjoon11399_ATM_삽입정렬 {
	private static int solution(int n, int[] numbers) {
		insertionSort(n, numbers);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += numbers[i] * (n - i);
		}
		return sum;
	}

	private static void insertionSort(int n, int[] numbers) {
		for (int i = 1; i < n; i++) {
			int key = numbers[i]; // 타깃
			int j = i - 1; // 타깃의 한 칸 앞부터 탐색
			while (j >= 0 && numbers[j] > key) { // key 보다 작거나 같은 녀석 찾으면 멈춤 (그 녀석 뒤에 삽입되어야 하기 때문에)
				numbers[j + 1] = numbers[j]; // key 보다 큰 녀석은 뒤로 한 칸 이동 (맨 처음에 이동하는 녀석이 key 자리로 들어감)
				j--;
			}
			numbers[j + 1] = key;
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

		System.out.println(solution(n, numbers));

		sc.close();
	}
}