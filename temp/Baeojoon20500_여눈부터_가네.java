package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 0으로 시작하지 않고 1과 5로만 구성된 N자리 양의 정수 중 15의 배수가 몇 개인지 구하기
- 문제의 답을 1_000_000_007로 나눈 나머지 출력하기
[접근] 동적계획법
- 각자리합이 3의 배수면서, 일의 자리가 5인 수
    - 일의 자리 뺀 각자리합이 3의 배수+1이어도됨
        - 1!, 4, 7!, 10!, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52, 55, 58, 61, 64, 67, 70 ...
    - 각자리합은 1과 5로만 구성됨(1최소한으로 써서 만들면) -> 1, 55, 115, 555
    - 5자리라면? 4자리 만들기 -> 1115, 1555 -> 4 + 4 = 8개
[메모]
- 1과 5로만 구성된 3자리 양의 정수 중 15의 배수 -> 555
    - 115, 151, 155, 511, 515, 555
- 1과 5로만 구성된 2자리 양의 정수 중 15의 배수 -> 15
- 1과 5로만 구성된 1자리 양의 정수 중 15의 배수 -> x
- 1과 5로만 구성된 1515자리 양의 정수 중 15의 배수
    - 100...000 ~ 999...999
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
