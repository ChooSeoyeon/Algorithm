package 정렬.병합정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
[설명]
- 오름차순 정렬하기
[접근] 병합정렬로 풀기
- 가장 작은 단위로 쪼개기
- 두 그룹씩 합하기
	- 두 정렬된 배열을 하나의 정렬된 배열로 합치기
[메모]
[오답]
- sout 썼다가 시간 초과 남. 개행 문자 따로 빼도 시간 초과 남. bufferwriter 필수로 써야 했음. 그리고 이걸로 끝이 아니었음.
- 배열을 로컬 변수로 각각 가지고 있다가 인자로 넘겨주는 방식에서, static 전역 변수로 갖고 있게 바꿨더니 시간 초과 해결됨 (왤까?)
	- 메모리 내 위치에 따른 속도 차이는 없으므로, 캐시 적중률 차이일것이다?
	- call by value냐 call by reference 냐의 차이이다?
		- 후자가 더 영향이 크다. 자바는 무조건 call by value인데,
		- call by value의 경우 주소로 접근해 값을 사용하는 게 아니라, 새로운 값을 할당해 호출하게 된다
		- call by value는 call by reference에 비해 새로 메모리 영역에 값을 할당하는 비용이 커 시간적 공간적 손해가 있다
*/
public class Baekjoon2751_수정렬하기2 {
	private static int[] numbers;
	private static int[] temp;

	private static void solution(int n) {
		mergeSort(0, n);
	}

	private static void mergeSort(int start, int end) {
		if (end - start == 1) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid, end);
		merge(start, end);
	}

	private static void merge(int start, int end) {
		int mid = (start + end) / 2;
		int left = start;
		int right = mid;
		for (int i = start; i < end; i++) {
			if (left == mid) {
				temp[i] = numbers[right++];
			} else if (right == end) {
				temp[i] = numbers[left++];
			} else if (numbers[left] <= numbers[right]) { // 합병 정렬의 stable sort 성질 만족시키기 위해서 크기 같을 땐 앞 쪽에 들어가게 해줌
				temp[i] = numbers[left++];
			} else {
				temp[i] = numbers[right++];
			}
		}
		for (int i = start; i < end; i++) {
			numbers[i] = temp[i];
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		temp = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		solution(n);
		for (int i = 0; i < n; i++) {
			bw.write(numbers[i] + "\n");
		}

		bw.flush();
		br.close();
	}
}