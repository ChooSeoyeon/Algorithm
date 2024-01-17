package temp;

/*
[설명] https://www.acmicpc.net/problem/17298
- 크기가 N인 수열의 각 원소에 대해 오큰수(i) 구하기
- 오큰수란 Ai의 오른쪽에 있으면서 Ai보다 큰 수 중 가장 왼쪽에 있는 수
	- Ai보다 인덱스가 크면서 Ai보다 큰 수 중 Ai와 가장 가까운 수
	- Ai보다 나중에 들어왔으면서 Ai보다 큰 수 중 가장 빨리 들어온 수
- 조건 맞는 오큰수 존재하지 않으면 오큰수는 -1
[접근] 스택. 투포인터로도 풀 수 있을 듯..? 투 포인터에서 아래 접근 떠올림
- Ai보다 Aj가 크다면, Aj의 오큰수는 Ai의 오큰수보다 뒤에 있음
	- 스택의 가장 상단값(타깃에 가장 가까운 수)부터 pop 해가며 오큰수 찾아나가기
		(오큰수 전부터 오큰수까지 싹다 pop)
- Ai보다 Aj가 작거나 같다면, Aj의 오큰수는 Ai의 오큰수와 같음
	- 오큰수 전부터 오큰수까지 싹다 pop 해져있는 상태이니, 스택은 건들지 않음
- 준비
	- 수열 준비 : 수열의 맨 앞(index 0) 값은 0으로 두기
	- 스택 준비 : 스택에 수열을 잎에서부터 넣어놓기
- 수열을 index 1 값부터 차례로 접근
	- 현재 값을 이전 값과 비교
		- 현재값 > 이전값 : 새 오큰수 찾을 때까지 pop
			- 오큰수 찾으면 오큰수도 pop, 정답에 오큰수를 기록
		- 현재값 <= 이전값 : 이전값의 오큰수 재활용
			- 정답에서 바로 전 정답과 같은 정답을 오큰수로 기록
	- 어떤 수열에 대해선
[메모]
- 수열 개수 10^6 -> 10^8 만 넘어가도 1초 시간 제한 넘어감
- O(N) 혹은 O(NlogN) 이어야 함
*/
public class Baekjoon17298_오큰수 {
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