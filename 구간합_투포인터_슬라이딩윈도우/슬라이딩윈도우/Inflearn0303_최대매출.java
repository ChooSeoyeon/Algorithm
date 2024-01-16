package 구간합_투포인터_슬라이딩윈도우.슬라이딩윈도우;

import java.util.Scanner;

/*
[설명]
- n일 동안의 매출 기록 중 연속된 3일(고정) 동안의 최대 매출액
[접근] 슬라이딩 윈도우
- 윈도우 초기 세팅
    - sum = 1~k일 매출액 합
- 윈도우 이동 조건
    - 한 칸 이동 시 (추가된매춣액 - 제거된매출액) 값을 sum에 더하기
    - sum 값이 변경될 때마다 그 값이 기존 maxSum보다 큰지 확인 후, maxSum 값을 갱신해준다.
[매모]
- 슬라이딩 윈도우 -> O(k) + O(n-k) = O(N)
- 다른 방법은? k개씩 모두 더하기 -> O(k * (n-k)) = O(N^2)
*/
public class Inflearn0303_최대매출 {
	private static int solution(int n, int k, int[] arr) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		int maxSum = sum;
		for (int i = k; i < n; i++) {
			sum += (arr[i] - arr[i - k]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(solution(n, k, arr));
		sc.close();
	}
}