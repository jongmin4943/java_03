package org.comstudy21_ch03_2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	static Scanner scan = new Scanner(System.in);
	static Scanner scan2 = new Scanner(System.in);

	static final int MAX = 2;
	static Student[] stArr = new Student[MAX];
	static ArrayList<Student> stArr2 = new ArrayList<>();
	static int top = 0;

	static Student makeStudent() {
		Student student = new Student();
		System.out.println("성명>>>");
		student.name = scan2.nextLine();
		System.out.println("학과>>>");
		student.major = scan.next();
		System.out.println("성적>>>");
		student.score = scan.nextDouble();
		System.out.println("등수>>>");
		student.rank = scan.nextInt();

		return student;
	}

	static int menu() {
		int no = 0;
		System.out.println("1.input 2.output 3.search 4.modify 5.delete 6.exit");
		System.out.print("Choice>>> ");
		try {
			no = scan.nextInt();
		} catch (Exception e) {
			System.out.println("정수만 입력 가능합니다!");
			scan.nextLine();		//버퍼 비우기
			return menu();			//리턴으로 이 함수 종료와 함께 함수 재 호출, 재귀함수의 활용
		}
		return no;
	}

	static void input() {
		System.out.println("::: INPUT :::");
		//stArr배열의 top 번지에 객체를 생성하고 top++;
		if(top>=MAX) {
			System.out.println("더 이상 입력할 수 없습니다");
			return;
		}
		stArr[top++] = makeStudent();							//ArrayList
		System.out.println("입력 성공");
	}

	static void output() {										//ArrayList
		System.out.println("::: OUTPUT :::");
		for(int i = 0; i< top; i++) {
			System.out.println("["+(i+1)+"]"+stArr[i]);
		}
	}

	static void search() {
		scan.nextLine();
		System.out.println("::: SEARCH :::");
		System.out.print("학생의 이름을 입력해주세요 : ");
		String searching = null;								//ArrayList
		try {
			searching = scan.next();
		} catch (Exception e) {
			System.out.println("학생이름이 존재하지 않습니다.");// 이상한 문자가 들어오면 에러 제거
			scan.nextLine();							
		}
		for(int i = 0; i<top; i++) {
			if(searching.equals(stArr[i].name)) {
				System.out.println(stArr[i]);
				break;
			} else if(i == top-1) { 					// 루프를 다 돌았는데도 이름을 못찾으면 실행
				System.out.println("학생이름이 존재하지 않습니다.");
				search();
				break;
			}
		} 
	}

	static void modify() {
		System.out.println("::: MODIFY :::");
		System.out.println("수정할 번호를 선택해 주세요");
		output();
	}

	static void delete() {
		System.out.println("::: DELETE :::");
	}

	static void exit() {
		System.out.println("::: EXIT :::");
		System.out.println("프로그램을 종료합니다. \n수고하셨습니다!");
		System.exit(0); // 강제 종료! 다른방법은 메인 안의 while룹의 조건을 false로 만들어준다
	}

	public static void main(String[] args) {
		while (true) {
			int no = menu();
			switch (no) {
			case 1:
				input();
				break;
			case 2:
				output();
				break;
			case 3:
				search();
				break;
			case 4:
				modify();
				break;
			case 5:
				delete();
				break;
			case 6:
				exit();
				break;
			default :
				scan.nextLine();
				System.out.println("경고 : 해당사항 없습니다!");
			}
			System.out.println("----------------------------");
		}
	}
}
