package 자료구조.스택;

import java.util.Scanner;
import java.util.Stack;

/*
[설명]
- 괄호 쌍이 올바르면 YES, 아니면 NO를 출력
[접근] 스택
- 열린거 나오면, 스택에 열린걸 push
- 닫힌거 나오면, 스택에서 열린걸 pop. 스택에 pop할 게 없으면 NO.
- 다 봤을 때, 스택에 남은 거 있으면 NO. 남은 거 없으면 YES
[매모]

*/
public class Inflearn0501_올바른괄호 {
	private static String solution(String str) {
		String answer = "NO";
		Stack<Character> stack = new Stack<>();

		for (char c : str.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.empty()) {
					return answer;
				}
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			answer = "YES";
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
		sc.close();
	}
}
