package 구간합_투포인터_슬라이딩윈도우.투포인터;

import java.util.Arrays;
import java.util.Scanner;

/*
[설명]
- 두 재료의 숫자 합해서 M이 되면 갑옷 만들기 성공
[접근] 구간합_투포인터_슬라이딩윈도우.투포인터
- 초기 값
	- a : 정렬된 배열 (1,2,3,4,5,7)
	- i : 0 (첫번쨰값)
	- j : 5 (마지막값)
		-> 두번째값이 아닌 마지막값 택한 이유
			: 두번쨰값일 땐 sum>m의 경우 i,j 둘다 증가는 의미없고,
			i감소는 이미 본 거라 의미 없고,
			j감소밖에 안남는데,
			j가 마지막값이어야 이 감소가 의미가 있음
- 포인터 증가 조건 sum=a[i]+a[j]
	- sum==m -> i 증가, j 감소
		- 3+5, 5+4(break)
	- sum>m -> j 감소
	- sum<m -> i 증가
		- 1+7, 2+7(count), 4+5(count)
- 범위 밖 제한 조건
	- i가 j보다 크거나 같아질 때
*/
public class Baekjoon1940_주몽 {
	private static int solution(int m, int[] materials) {
		int answer = 0;
		int i = 0;
		int j = materials.length - 1;
		Arrays.sort(materials);

		while (i < j) {
			int sum = materials[i] + materials[j];
			if (sum == m) {
				i++;
				j--;
				answer++;
			} else if (sum > m) {
				j--;
			} else {
				i++;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] materials = new int[n];
		for (int i = 0; i < n; i++) {
			materials[i] = sc.nextInt();
		}
		System.out.println(solution(m, materials));

		sc.close();
	}
}
