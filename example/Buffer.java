package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
-
[접근]
-
[메모]
*/
public class Buffer {
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		System.out.println("T = " + T);

		br.close();
	}
}