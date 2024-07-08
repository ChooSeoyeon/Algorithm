package random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
[설명]
- 서로 다른 자연수 a1, ..., an이 주어짐
- a1, ..., an에서 2개를 선택해 붙여 새로운 수 만들 수 있음
- 만들 수 있는 세 번째로 작은 수 구하기
[접근]
- 최대 5자리 수 이므로 자리수 별로 수 분류하기
    - 한 자리수: 1
    - 두 자리수: 17, 71
    - 세 자리수: 888
- 두 수를 합쳐서 작은 수가 되려면 일단 자리수가 적어야 함. 자리 수 적고 수 적은 순으로 작은 숫자 3개 뽑아오기
    - 제일 작은 1과 두 번째로 작은 17, 71이 후보
    - 만들 수 있는 것 : 1_17, 1_71, 17_1, 71_1
[메모]
- 1, 18, 23, 71 -> 118, 123, 171, 181
- 9, 18, 71 -> 189, 719, 918
- 9, 91 -> 919, 991
*/
public class Baekjoon5619_세_번째 {
    private static int solution(int[] numbers) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        List<Integer> three = new ArrayList<>();
        List<Integer> four = new ArrayList<>();
        List<Integer> five = new ArrayList<>();
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(numbers));

        br.close();
    }
}
