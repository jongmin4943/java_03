package java_ch03;

import java.util.Scanner;

class Student {
	String name;
	String major;
	double score;
	int rank;
	Student(){
		//디폴트 생성자
	}
	//오버로드 - 같은 클래스 같은 이름의 메소드를 추가 해준다.
	//시그너처 - 매개변수의 타입과 갯수가 된다.
	Student(String name, String major, double score, int rank){
		this.name = name;
		this.major = major;
		this.score = score;
		this.rank = rank;
	}
	
	//오버라이드 - 상속관계 부모의 멤버를 재정의 한다.
	@Override
	public String toString() {
//		return "[성명=" + name + ", 학과=" + major + ", 성적=" + score + ", 등수=" + rank + "]";
		return String.format("성명 = %s, 학과 = %s, 성적 = %.01f, 등수 = %d\n", name, major, score, rank);
	}
}

public class Ch03Ex04StudentEx {
	static Scanner scan = new Scanner(System.in);
	
	static final int MAX = 50;
	static Student[] stArr = new Student[MAX];
	static int top = 0;
	
	static Student makeStudent() {
		Student student = new Student();
		System.out.println("성명>>>");
		student.name = scan.next();
		System.out.println("학과>>>");
		student.major = scan.next();
		System.out.println("성적>>>");
		student.score = scan.nextDouble();
		System.out.println("등수>>>");
		student.rank = scan.nextInt();
		
		return student;
	}
	
	public static void main(String[] args) {
		Student[] arr = new Student[2];
		
		//생성자 오버로딩이 되었을때는 디폴트 생성자를 명시적으로 추가 해야한다.
		//생성자 오버로딩 되었을때는 컴파일러가 디폴트 생성자를 만들지 않는다
		for(int i=0; i<arr.length; i++) {
			arr[i] = makeStudent();
		}
//		System.out.println(Arrays.toString(arr));
		
		for(Student st : arr) {
			System.out.println(st);
		}
		
	}
	


	public static void test(String[] args) {
		//						   성명		학과		성적,등수
		Student kim = new Student("홍길동","컴퓨터공학",4.5,10);
		Student lee = new Student("이순신","전술과",5.0,1);
		Student park = new Student("박혁거세", "창업과", 4.8, 1);
//		System.out.println(kim);
//		System.out.println(lee);
//		System.out.println(park);
		Student[] stdArr = new Student[3];// stdArr 4바이트 =  [3]이니 12바이트
		stdArr[0] = kim;
		stdArr[1] = lee;
		stdArr[2] = park;
		
		stdArr[1].name = "이순자";
		stdArr[1].major = "가정학과";
		
		for(Student a : stdArr) {
			System.out.println(a);
		}
	}
}
