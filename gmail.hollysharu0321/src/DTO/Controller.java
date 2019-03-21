package DTO;

import java.util.List;

public class Controller {
	public static void main(String[] args) {
		DeptDAO dao = DeptDAOImpl.getInstance();
/*	
		//추가할 데이터 생성 
		MyDEPT myDEPT = new MyDEPT(); 
		//myDEPT.setDeptNo(100);
		//ORA - 이 열에 대해 지정된 전체 자릿수보다 큰 값이 허용됩니다 
		//지정된 자릿수보다 큰 데이터가 들어갔다는 뜻 
		//아래 데이터를 하나씩 고쳐보며 확인 

		myDEPT.setDeptNo(8);
		myDEPT.setDname("대기");
		myDEPT.setLoc("휴게실");
		
		int result = dao.insertMyDEPT(myDEPT);
		if(result == -1) {
			System.out.printf("삽입 실패\n");
		}
		else {
			System.out.printf("삽입 성공\n");
		}
		
		int result = dao.deleteMyDEPT(8);
		if(result == -1) {
			System.out.printf("수정 실패\n");
		}
		else {
			System.out.printf("수정 성공\n");
		}

		//여러 개의 데이터를 리턴하는 메소드는 
		//예외가 발생하거나 데이터가 없는 경우네 size가 0인 상태로 리턴
		List<MyDEPT> list = dao.listMyDEPT();
		for(MyDEPT myDEPT : list) {
			System.out.printf("%s\n", myDEPT);
		}
*/
		
		//하나의 데이터를 리턴하는 메소드 
		MyDEPT myDEPT = dao.getMyDEPT(90);
		System.out.printf("%s\n", myDEPT);
	
		
		
	}	
}
