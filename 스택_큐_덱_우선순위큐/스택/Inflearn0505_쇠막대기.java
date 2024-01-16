package 스택_큐_덱_우선순위큐.스택;

import java.util.Scanner;
import java.util.Stack;

/*
[설명]
- () : 레이저
- (..) : 쇠막대기
- 잘려진 쇠막대기 조각의 총 개수 구하기
[접근] 스택_큐_덱_우선순위큐.스택
- 막대기 스택이 존재
- 열린 괄호 나오면, 스택에 push
- 닫힌 괄호 나오면, 스택에서 하나 pop 하고
	- 연달아서 ()가 나타난 꼴이라면, 현재 스택_큐_덱_우선순위큐.스택 크기만큼을 정답에 더함
	- 연달아서 ()가 나타난 꼴이 아니라면,
		레이저가 아닌 쇠막대기가 끝난거므로 정답에 현재 스택_큐_덱_우선순위큐.스택 크기가 아닌 1을 더하기
[매모]
0 + 3 + 3 + 1 + 3 + 1 + 2 + 1 + 1 + 1 + 1 = 17
- 어차피 pop에서 걸리는 거, 굳이 맨 앞에 닫힌 괄호 나오는 경우를 예외 처리 하겠다고 past 쓸 필요 없을 듯
- 그냥 i-1 해도 될듯. 무조건 열린 괄호부터 들어온다고 가정한 채로.
*/
public class Inflearn0505_쇠막대기 {
	private static int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				stack.pop();
				if (str.charAt(i - 1) == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
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