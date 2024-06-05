package org.big;

public class DeptDto {
	
	private int deptno;
	private String dname;
	private String loc;
	
	public DeptDto() {
		// TODO Auto-generated constructor stub
	}
	
	public DeptDto(int deptno, String dname, String loc) {
		// TODO Auto-generated constructor stub
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getDeptno() {
		return deptno;
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

	public void setDeptno(int deptno) {
		 this.deptno = deptno;
	}
	
	

}
