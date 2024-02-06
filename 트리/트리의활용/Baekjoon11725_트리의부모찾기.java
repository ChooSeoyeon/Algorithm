package 트리.트리의활용;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
[설명]
- 주어진 트리의 루트를 1이라 정했을 때, 각 노드의 부모 구하기
[접근]
1. 트리를 인접리스트로 표현하고, 부모배열 생성(0으로 초기화)하고, 큐에 시작점(루트) 넣기
2. bfs (큐가 빌 때까지 반복)
	2-1. 큐에서 뺀 노드(현재 노드)를 출력하기
	2-2. 현재 노드의 인접 노드들 중 부모 노드 제외하고 나머지를 큐에 넣고, 해당 노드들의 부모로 현재 노드를 저장하기
[메모]
- dfs는 위 과정에서 큐를 스택으로만 바꾸면 됨
[오답]
- 재귀 구성할 때 부모노드라면 continue하면 되는데 실수로 return해서 틀릴 뻔함
*/
public class Baekjoon11725_트리의부모찾기 {
	private static LinkedList<Integer>[] tree;
	private static int[] parent;

	private static int[] solution(int n, int[][] numbers) {
		// 1. 트리를 인접 리스트로 표현하고, 부모배열 생성(0으로 초기화)하기
		tree = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new LinkedList<>();
		}
		for (int i = 1; i < n; i++) {
			int start = numbers[i][0];
			int end = numbers[i][1];
			tree[start].add(end);
			tree[end].add(start);
		}

		parent = new int[n + 1]; // 0은 비우고, 노드 개수만큼 생성

		// 2. bfs 혹은 dfs (시작점은 1)
		// bfs(1);
		// dfs(1);
		dfsWithRecursion(1);

		return parent;
	}

	private static void bfs(int start) {
		// 1. 큐에 시작점(루트) 넣기
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		// 2. bfs (큐가 빌 때까지 반복)
		while (!queue.isEmpty()) {
			// 2-1. 큐에서 뺀 노드(현재 노드)를 출력하기
			int current = queue.remove();
			System.out.println(current);

			// 2-2. 현재 노드의 인접 노드들 중 부모 노드 제외하고 나머지를 큐에 넣고, 해당 노드들의 부모로 현재 노드를 저장하기
			for (int next : tree[current]) {
				if (next == parent[current]) { // current의 인접 노드 중 current의 부모 노드는 제외
					continue;
				}
				parent[next] = current; // current의 자식 노드의 부모로 current를 저장
				queue.add(next);
			}
		}
	}

	private static void dfs(int start) {
		// 1. 스택에 시작점(루트) 넣기
		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		// 2. dfs (스택이 빌 때까지 반복)
		while (!stack.isEmpty()) {
			// 2-1.스택에서 뺀 노드(현재 노드)를 출력하기
			int current = stack.pop();
			System.out.println(current);

			// 2-2. 현재 노드의 인접 노드들 중 부모 노드 제외하고 나머지를 스택에 넣고, 해당 노드들의 부모로 현재 노드를 저장하기
			for (int next : tree[current]) {
				if (next == parent[current]) { // current의 인접 노드 중 current의 부모 노드는 제외
					continue;
				}
				parent[next] = current; // current의 자식 노드의 부모로 current를 저장
				stack.push(next);
			}
		}
	}

	private static void dfsWithRecursion(int current) {
		System.out.println(current);
		for (int next : tree[current]) {
			if (next == parent[current]) {
				continue;
			}
			parent[next] = current;
			dfsWithRecursion(next);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 노드 수는 n, 에지 수는 n-1

		int[][] numbers = new int[n][2];
		for (int i = 1; i < n; i++) { // 에지 수만큼 반복
			String[] input = br.readLine().split(" ");
			numbers[i][0] = Integer.parseInt(input[0]);
			numbers[i][1] = Integer.parseInt(input[1]);
		}

		int[] answers = solution(n, numbers);
		for (int i = 2; i <= n; i++) {
			System.out.println(answers[i]);
		}

		br.close();
	}
}