package gmail.hollysharu0321;

public class PatternMain {
	
	public static void main(String[] args) {
		//생성자르 2번 호출 : 인스턴스가 2개 
		//Pattern p1 = new Pattern(); 
		//Pattern p2 = new Pattern(); 

		Pattern p1 = Pattern.getInstance();
		Pattern p2 = Pattern.getInstance();
		
		//참조형 변수가 서로 다른 인스턴스를 가리키는 것을 확인 
		//해시코드를 출력 
		System.out.printf("p1: %s\n", p1.hashCode());
		System.out.printf("p2: %s\n", p2.hashCode());
		//싱글톤 클래스 만든 후에는 해시코드 같음 

		//Runtime 클래스의 인스턴스를 2개 이상 만들 수 없도록 
		//싱글톤 패턴으로 디자인해서 제공함 
		Runtime r1 = Runtime.getRuntime(); 
		Runtime r2 = Runtime.getRuntime(); 
		System.out.printf("r1: %s\n", r1.hashCode());
		System.out.printf("r2: %s\n", r2.hashCode());
		
		
		
	}

}
