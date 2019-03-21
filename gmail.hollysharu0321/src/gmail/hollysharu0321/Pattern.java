package gmail.hollysharu0321;

public class Pattern {
	//생성자를 private으로 생성해서 외부에서 new를 호출할 수 없도록 함
	private Pattern() { /* 한번만 수행해야 할 내용이 있다면 여기에 적으면 됨! - 아래 if구문 때문 */}
	
	//자기 자신의 static 변수를 생성 
	private static Pattern pattern; 
	
	//인스턴스의 참조를 넘겨주는 static 메소드 
	public static Pattern getInstance() {
		//한번 생성되고 나면 null일 수 없으므로 최초 한 번만 생성된 후, pattern을 리턴함 
		if(pattern == null) {
			pattern = new Pattern(); 
		}
		return pattern; 
	}
	
	
	
}