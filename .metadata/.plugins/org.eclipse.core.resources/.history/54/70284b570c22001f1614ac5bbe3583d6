package org.big;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userid = "scott";
	String passwd = "tiger";
	
	public EmpDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName(driver);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<EmpDto> select() {
		ArrayList<EmpDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			String query = "SELECT * FROM emp";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				EmpDto dto = new EmpDto();
				
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setJob(job);
				dto.setMgr(mgr);
				dto.setHiredate(hiredate);
				dto.setSal(sal);
				dto.setComm(comm);
				dto.setDeptno(deptno);
				
				list.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
