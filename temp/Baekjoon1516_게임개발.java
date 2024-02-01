package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
[설명]
- 전략 시뮬레이션 게임에서 종족별 균형과 전체 게임 시간 조절해야 함
- 게임 플레이 소요 시간은 모든 건물을 짓는데 걸리는 최소 시간 이용해 근사
- 어떤 건물 지으려면 다른 건물 먼저 지어야 할 수도 있음 (벙커 지으려면 배럭 먼저 지어야함)
- 여러 개의 건물을 동시에 지을 수 있음
[접근] 가중치 있는 위상정렬
1. 그래프를 인접리스트로 표현하고, inDegree 배열과 time 배열 생성하기
2. inDegree가 0인 노드들을 큐에 넣기
3. 큐에서 뺀 노드를 정렬 결과에 넣고, 해당 노드가 가리키는 노드들의 inDegree를 1 감소시키고, 0이 된 노드들은 큐에 넣기
	- 큐에서 뺄 땐 건물 짓는 시간 적은 노드(가중치 작은 노드)부터 빼기 (!주의!)
4. 큐가 빌 때까지 3을 반복
[메모]
- 위상정렬 택한 이유
	- 각 건물들을 짓는 선후관계 명확히 주어짐 -> 방향 그래프 o
	- 모든 건물을 짓는 게 가능한 입력만 주어진다 나와있음 -> 사이클 x
- 위상정렬 쓸 때 주의할 점
	- 큐에 0인 노드 여러 개 있을 때 아무거나 빼면 안되고, 그 중 건물 짓는 시간 가장 적은 노드부터 빼야 함
	- 가중치 이용하기
[오딥]
- 먼저 지어야 하는 거랑 나중에 지어야 하는 거랑 반대로 입력 받아서 틀릴뻔함 (눈치 채고 알아서 고침)
*/
public class Baekjoon1516_게임개발 {
	public class Node {
		private int end;
		private int weight;
	}

	private static ArrayList<Node>[] graph;
	private static int[] time;
	private static int[] inDegree;

	private static int[] solution(int n) {
		// 2. inDegree가 0인 노드들을 큐에 넣기
		ArrayList<Integer> queue = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		Collections.sort(queue, (o1, o2) -> time[o2] - time[o1]);

		// 3. 큐에서 뺀 시간 가장 적은 노드를 정렬 결과에 넣고, 해당 노드가 가리키는 노드들의 inDegree를 1 감소시키고, 0이 된 노드들은 큐에 넣기
		ArrayList<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int target = queue.get(0);
			queue.remove(0);
			result.add(target);
			// for (int next : graph[target]) {
			// 	inDegree[next]--;
			// 	if (inDegree[next] == 0) {
			// 		queue.add(next);
			// 	}
			// }
			Collections.sort(queue, (o1, o2) -> time[o2] - time[o1]);
		}

		int[] answer = new int[result.size()];
		answer[0] = time[result.get(0)];
		for (int i = 1; i < result.size(); i++) {
			answer[i] = answer[i - 1] + time[result.get(i)];
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 1. 그래프를 인접리스트로 표현하고, inDegree 배열과 time 배열 생성하기
		time = new int[n + 1];
		inDegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");
			time[i] = Integer.parseInt(input[0]);
			for (int j = 1; j < input.length - 1; j++) {
				int prev = Integer.parseInt(input[j]);
				int weight = time[i];
				// graph[prev].add(new Node(i, weight));
				inDegree[i]++;
			}
		}

		int[] answers = solution(n);
		for (int answer : answers) {
			System.out.println(answer);
		}

		br.close();
	}
}