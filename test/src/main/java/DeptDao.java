package org.big;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DeptDao {

//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	String userid = "scott";
//	String passwd = "tiger";
	
	DataSource dataFactory;
	
	public DeptDao() {
		// TODO Auto-generated constructor stub
		
		try {
			
			Context ctx = new InitialContext();
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DeptDto> select() {
		ArrayList<DeptDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
//			conn = DriverManager.getConnection(url, userid, passwd);
			
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM dept";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				DeptDto dto = new DeptDto();
				
				dto.setDeptno(deptno);
				dto.setDname(dname);
				dto.setLoc(loc);
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
