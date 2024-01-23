package 깊이우선탐색_너비우선탐색.깊이우선탐색;

import java.util.ArrayList;

/*
[설명]
- 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수 구하기
[접근] DFS 로 구현해보자 (bfs로 풀어도 상관 없긴 함)[
1. 임의의 시작 노드에서 dfs 실행
	- dfs 실행하며 방문한 노드들은 전부 하나의 연결 오소에 들어간 거임
2. dfs 실행 후 방문하지 않은 노드 중 하나를 시작 노드로 삼아 다시 dfs 실행
	- 이때, 이전 방문 기록은 그대로 유지하여 방문하지 않은 노드들 대상으로만 탐색함
3. 방문하지 않은 노드가 하나도 없을 때까지 2번 반복
	- 시작 노드 새로 잡아서, dfs 돌리는 걸 한 과정이라 봤을 떄 이 과정(2번)을 몇 번 했는지가 정답임
[메모]
- 주어지는 간선의 양 끝점 u,v가 1~N 사이의 숫자들이라 주어지고 여기서 N은 정점의 개수라서, 초기화가 쉬웠음
	- N개의 서로 다른 숫자를 점들이 1~N 사이의 숫자들로 이뤄져있다면, 1~N까지 모든 숫자가 정점으로 등장할 거임
	- 이때, 정점이 안주어졌을 떄 어떻게 구할지도 생각해보기
[오답]
- 재귀 구조로 dfs 구현하는 건 혼자 생각하다가 스택이랑 헷갈려서 교재 코드 참고함
- i로 탐색해야 하는데, 실수로 n 넣어놔서 안됐었음
*/
public class Baekjoon11724_연결요소의개수 {
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	private static int solution(int n, int m, int[][] originGraph) {
		int count = 0;
		initGraph(n, m, originGraph);
		initVisit(n);

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		return count;
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
	}

	private static void initVisit(int n) {
		visited = new boolean[n + 1]; // default 값이 false
	}

	private static void dfs(int node) {
		visited[node] = true;

		for (int nearNode : graph[node]) {
			if (!visited[nearNode]) {
				dfs(nearNode);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] originGraph = new int[m][2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				originGraph[i][j] = sc.nextInt();
			}
		}

		System.out.println(solution(n, m, originGraph));

		sc.close();
	}
}