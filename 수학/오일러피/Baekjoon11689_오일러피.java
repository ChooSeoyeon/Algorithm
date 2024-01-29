package 수학.오일러피;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

/*
[설명]
- 1~n까지 수 중 N과 서로소 관계를 갖는 수의 개수 구하기
- 서로소 : 최대공약수가 1
[접근] 오일러피
- 오일러 피 함수 P[N]을 구하면 됨
- 과정
	- 2부터 쭉 보는데 소수라면 그 수 K(ex. 2)의 배수들에 대해 P[i]=P[i]-P[i]/K 연산 수행
	- 반대로 말하자면 N의 소수인 약수에 대해서만 P[i]=P[i]-P[i]/K 연산을 수행하면 됨
[메모]
- 정통 과정 -> 우리는 P[N]만 알면 되므로 배열 만들 필요 없을 듯
	- 1~N까지 배열 만들기 (인덱스랑 값 일치하게 하기) -> 인덱스 : i, 값 : P[i]
	- 2부터 쭉 보는데 소수라면 그 수 K의 배수들에 대해 P[i]=P[i]-P[i]/K 연산 수행
[오딥]
- 소인수분해를 구해야겠단 아이디어는 혼자 떠올렸는데,
	- 빨리 내 아이디어를 검증하고 싶단 생각에 소인수분해 구하는 코드는 남의 코드 겟챠함.
	- 근데 linkedhashset은 내 아이디어.
*/
public class Baekjoon11689_오일러피 {
	private static long solution(long n) {
		long number = n;
		LinkedHashSet<Long> primeFactors = new LinkedHashSet<>();
		for (int i = 2; i <= Math.sqrt(number); i++) {
			while (number % i == 0) {
				primeFactors.add((long)i);
				number /= i;
			}
		}

		if (number != 1) {
			primeFactors.add(number);
		}

		long count = n;
		for (long i : primeFactors) {
			count = count - count / i;
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		System.out.println(solution(n));

		br.close();
	}
}