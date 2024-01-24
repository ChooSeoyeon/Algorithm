package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
[설명]
-
[접근]
-
[메모]
*/
public class BufferedWriter {
	private static int solution(int n) {
		return n;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		java.io.BufferedWriter bw = new java.io.BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}

		bw.write(solution(n));

		bw.flush();
		br.close();
	}
}