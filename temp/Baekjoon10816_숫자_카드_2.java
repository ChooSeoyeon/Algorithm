package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[설명]
- given: 상근이는 숫자 카드 N개를 가지고 있고, 수 M개가 주어졌을 때
- return: 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지 구하기
[접근] 매개변수탐색
1. 주어진 숫자보다 작거나 같음 -> yes / 주어진 숫자보다 큼 -> no
2. y y y y / n n n 순으로 나열됨 -> y와 n의 경계 찾기 -> 최초의 n 찾기 (가장 큰 수 찾기)
    - mid가 y일 때: result를 mid로 갱신하고, 타깃이 mid보다 크다 간주한 채 탐색 범위를 mid보다 큰 쪽으로 변경
    - mid가 n일 때: 타깃이 mid보다 작다 간주한 채 탐색 범위를 mid보다 작은 쪽으로 변경
3. 마지막 0에서 앞으로 가면서 다른 숫자 나오면 멈추기로 개수 세기
4. 1~3을 정확히 반대로 해서 이번엔 가장 작은 수 찾기
    - 주어진 숫자보다 크거나 같음 -> yes / 주어진 숫자보다 작음 -> no
    - n n / y y y y y -> 가장 작은 수 찾기
[메모]
- -10 -10 2 3 3 6 7 10 10 10
*/
public class Baekjoon10816_숫자_카드_2 {
    private static int[] numbers; // size = n
    private static int[] targets; // size = m

    private static int[] solution() {
        int[] answer = new int[targets.length];
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;

        for (int i = 0; i < targets.length; i++) {
            int largest = binarySearchToLargest(left, right, targets[i]);
            if (numbers[largest] != targets[i]) {
                answer[i] = 0;
                continue;
            }
            int smallest = binarySearchToSmallest(left, right, targets[i]);
            answer[i] = largest - smallest + 1;
        }
        return answer;
    }

    private static int binarySearchToLargest(int left, int right, int target) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > numbers[mid]) {
                left = mid + 1;
            } else if (target == numbers[mid]) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int binarySearchToSmallest(int left, int right, int target) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < numbers[mid]) {
                right = mid - 1;
            } else if (target == numbers[mid]) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
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

        int[] answer = solution();
        for (int ans : answer) {
            System.out.print(ans + " ");
        }

        br.close();
    }
}
