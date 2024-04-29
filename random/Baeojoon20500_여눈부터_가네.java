package random;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 0으로 시작하지 않고 1과 5로만 구성된 N자리 양의 정수 중 15의 배수가 몇 개인지 구하기
- 문제의 답을 1_000_000_007로 나눈 나머지 출력하기
[접근]

[메모]
- 1과 5로만 구성된 3자리 양의 정수 중 15의 배수 -> 115
- 1과 5로만 구성된 2자리 양의 정수 중 15의 배수 -> 15
- 1과 5로만 구성된 1자리 양의 정수 중 15의 배수 -> x
*/
public class Baeojoon20500_여눈부터_가네 {
    private static long solution(int n) {
        long answer = 0;

        return answer / 1_000_000_007;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));

        br.close();
    }
}
