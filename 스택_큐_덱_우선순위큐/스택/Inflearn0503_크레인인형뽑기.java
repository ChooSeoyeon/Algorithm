package 스택_큐_덱_우선순위큐.스택;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
[설명]
- 크레인으로 인형 뽑아서 바구니(스택_큐_덱_우선순위큐.스택)에 쌓아둠
- 바구니의 가장 위에 있는 인형이랑 지금 넣으려는 인형이랑 똑같으면 두 인형 모두 터짐
- 인형이 없는 곳에서 크레인 작동시키면 아무 일도 일어나지 않음
- 크레인을 모두 작동시킨 후 터진 인형 개수 구하기
- board : 인형들 위치 표현된 격자
- moves: 크레인 작동시킨 위치 (1부터 시작)
[접근] 스택_큐_덱_우선순위큐.스택
- moves 배열에서 주어진 대로 인형 뽑고 스택에 넣을 거임 (뽑는 건 일단 확실히 진행)
	- 스택에 넣기 전에 가장 최신 인형이랑 넣을 인형이 같은지 확인함
	- 같으면 스택의 가장 최신 인형 pop 해서 없애고, count를 2만큼 증가시킴 (push는 하지 않음)
	- 다르면 인형을 스택에 push함
- 인형들을 뽑을 곳은 스택_큐_덱_우선순위큐.큐 배열임
	- 한 줄씩 보고 숫자가 0이 아니면, 스택_큐_덱_우선순위큐.큐 배열에서 해당 인덱스의 큐에 집어 넣음
	- 인형을 빼갈 땐, 큐가 비어있으면(null 나옴) 인형 뽑은 이후의 동작을 하지 않고 넘어감
[매모]
- board 값 토대로 스택_큐_덱_우선순위큐.큐 배열 만들기
- moves 값 대로 인형 뽑기
- 뽑은 인형을 바구니(스택_큐_덱_우선순위큐.스택)에 집어넣기
*/
public class Inflearn0503_크레인인형뽑기 {
	private static int solution(int[][] board, int[] moves) {
		Queue<Integer>[] box = makeBox(board);
		return pickDoll(box, moves);
	}

	private static Queue<Integer>[] makeBox(int[][] board) {
		Queue<Integer>[] box = new LinkedList[board.length];
		for (int i = 0; i < box.length; i++) {
			box[i] = new LinkedList<>();
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] > 0) {
					box[j].add(board[i][j]);
				}
			}
		}
		return box;
	}

	private static int pickDoll(Queue<Integer>[] box, int[] moves) {
		Stack<Integer> basket = new Stack<>();
		int count = 0;
		for (int move : moves) {
			Integer newDoll = box[move - 1].poll();
			if (newDoll != null) {
				if (!basket.empty() && newDoll.equals(basket.peek())) {
					basket.pop();
					count += 2;
				} else {
					basket.push(newDoll);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		int m = sc.nextInt();
		int[] moves = new int[m];
		for (int i = 0; i < m; i++) {
			moves[i] = sc.nextInt();
		}

		System.out.println(solution(board, moves));
		sc.close();
	}
}
