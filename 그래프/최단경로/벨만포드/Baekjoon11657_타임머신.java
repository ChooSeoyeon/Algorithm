package 그래프.최단경로.벨만포드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[설명]
- n개의 도시 있음. 한 도시에서 출발해 다른 도시에 도착하는 m개의 버스 있음. 각 버스를 타고 가는 데 걸리는 시간 있음. 시간은 음수일 수도 있음
- 1번 도시에서 나머지 도시로 가는데 필요한 시간의 최솟값 구하기
	- 각 도시로 가는 데 걸리는 시간을 빠른 순으로 출력
	- 특정 도시로 가는 경로 없다면 -1 출력
	- 음수 사이클 존재한다면 -1 출력
[접근] 벨만포드
1. 그래프를 에지 리스트로 표현하고, 최단거리 리스트(0,무한대) 초기화
2. 최단거리를 사용하는 에지 개수 점차 늘려가며 업데이트 (D[s]!=무한대 && D[e]>D[s]+w 일 때, D[s]+w로 업데이트)
3. 음수 사이클 존재하는지 확인
[메모]
- 벨만포드 택한 이유
	- 음수 간선 존재함
	- 한 노드에서 여러 노드로 가는 최단거리 구해야 함
[오답]
- 출력초과 -> distance 배열 int 타입에서 long 타입으로 변경해 해결
*/
public class Baekjoon11657_타임머신 {
	private static final int START = 1;
	private static final int INFINITE = 99_999_999;

	private static String solution(int n, int m, int[][] numbers) {
		// 1. 그래프를 에지 리스트로 표현하고, 최단거리 리스트(0,무한대) 초기화
		long[] distance = new long[n + 1];
		Arrays.fill(distance, INFINITE);
		distance[START] = 0;

		// 2. 최단거리를 사용하는 에지 개수 점차 늘려가며 업데이트 (D[s]!=무한대 && D[e]>D[s]+w 일 때, D[s]+w로 업데이트)
		for (int i = 1; i <= m; i++) { // 경로에 사용할 에지의 개수 : 1 ~ m개
			// 위 반복문 한 번 돌 때마다 시작점으로부터 연결되어 무한대가 아니게 갱신되는 뎁스가 1씩 증가함. 즉, 경로에 들어간 에지 개수가 1씩 증가함.
			for (int j = 1; j <= m; j++) { // 경로에 들어갈 수 있는지 살펴볼 에지 번호
				int start = numbers[j][0];
				int end = numbers[j][1];
				int weight = numbers[j][2];
				if (distance[start] != INFINITE && distance[end] > distance[start] + weight) {
					// 시작점과 연결되어 있고, 이전 경로보다 해당 에지를 사용한 경로가 더 최단 경로라면 업데이트
					distance[end] = distance[start] + weight;
				}
			}
		}

		// 3. 음수 사이클 존재하는지 확인
		boolean isMinusCycle = false;
		for (int j = 1; j <= m; j++) {
			int start = numbers[j][0];
			int end = numbers[j][1];
			int weight = numbers[j][2];
			if (distance[start] != INFINITE && distance[end] > distance[start] + weight) {
				isMinusCycle = true;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		if (!isMinusCycle) {
			for (int i = 1; i <= n; i++) {
				if (i == START) {
				} else if (distance[i] != INFINITE) {
					stringBuilder.append(distance[i]).append("\n");
				} else {
					stringBuilder.append(-1).append("\n");
				}
			}
		} else {
			stringBuilder.append(-1);
		}

		return stringBuilder.toString();
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 도시 수 = 노드 수
		int m = Integer.parseInt(input[1]); // 버스 노선 수 = 에지 수

		int[][] numbers = new int[m + 1][3];
		for (int i = 1; i <= m; i++) {
			input = br.readLine().split(" ");
			numbers[i][0] = Integer.parseInt(input[0]);
			numbers[i][1] = Integer.parseInt(input[1]);
			numbers[i][2] = Integer.parseInt(input[2]);
		}

		System.out.println(solution(n, m, numbers));

		br.close();
	}
}