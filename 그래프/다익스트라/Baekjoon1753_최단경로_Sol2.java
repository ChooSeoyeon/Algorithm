package 그래프.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
[설명]
- 방향그래프에서 주어진 시작점에서 다른 모든 정점으로의 최단 경로 구하기
- 모든 간선의 가중치는 10 이하의 자연수
- 서로 다른 두 정점 사이에 여러 간선이 존재할 수도 있음
[접근] 다익스트라
0. 가중치 있는 그래프를 인접리스트로 표현하기
1. 우선순위 큐에 (거리, 노드)꼴로 (0, 시작점)을 추가, 최단 거리 배열은 큰수로 초기화
2. 우선순위 큐에서 거리가 가장 작은 원소를 선택(pop)하고, 한 번도 선택된 적이 없는 노드라면 최단 거리 배열에 원소의 가중치 값 넣기
3. 선택한 노드와 이웃한 노드가 한 번도 선택된 적이 없는 노드라면, 우선순위 큐에 (거리, 노드)를 추가
4. 우선순위 큐 빌 때까지 2,3을 반복
[메모]
- 다익스트라를 택한 이유
	- 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 문제라서
	- 간선의 가중치가 음수가 아니라서
- comparable vs comparator
	- comparable : 자기 자신과 매개변수 객체를 비교
	 	-> compareTo(T o) 재정의(override)
	- comparator : 두 매개변수 객체를 비교
	 	-> compare(T o1, T o2) 구현
*/
public class Baekjoon1753_최단경로_Sol2 {
	private static final int INFINITE = 99_999_999;

	private static class Edge implements Comparable<Edge> {
		int weight;
		int node;

		private Edge(int weight, int node) {
			this.weight = weight;
			this.node = node;
		}

		public int compareTo(Edge e) {
			if (this.weight > e.weight) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	// numbers[edge+1][3]는 edge개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수(u, v, w)로 구성. 세 정수는 u에서 v로 가는 가중치 w인 간선을 의미
	private static String solution(int vertex, int edge, int start, int[][] numbers) {
		// 0. 가중치 있는 그래프를 인접리스트로 표현하기
		ArrayList<Edge>[] graph = new ArrayList[vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= edge; i++) {
			int u = numbers[i][0];
			int v = numbers[i][1];
			int w = numbers[i][2];
			graph[u].add(new Edge(w, v));
		}

		// 1. 우선순위 큐에 (거리, 노드)꼴로 (0, 시작점)을 추가, 최단 거리 배열은 큰수로 초기화
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, start));

		int[] distance = new int[vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			distance[i] = INFINITE;
		}

		while (!pq.isEmpty()) {
			// 2. 우선순위 큐에서 거리가 가장 작은 원소를 선택(pop)하고, 한 번도 선택된 적이 없는 노드라면 최단 거리 배열에 원소의 가중치 값 넣기
			Edge select = pq.poll();
			if (distance[select.node] != INFINITE) {
				continue;
			}
			distance[select.node] = select.weight;

			// 3. 선택한 노드와 이웃한 노드가 한 번도 선택된 적이 없는 노드라면, 우선순위 큐에 (거리, 노드)를 추가
			for (Edge near : graph[select.node]) {
				if (distance[near.node] != INFINITE) {
					continue;
				}
				pq.add(new Edge(distance[select.node] + near.weight, near.node));
			}
		}

		// 최단 경로 배열을 출력 형식에 맞추기
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= vertex; i++) {
			if (distance[i] == INFINITE) {
				answer.append("INF\n");
			} else {
				answer.append(distance[i]).append("\n");
			}
		}

		return answer.toString();
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int v = Integer.parseInt(input[0]);
		int e = Integer.parseInt(input[1]);
		int s = Integer.parseInt(br.readLine());

		int[][] numbers = new int[e + 1][3];
		for (int i = 1; i <= e; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				numbers[i][j] = Integer.parseInt(input[j]);
			}
		}

		System.out.println(solution(v, e, s, numbers));

		br.close();
	}
}