package 동적계획법.탑다운;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 아래 코드에서 fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하기
    int fibonacci(int n) {
        if (n == 0) { // fibonacci(0)
            printf("0");
            return 0;
        } else if (n == 1) { // fibonacci(1)
            printf("1");
            return 1;
        } else {
            return fibonacci(n‐1) + fibonacci(n‐2);
        }
    }
[접근] DP
- 점화식: D[i] = D[i-1] + D[i-2]
- 탑-다운 방식: 위에서부터 문제를 파악해 내려오는 방식
[메모]
- fibonacci(3) 호출
    -> fibonacci(2) + fibonacci(1)
    -> fibonacci(1) + fibonacci(0) + fibonacci(1)
*/
public class Baekjoon1003_피보나치_함수 {
    static long[][] memory;

    private static long[][] solution(int n, int[] numbers) {
        memory = new long[41][2];
        memory[0][0] = 1;
        memory[0][1] = 0;
        memory[1][0] = 0;
        memory[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            memory[i][0] = -1;
            memory[i][1] = -1;
        }
        fibonacci(40);

        long[][] answers = new long[n][2];
        for (int i = 0; i < n; i++) {
            answers[i][0] = memory[numbers[i]][0];
            answers[i][1] = memory[numbers[i]][1];
        }
        return answers;
    }

    private static long[] fibonacci(int n) {
        if (memory[n][0] == -1 || memory[n][1] == -1) {
            memory[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            memory[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        System.out.println("n = " + n);
        System.out.println("memory[n][0] = " + memory[n][0]);
        System.out.println("memory[n][1] = " + memory[n][1]);
        return memory[n];
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        long[][] answers = solution(n, numbers);
        for (long[] answer : answers) {
            System.out.println(answer[0] + " " + answer[1]);
        }

        br.close();
    }
}
