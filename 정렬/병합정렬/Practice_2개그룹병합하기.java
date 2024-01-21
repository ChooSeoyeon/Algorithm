package 정렬.병합정렬;

/*
[설명]
- 오름차순 정렬하기
[접근] 병합정렬로 풀기
- 가장 작은 단위로 쪼개기
- 두 그룹씩 합하기
	- 두 정렬된 배열을 하나의 정렬된 배열로 합치기
[메모]
*/
public class Practice_2개그룹병합하기 {
	private static int solution(int n, int[] numbers) {
		int half = n / 2;

		int[] a = new int[half];
		for (int i = 0; i < half; i++) {
			a[i] = numbers[i];
		}

		int[] b = new int[n - half];
		for (int i = half; i < n; i++) {
			int j = i - (n / 2);
			b[j] = numbers[i];
		}

		int[] result = merge(a, b);
		for (int r : result) {
			System.out.println("r = " + r);
		}

		return n;
	}

	private static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int left = 0, right = 0;
		for (int i = 0; i < result.length; i++) {
			if (left == a.length) {
				result[i] = b[right++];
			} else if (right == b.length) {
				result[i] = a[left++];
			} else if (a[left] <= b[right]) { // 합병 정렬의 stable sort 성질 만족시키기 위해서 크기 같을 땐 앞 쪽에 들어가게 해줌
				result[i] = a[left++];
			} else {
				result[i] = b[right++];
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(solution(n, numbers));

		sc.close();
	}
}