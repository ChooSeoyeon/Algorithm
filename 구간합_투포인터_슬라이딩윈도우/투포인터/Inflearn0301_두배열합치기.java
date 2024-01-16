package 구간합_투포인터_슬라이딩윈도우.투포인터;

import java.util.ArrayList;
import java.util.Scanner;

/*
[설명]
- 오름차순으로 정렬된 두 배열을 오름차순으로 합쳐 출력
[접근] 구간합_투포인터_슬라이딩윈도우.투포인터
- 두 배열의 원소 값을 앞에서부터 하나씩 가르킴
- 가르킨 값 중 더 작은 값을 결과 배열에 넣고 해당 배열은 다음 원소를 가르키게 함
- 더이상 가르킬 원소가 없는 배열이 나오면 해당 배열은 제외
- 둘 다 더이상 가르킬 원소가 없다면 종료
*/
public class Inflearn0301_두배열합치기 {
	private static ArrayList<Integer> answer;
	private static int[] firstArr;
	private static int[] secondArr;

	private static void sumArr(int i, int j) {
		if (i < firstArr.length && j < secondArr.length) {
			if (firstArr[i] <= secondArr[j]) {
				answer.add(firstArr[i]);
				sumArr(i + 1, j);
			} else {
				answer.add(secondArr[j]);
				sumArr(i, j + 1);
			}
		} else if (i < firstArr.length) {
			answer.add(firstArr[i]);
			sumArr(i + 1, j);
		} else if (j < secondArr.length) {
			answer.add(secondArr[j]);
			sumArr(i, j + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		firstArr = new int[n];
		for (int i = 0; i < n; i++) {
			firstArr[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		secondArr = new int[m];
		for (int i = 0; i < m; i++) {
			secondArr[i] = sc.nextInt();
		}

		answer = new ArrayList<>();
		sumArr(0, 0);

		for (int j : answer) {
			System.out.print(j + " ");
		}

		sc.close();
	}
}
