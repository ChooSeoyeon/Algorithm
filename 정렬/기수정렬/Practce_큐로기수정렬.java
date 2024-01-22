package 정렬.기수정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
[설명]
- 오름차순 정렬하기
- 10000보다 작거나 같은 자연수
[접근] 기수 정렬로 풀기
- 자릿수 5로 취급하고, 5번 반복
	- 1의 자릿수 보고서, 큐에 넣기
	- 10의 자릿수 보고서, 큐에 넣기
	...
	- 1000의 자릿수 보고서, 큐에 넣기
	- 10000의 자릿수 보고서, 큐에 넣기
[메모]
*/
public class Practce_큐로기수정렬 {
	private static int[] numbers;
	private static int[] powerOfTen = new int[5];

	private static void initPowerOfTen() {
		powerOfTen[0] = 1;
		for (int i = 1; i < 5; i++) {
			powerOfTen[i] = powerOfTen[i - 1] * 10;
		}
	}

	private static int findDigitNum(int x, int a) {
		return (x / powerOfTen[a]) % 10; // 10^a
	}

	private static void solution(int n, int maxSize) {
		initPowerOfTen();

		Queue<Integer> temp = new LinkedList<>();
		for (int number : numbers) {
			temp.add(number);
		}

		Queue<Integer>[] digitList = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			digitList[i] = new LinkedList<>();
		}

		for (int i = 0; i < maxSize; i++) {
			while (!temp.isEmpty()) {
				int number = temp.poll();
				int digitNumber = findDigitNum(number, i);
				digitList[digitNumber].add(number);
			}
			for (int j = 0; j < 10; j++) {
				while (!digitList[j].isEmpty()) {
					temp.add(digitList[j].poll());
				}
			}
		}

		for (int i = 0; i < n; i++) {
			numbers[i] = temp.remove();
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		solution(n, 5);

		for (int i = 0; i < n; i++) {
			bw.write(numbers[i] + "\n");
		}

		bw.flush();
		br.close();
	}
}

