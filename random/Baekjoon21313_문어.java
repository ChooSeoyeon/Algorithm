package random;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 문어 손은 1~8번 번호 있음
- N 마리 문어 중 하나를 골라 1번 문어, 시계방향 순으로 2,3,...N번 문어라 부름
- 문어가 양 옆의 서로 다른 두 문어와 손을 맞잡아 원을 만들거임
	- 서로 같은 번호의 손 잡아야 함
	- 한 문어와 둘 이상의 손 잡을 수 없음
	- 한 손으로 여러 문어의 손 잡을 수 없음
- 4마리 -> 1 2 1 2
	- 1번 문어와 2번 문어가 1번 손으로 잡음
	- 2번 문어와 3번 문어가 2번 손으로 잡음
	- 3번 문어와 4번 문어가 1번 손으로 잡음
	- 4번 문어와 1번 문어가 2번 손으로 잡음
- 문어 수 N일 때 만들 수 있는 수열 중 사전순으로 제일 앞서는 수열 찾기
[접근]
- 문어가 4마리면 _ _ _ _ 을 뽑아야 함
- 앞애서부터 1~8중 뽑음
- 가능한 작은 숫자를 뽑아야함
[메모]
*/
public class Baekjoon21313_문어 {
    private static int[] solution(int n) {
        int[] answer = new int[n];

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                answer[i] = 1;
            } else {
                answer[i] = 2;
            }
        }

        if (answer[n - 2] == 2) {
            answer[n - 1] = 3;
        } else {
            answer[n - 1] = 2;
        }
        
        return answer;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = solution(n);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        br.close();
    }
}
