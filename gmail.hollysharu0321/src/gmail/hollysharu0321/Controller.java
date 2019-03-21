package gmail.hollysharu0321;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Controller {
	public static void main(String[] args) {
		//@데이터베이스 연결 코드 작성 - preparedStatement 이용 
		
		//데이터베이스 연결 객체 만들기 
		//1.7 버전 이상에서 try() 안에서 
		//AutoCloseable 인터페이스를 구현한 클래스의 인스턴스를 생성하면 
		//close()를 호출하지 않아도 자동으로 close()를 호출함  
		try( Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.0.100:1521/XEPDB1",
				"user08", "user08");
			PreparedStatement pstmt = con.prepareStatement("insert into mydept(deptno, dname, loc) values(?,?,?)"); ) 
		
		{
			//드라이버 클래스 로드 : 접속할 데이터베이스 종류 설정 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결 확인을 위해서 출력 
			//System.out.printf("~~~접속 성공~~~\n");
			
			//데이터 바인딩 
			pstmt.setInt(1,  90);
			pstmt.setString(2, "회계");
			pstmt.setString(3,  "목동");
			
			//SQL 실행 
			int result = pstmt.executeUpdate();
			
			//결과 사용
			if(result > 0) {
				System.out.printf("데이터 삽입 성공");
			}
			
			
			
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
		}
		finally {

		}
		
		
		
		
		
		
	}
}