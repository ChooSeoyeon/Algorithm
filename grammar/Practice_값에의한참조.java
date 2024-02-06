package grammar;

/*
[설명]
- 자바는 전부 call by value 임 (call by reference x)
- 그 이유는, 자바는 포인터가 아닌 참조 자료형을 사용하기 떄문임
- 포인터와 참조 자료형은 명백히 다름
- 포인터는 변수의 실제 메모리 주소값을 저장하는 반면,
- 참조 자료형도 주소 저장해.... 그럼 뭐가 다른데....
	- 자바의 메모리 주소값은 매 실행시마다 바뀌기에 (JVM이 컴퓨터의 메모리 동작할당함)
[접근]
-
[메모]
*/
public class Practice_값에의한참조 {
	private static void solution(Person person) {
		person.setId(3);
		person = new Person(5, "Choo"); // heap 영역에 새로운 객체가 생성됨
		System.out.println("새 참조값으로 id 변경 " + person.getId());
		System.out.println("새 참조값으로 이름 변경 " + person.getName());
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		java.util.Scanner sc = new java.util.Scanner(System.in);

		Person person = new Person(1, "Dora");

		person.setId(2);
		System.out.println("기본적인 id 변경 " + person.getId());

		solution(person); // heap 영역에 생성된 객체의 주소값 복사해 넘겨줌

		System.out.println("참조값으로 id 변경 " + person.getId());
		System.out.println("참조값으로 id 변경 " + person.getName());

		sc.close();
	}
}