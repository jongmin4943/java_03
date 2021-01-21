package java_ch03;

class People {
	People(){};
	
	//생성자는 멤버를 초기화 하는 목적이 있는 메소드
	//리턴하지 않고 리턴형도 없다.
	//생성자 메소드의 이름은 클래스 이름과 동일해야한다.
	//생성자도 함수이므로 함수의 다른 특징을 모두 가진다.
	//생성자 Overload 생성자 재정의
	People(String name, String phone, String address){
		this.name = name;
		this.phone = phone;
		this.address = address;
	};
	String name;
	String phone;
	String address;

	
	//재정의 - Override
	@Override
	public String toString() {
//		return "["+name + ", " + phone + ", address=" + address + "]";
		return String.format("%-6s\t%-17s\t%s\n", name, phone, address);
	}
}



public class Ch03Ex03PointEx {

	
	public static void main(String[] args) {
//		People kim = new People();
//		kim.name = "김유신";
//		kim.phone = "010-1234-5678";
//		kim.address = "서울시 종로구 견지동";
		People kim = new People("윤종민","010-2313-1323","서울시 강북구");
		
		System.out.println(kim.toString());
	}
}
