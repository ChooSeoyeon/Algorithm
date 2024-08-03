package 탐색.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[설명]
- given: 상근이는 숫자 카드 N개를 가지고 있고, 수 M개가 주어졌을 때
- return: 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하기
[접근] 이진탐색
-
[메모]
*/
public class Baekjoon10815_숫자_카드 {
    private static int[] numbers; // size = n
    private static int[] targets; // size = m

    private static int[] solution(int m) {
        int[] answer = new int[m];
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;

        for (int i = 0; i < m; i++) {
            int result = binarySearchWithLoop(left, right, targets[i]);
            answer[i] = result == -1 ? 0 : 1;
        }

        return answer;
    }

    private static int binarySearchWithLoop(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < numbers[mid]) {
                right = mid - 1;
            } else if (target > numbers[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        targets = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }

        int[] answer = solution(m);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }

        br.close();
    }
}
