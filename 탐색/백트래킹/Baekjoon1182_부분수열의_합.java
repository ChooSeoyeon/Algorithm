package 탐색.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- N개의 정수로 이루어진 수열이 있음
- 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
[접근] nCr 조합 -> 백트래킹
[메모]
- 1,2
- 1,3
- 1,4
- 1,5
- 1,2,3
*/
public class Baekjoon1182_부분수열의_합 {
    private static boolean[] visited;
    private static int sum = 0;
    private static int count = 0;

    private static int solution(int n, int s, int[] numbers) {
        visited = new boolean[n];
        backtracking(0, numbers, s);
        return count;
    }

    private static void backtracking(int x, int[] numbers, int s) {
        if (x == numbers.length) {
            sum = 0;
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += numbers[i];
                System.out.println(sum);
                if (sum == s) {
                    count++;
                    sum = 0;
                    return;
                }
                backtracking(x + 1, numbers, s);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        int[] numbers = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(n, s, numbers));

        br.close();
    }
}
