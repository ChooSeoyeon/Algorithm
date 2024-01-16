package 스택_큐_덱_우선순위큐.스택;

import java.util.Scanner;
import java.util.Stack;

/*
[설명]
- 주어진 후위 연산식의 결과값을 계산하기
[접근] 스택_큐_덱_우선순위큐.스택
- 숫자가 나오면, 스택에 넣기
- 연산자가 나오면, 스택에서 숫자 두 개 뺴서 연산하고, 연산 결과를 스택에 다시 넣기
	- 주의할 점 : 2랑 5 순으로 빼왔다면, 2+5가 아니라 5+2를 해야 함 (순서 주의)
- 마지막 연산자까지 보면, 스택엔 숫자 하나 들어있는 게 정상임. 그 값을 출력하기
[매모]
- 예외 처리 : 후위연산식이 올바르지 않는 경우는 이번 문제에서 주어지지 않는다고 가정
*/
public class Inflearn0504_후위식연산 {
	private static int solution(String str) {
		Stack<Integer> postfix = new Stack<>();

		for (char c : str.toCharArray()) {
			if (c >= '1' && c <= '9') {
				postfix.push(c - '0');
			} else {
				int result = calculate(c, postfix.pop(), postfix.pop());
				postfix.push(result);
			}
		}
		return postfix.pop();
	}

	private static int calculate(char c, int rt, int lt) {
		if (c == '+') {
			return lt + rt;
		} else if (c == '-') {
			return lt - rt;
		} else if (c == '*') {
			return lt * rt;
		} else {
			return lt / rt;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		System.out.println(solution(str));
		sc.close();
	}
}
