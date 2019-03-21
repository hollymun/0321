package DTO;
//DTO 클래스 
//Data Transfer Object - Variable object라고도 함 
//여러 개의 데이터를 묶어서 하나로 표현하기 위한 클래스 
public class MyDEPT {

	private int deptNo;
	private String dname;
	private String loc;

	// 접근자 메소드 생성
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "MyDEPT [deptNo=" + deptNo + ", dname=" + dname + ", loc=" + loc + "]";
	}

}
