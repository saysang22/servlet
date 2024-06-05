package org.big;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empSelect")
public class empSelectServlet extends HttpServlet {

	public empSelectServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=resp.getWriter();
		out.print("<html><body>");
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String userid="scott";
		String passwd="tiger";
		
		Connection conn=null; //sql 환경의 클래스
		Statement stmt=null;  //sql 환경의 클래스
		ResultSet rs=null;    //sql 환경의 클래스
		
		try {  // 다이나믹 프로세스
			Class.forName(driver);  //클래스의 이름을 찾아준다.
			conn=DriverManager.getConnection(url, userid, passwd);  //실제 DB랑 연결
			stmt=conn.createStatement();//쿼리 문장, 사용할때마다 메모리 소모, 제대로 실행되면1, 아니면 0
			
			String query="SELECT * FROM emp";
			rs=stmt.executeQuery(query); //쿼리 실행
			
			while(rs.next()) { //next() -> 크기, size, 읽을 데이터가 있으면 1, true
				int empno=rs.getInt("empno");//데이터베이스에 있는 값 출력                                     
				String ename=rs.getString("ename");                                             
				String job=rs.getString("job");                                                
				int mgr=rs.getInt("mgr");                                               
				String hiredate=rs.getString("hiredate");                                          
				int sal=rs.getInt("sal");                                                
				int comm=rs.getInt("comm");                                               
				int deptno=rs.getInt("deptno");
				out.print(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno+"<br>");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		out.print("</body></html>");
	}
}


