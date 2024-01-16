package 구간합_투포인터_슬라이딩윈도우.투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
[설명]
- A, B 두 개의 집합이 주어지면, 두 집합의 공통 원소를 추출해 오름차순으로 출력
[접근] 투포인터
- 포인터 증가 조건
    - 가르킨 두 값이 같으면, 그 값을 결과 배열에 넣고 양쪽다 포인터를 증가시킴
    - 가르킨 두 값이 다르면, 둘 중 작은 쪽 포인터를 증가시킴
- 범위 밖 제어 조건
    - 한 쪽 포인터라도 범위 밖이 되면, 종료시킴
    (마지막 값과 나머지 값을 비교해야 할까? no. 어차피 다른 쪽의 나머지 값들은 마지막 값보다 더 큰 값밖에 안 남아서 뒤를 보는 의미가 없음)
[메모]
- HashSet으로도 풀 수 있음 -> 집합 개념으로 알아서 retainAll
*/
public class Inflearn0302_공통원소구하기 {
	private static ArrayList<Integer> solution(int n, int m, int[] firstArr, int[] secondArr) {
		ArrayList<Integer> answer = new ArrayList<>();
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);

		int i = 0, j = 0;
		while (i < n && j < m) {
			if (firstArr[i] == secondArr[j]) {
				answer.add(firstArr[i]);
				i++;
				j++;
			} else if (firstArr[i] < secondArr[j]) {
				i++;
			} else if (firstArr[i] > secondArr[j]) {
				j++;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] firstArr = new int[n];
		for (int i = 0; i < n; i++) {
			firstArr[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		int[] secondArr = new int[m];
		for (int i = 0; i < m; i++) {
			secondArr[i] = sc.nextInt();
		}

		ArrayList<Integer> answer = solution(n, m, firstArr, secondArr);
		for (int ans : answer) {
			System.out.print(ans + " ");
		}
		sc.close();
	}
}
