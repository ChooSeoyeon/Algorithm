package 스택_큐_덱_우선순위큐.큐;

import java.util.LinkedList;
import java.util.Queue;

/*
[설명] https://www.acmicpc.net/problem/2164
- 1부터 N까지 번호 붙은 카드가 차례로 1이 제일 위, N이 제일 아래인 상태로 놓여있음
- 카드 한 장 남을 때까지 아래 동작 반복
	- 제일 위에 있는 카드 버림
	- 그 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
[접근] 큐
- 큐에 1부터 N까지 순서대로 넣고 동작 반복하기
[메모]
*/
public class Baekjoon2164_카드2 {
	private static int solution(int n) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		boolean toggle = true;
		while (true) {
			if (queue.size() == 1) {
				break;
			}
			if (toggle) {
				queue.poll();
			} else {
				queue.add(queue.poll());
			}
			toggle = !toggle;
		}
		return queue.peek();
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(solution(n));

		sc.close();
	}
}