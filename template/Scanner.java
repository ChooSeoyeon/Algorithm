package template;

public class Scanner {
	private static int solution(int n) {
		return n;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(solution(n));

		sc.close();
	}
}