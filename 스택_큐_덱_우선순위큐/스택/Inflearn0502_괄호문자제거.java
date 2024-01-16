package 스택_큐_덱_우선순위큐.스택;

import java.util.Scanner;
import java.util.Stack;

/*
[설명]
- 소괄호 사이에 존재하는 문자는 제거하고 남은 문자 출력
[접근] 스택
- 여는 괄호 나오면, 스택에 push
- 문자 나오면, 스택에 push
- 닫는 괄호 나오면, 여는 괄호 나오거나 스택 빌 때까지 pop
- 전부 다 밨다면, 스택에 있는 것들 거꾸로 출력하기 (string reverse)
[매모]
*/
public class Inflearn0502_괄호문자제거 {
	private static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c == ')') {
				while (!stack.empty() && stack.pop() != '(') {
				}
			} else {
				stack.push(c);
			}
		}

		StringBuilder answer = new StringBuilder();
		for (char c : stack) {
			answer.append(c);
		}
		return answer.toString();
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
		sc.close();
	}
}