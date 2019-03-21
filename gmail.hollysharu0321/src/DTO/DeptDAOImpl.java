package DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO 클래스나 서버가 작업에 사용하는 클래스는 싱글톤 패턴을 이용해서 디자인 
public class DeptDAOImpl implements DeptDAO {

	// @싱글톤 패턴 만드는 방법
	// 생성자 private으로 만듦
	// 여기 작성된 내용은 맨 처음 한번만 수행됨
	private DeptDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.printf("드라이버 로드:%s\n", e.getMessage());
		}
	}

	// 자기 자신의 자료형으로 static 변수 선언
	// deptDAOImpl가 아닌 인터페이스로 만듦
	private static DeptDAO deptDAO;

	// 인스턴스를 생성해서 참조를 리턴하는 static 메소드를 구현
	public static DeptDAO getInstance() {
		if (deptDAO == null) {
			deptDAO = new DeptDAOImpl();
		}
		return deptDAO;
	}

	@Override
	public int insertMyDEPT(MyDEPT myDEPT) {
		// 결과를 리턴할 변수는 보통 음수로 초기화
		// 성공했을 때 양수가 리턴되기 때문에 음수는 실패여부를 구분할 수 있게 함
		int result = -1;
		try (
				// 데이터베이스 연결
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.100:1521/XEPDB1", "user08",
						"user08");
				PreparedStatement pstmt = con
						.prepareStatement("insert into mydept(deptno, dname, loc) values(?,?,?)");) {
			// sql의 ?에 데이터 바인딩
			pstmt.setInt(1, myDEPT.getDeptNo());
			pstmt.setString(2, myDEPT.getDname());
			pstmt.setString(3, myDEPT.getLoc());
			// SQl을 실행하고 그 결과를 result에 저장
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// 어떤 작업을 하다가 예외가 발생했는지 확인하기 위해서
			// 예외 메시지 앞에 태그를 추가
			System.out.printf("삽입 예외:%s\n", e.getMessage());
		}
		return result;
	}

	@Override
	public int updateMyDEPT(MyDEPT myDEPT) {
		// 결과를 리턴할 변수는 보통 음수로 초기화
		// 성공했을 때 양수가 리턴되기 때문에 음수는 실패여부를 구분할 수 있게 함
		int result = -1;
		try (
				// 데이터베이스 연결
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.100:1521/XEPDB1", "user08",
						"user08");
				PreparedStatement pstmt = con
						.prepareStatement("update mydept set dname = ?, loc = ? where deptno = ?");) {
			// sql의 ?에 데이터 바인딩
			pstmt.setString(1, myDEPT.getDname());
			pstmt.setString(2, myDEPT.getLoc());
			pstmt.setInt(3, myDEPT.getDeptNo());

			// SQl을 실행하고 그 결과를 result에 저장
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.printf("수정 예외:%s\n", e.getMessage());
		}
		return result;
	}

	// 삭제하는 메소드 - 일반적으로 테이블의 기본키를 매개변수로 받아서 삭제
	@Override
	public int deleteMyDEPT(int deptno) {
		int result = -1;
		try (
				// 데이터베이스 연결
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.100:1521/XEPDB1", "user08",
						"user08");
				PreparedStatement pstmt = con.prepareStatement("delete from mydept where deptno = ?");) {
			// sql의 ?에 데이터 바인딩
			pstmt.setInt(1, deptno);

			// SQl을 실행하고 그 결과를 result에 저장
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.printf("수정 예외:%s\n", e.getMessage());
		}
		return result;
	}

	@Override
	public List<MyDEPT> listMyDEPT() {
		//List를 리턴할 때는 List의 인스턴스를 생성하고 리턴 
		//실패하거나 읽은 데이터가 없을 때에는 List의 size가 0 
		List<MyDEPT> list = new ArrayList<MyDEPT>(); 
		try (
				//데이터베이스 연결 
				Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.100:1521/XEPDB1", "user08", "user08");
				PreparedStatement pstmt = con.prepareStatement(
						"select * from mydept"); 
		){
			//sql의 ?에 데이터 바인딩 
				//? 없으면 생략 
			//SQl을 실행하고 그 결과를 result에 저장 
			ResultSet rs = pstmt.executeQuery();
			//끝까지 데이터 읽기 
			while(rs.next()) {
				MyDEPT myDEPT = new MyDEPT(); 
				//컬럼이름 대소문자 구별 안 함 
				myDEPT.setDeptNo(rs.getInt("deptno"));
				myDEPT.setDname(rs.getString("dname"));
				myDEPT.setLoc(rs.getString("loc"));
				
				list.add(myDEPT);
			}
		}catch(Exception e) {
		System.out.printf("수정 예외:%s\n",  e.getMessage());
	}
		return list;
	}

	@Override
	public MyDEPT getMyDEPT(int deptno) {
		//하나를 리턴하는 메소드는 인스턴스를 생성하지 않은 상태로 리턴 
		//성공했을 때는 null이 아닌 데이터를 리턴하도록 만듦
		//데이터를 못 찾은 경우는 null을 리턴함 
		MyDEPT myDEPT = null;
		
		try (
				//데이터베이스 연결 
				Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.100:1521/XEPDB1", "user08", "user08");
				PreparedStatement pstmt = con.prepareStatement(
						"select * from mydept where deptno = ?"); 
		){
			//sql의 ?에 데이터 바인딩 
			pstmt.setInt(1,  deptno);
			//SQl을 실행하고 그 결과를 result에 저장 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				myDEPT = new MyDEPT(); 
				myDEPT.setDeptNo(rs.getInt("deptno"));
				myDEPT.setDname(rs.getString("dname"));
				myDEPT.setLoc(rs.getString("loc"));
			}

		}catch(Exception e) {
			System.out.printf("목록 가져오기:%s\n",  e.getMessage());
		}
		
		
		return myDEPT;
	}

	
}
