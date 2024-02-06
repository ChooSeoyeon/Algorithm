package 자료구조.슬라이딩윈도우;

import java.util.Scanner;

public class Inflearn0304_연속부분수열 {
	private static int solution(int n, int m, int[] arr) {
		int count = 0;
		int start = 0;
		int end = 0;
		int sum = arr[0];

		while (start < arr.length && end < arr.length - 1) {
			if (sum == m) {
				count++;
				sum += arr[++end];
				sum -= arr[start++];
			} else if (sum < m || start == end) {
				sum += arr[++end];
			} else {
				sum -= arr[start++];
			}
		}

		while (start < arr.length) {
			if (sum == m) {
				count++;
				break;
			} else if (sum < m) {
				break;
			}
			sum -= arr[start++];
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(solution(n, m, arr));
		sc.close();
	}
}
