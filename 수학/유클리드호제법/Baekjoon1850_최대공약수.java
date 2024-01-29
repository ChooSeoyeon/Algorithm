package 수학.유클리드호제법;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 모든 자리가 1로만 이루어진 두 자연수 a, b의 최대공약수 구하기
[접근]
- 유클리드 호제법
- 111 % 111 = 0 -> 3 % 3 = 0
- 1111 % 111 = 1 -> 4 % 3 = 1
- 11111 % 111 = 11 -> 5 % 3 = 2
- 111111 % 111 = 0 -> 6 % 3 = 0
- 1111111 % 111 = 1 -> 7 % 3 = 1
- 11_111_111 % 111 = 11 -> 8 % 3= 2
[오답] 문제 짧다고 대충 넘기지 말고 짧든 길든 문제를 똑바로 읽자.
- 문제 안읽고 풀었다가 모든 자리 1로 이루어진거 읽지도 않고 풀려했음
- 문제 안읽고 풀었으니 당연히 안풀렸고 순간 타입 문제인지 알고 예전에 내가 푼 풀이 봐버렸는데 그때서야 문제 잘못 읽은 거 깨달음
- 10씩 곱한값을 점점 더하는 방식으로 1로 이루어진 답 구성했는데, 틀렸습니다 떠서 이전에 푼대로 string 바로 만들게 하니 맞음
	- 왜 틀렸냐면, 정답이 천만 자리를 넘지 않는 거니 길어봐야 19자리인 long 타입으로 담기엔 택도 없기 때문임
	- 이것도.... 문제 똑바로 안읽어서 틀림...."자리"라는 글자를 안보고서 최대 1000만이라는 줄 알고 int에도 담기 충분하겠다 생각해버림
*/
public class Baekjoon1850_최대공약수 {
	private static String solution(long n, long m) {
		long number = gcd(n, m);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < number; i++) {
			stringBuilder.append("1");
		}
		return stringBuilder.toString();
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		long m = Long.parseLong(input[1]);
		System.out.println(solution(n, m));

		br.close();
	}
}