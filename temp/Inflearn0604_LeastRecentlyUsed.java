package temp;

import java.util.LinkedList;
import java.util.Scanner;

/*
[설명]
- 캐시메모리는 임시 메모리로 cpu가 처리할 작업 저장해 뒀다가 바로 제공하는 장치인데, 용량 작아서 효율적으로 써야 함
- 캐시메모리 사용 규칙은 LRU(가장 오랫동안 사용하지 않은 것으르 제거) 알고리즘을 따름
	- 2,3,1,6,7 이라면 7이 가장 오랫동안 쓰이지 않은 작업임
	- 미스 : 새로운 작업 사용 -> 새로운 작업 맨 앞에 추가, 맨 뒤의 가장 오래된 작업 제거 (초기값은 0)
	- 히트 : 존재하는 작업 사용 -> 존재하는 작업 삭제 후 맨 앞에 추가
[접근] LinkedList
[매모]
*/
public class Inflearn0604_LeastRecentlyUsed {
	private static int[] solution(int s, int n, int[] numbers) {
		int[] answer = new int[s];
		LinkedList<Integer> link = new LinkedList<>();
		for (int i = 0; i < s; i++) {
			link.add(0);
		}

		for (int number : numbers) {
			if (link.contains(number)) {
				link.remove(number);
				link.add(number);
			} else {
				link.add(number);
				link.remove();
			}
		}

		System.out.println("link = " + link);

		return answer;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		int[] answers = solution(s, n, numbers);

		for (int answer : answers) {
			System.out.print(answer + " ");
		}
		sc.close();
	}
}
