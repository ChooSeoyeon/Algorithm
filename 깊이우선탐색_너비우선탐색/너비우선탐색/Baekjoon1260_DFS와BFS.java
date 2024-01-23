package 깊이우선탐색_너비우선탐색.너비우선탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
[설명]
- DFS와 BFS로 탐색한 결과를 각각 출력하기
- 단, 방문할 수 있는 점점 여러 개일 땐 정점 번호 작은 것을 먼저 방문
[접근]
- 정렬 먼저 해두고, dfs bfs 적용하기
- 공통
	- 그래프 만들기 (간선은 정렬해서 넣어두어야 함)
	- 방문 배열 만들기 (dfs, bfs 돌릴 때 각각 초기화 필요)
- dfs (with 재귀)
	- 인자에 있는 노드에 대해 방문 여부 true로 찍고 동시에 출력하기 (방문과 탐색 동시에)
	- 인접 노드들을 인자에 넣어 재귀 (작은 수부터 함수 호출하기)
- dfs (with 스택)
	- 스택에서 빼온 노드에 대해 출력하기 (탐색은 나중에 함)
	- 인접 노드들의 방문 여부 true로 찍기 (방문을 먼저함)
	- 인접 노드들을 스택에 넣고 반복 (큰 수부터 스택에 넣기 -> 작은 수 먼저 나옴)
- bfs (with 큐)
	- 큐에서 빼온 노드에 대해 출력하기 (탐색은 나중에 함)
	- 인접 노드들의 방문 여부 true로 찍기 (방문을 먼저함)
	- 인접 노드들을 큐에 넣고 반복 (작은 수부터 큐에 넣기 -> 작은 수 먼저 나옴)
[메모]
- 정점 번호는 1번부터 N번까지라고 주어졌음
- 인접 노드는 방문 안 한 인접 노드를 의미함
- 일단 함수에서 출력하고, 후에 stringbuilder 쓰게 리팩토링하기
- 결국은 전부 true -> 출력 -> true -> 출력 ... 꼴을 보임! 그림으로 정리하면 좋을 듯
*/
public class Baekjoon1260_DFS와BFS {
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	private static void solution(int n, int m, int startNode, int[][] originGraph) {
		initGraph(n, m, originGraph);

		initVisited(n);
		dfs(startNode);
		System.out.println();

		// initVisited(n);
		// dfsWithStack(startNode);
		// System.out.println();

		initVisited(n);
		bfs(startNode);
	}

	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		for (int nearNode : graph[node]) {
			if (!visited[nearNode]) {
				dfs(nearNode);
			}
		}
	}

	private static void dfsWithStack(int startNode) {
		Stack<Integer> stack = new Stack<>();
		stack.push(startNode);
		visited[startNode] = true;

		while (!stack.isEmpty()) {
			int node = stack.pop();
			System.out.print(node + " ");
			for (int i = graph[node].size() - 1; i >= 0; i--) { // 큰 수부터 접근
				int nearNode = graph[node].get(i);
				if (!visited[nearNode]) {
					stack.push(nearNode);
					visited[nearNode] = true;
				}
			}
		}
	}

	private static void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		visited[startNode] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			for (int nearNode : graph[node]) {
				if (!visited[nearNode]) {
					queue.add(nearNode);
					visited[nearNode] = true;
				}
			}
		}
	}

	private static void initGraph(int n, int m, int[][] originGraph) {
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int u = originGraph[i][0];
			int v = originGraph[i][1];
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}
	}

	private static void initVisited(int n) {
		visited = new boolean[n + 1];
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int startNode = sc.nextInt();

		int[][] originGraph = new int[m][2];
		for (int i = 0; i < m; i++) {
			originGraph[i][0] = sc.nextInt();
			originGraph[i][1] = sc.nextInt();
		}

		solution(n, m, startNode, originGraph);

		sc.close();
	}
}