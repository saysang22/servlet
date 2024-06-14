package org.big.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.big.entity.BoardDto;
import org.big.entity.PageTo;

public class BoardDao {

	DataSource dataFactory; // 네이밍 불러오기

	public BoardDao() {

		// DB 연결
		try {

			Context ctx = new InitialContext(); // Context(부모): server에 있는 context.xml에 있는 태그(클래스)
												// InitialContext(자식)
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11"); // java: comp(비교) env(환경설정) jdbc(이름)
																					// oracle11(값)

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// BoardDto에 있는 멤버 변수 보기 위해
	public ArrayList<BoardDto> list() {
		ArrayList<BoardDto> list = new ArrayList<>();
		Connection conn = null; // 연결
		PreparedStatement pstmt = null; // 쿼리써서 받는것
		ResultSet rs = null; // 쿼리 실행결과가 담기는 클래스 select 일때만

		try {

			conn = dataFactory.getConnection();
			String query = "SELECT num, author, title, content, to_char(writeday, 'YYYY/MM/DD') as writeday, readcnt, reproot, repstep, repindent FROM board ORDER BY reproot desc, repstep asc";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(); // select는 무조건 executeQuery

			while (rs.next()) { // 무한대 데이터 읽어오기
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int reproot = rs.getInt("reproot");
				int repstep = rs.getInt("repstep");
				int repindent = rs.getInt("repindent");

				BoardDto data = new BoardDto();

				data.setNum(num);
				data.setAuthor(author);
				data.setTitle(title);
				data.setContent(content);
				data.setWriteday(writeday);
				data.setReadcnt(readcnt);
				data.setReproot(reproot);
				data.setRepstep(repstep);
				data.setRepindent(repindent);

				list.add(data);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	public void write(String _title, String _author, String _content) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = dataFactory.getConnection(); // DB하고 연결
			String query = "INSERT INTO board(num, title, author, content, reproot, repstep, repindent) VALUES (board_seq.nextVal, ?, ?, ?, board_seq.currval, 0, 0)";
			pstmt = conn.prepareStatement(query); // 쿼리 입력

			// 입력순서
			pstmt.setString(1, _title);
			pstmt.setString(2, _author);
			pstmt.setString(3, _content);

			int n = pstmt.executeUpdate(); // 실행이 정상적으로 되면 1 아니면 0
			System.out.println("저장상태확인(1: true, 0: false): " + n);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void readCount(String _num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = dataFactory.getConnection();
			String query = "UPDATE board SET readcnt = readcnt +1 WHERE num=" + _num;
			pstmt = conn.prepareStatement(query);

			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public BoardDto retrieve(String _num) {
		BoardDto data = new BoardDto();
		readCount(_num);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = dataFactory.getConnection();
			String query = "SELECT * FROM board WHERE num= ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(_num));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");

				data.setNum(num);
				data.setAuthor(author);
				data.setTitle(title);
				data.setContent(content);
				data.setWriteday(writeday);
				data.setReadcnt(readcnt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return data;
	}

	public void update(String _num, String _title, String _author, String _content) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = dataFactory.getConnection();
			String query = "UPDATE board SET title=?, author=?, content= ? WHERE num= ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, _title);
			pstmt.setString(2, _author);
			pstmt.setString(3, _content);
			pstmt.setInt(4, Integer.parseInt(_num));

			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String _num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = dataFactory.getConnection();
			String query = "DELETE FROM board WHERE num=?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(_num));

			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<BoardDto> search(String _searchName, String _searchValue) {
		ArrayList<BoardDto> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = dataFactory.getConnection();
			String query = "SELECT num, author, title, content, TO_CHAR(writeday, 'YYYY/MM/DD') as writeday, readcnt FROM board";
			if (_searchName.equals("title")) {
				query += " WHERE title LIKE ?";
			} else {
				query += " WHERE author LIKE ?";
			}

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + _searchValue + "%");// ?가 받을 값
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");

				BoardDto data = new BoardDto();

				data.setNum(num);
				data.setAuthor(author);
				data.setTitle(title);
				data.setContent(content);
				data.setWriteday(writeday);
				data.setReadcnt(readcnt);

				list.add(data);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}

	public BoardDto replyUi(String _num) {
		BoardDto data = new BoardDto();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = dataFactory.getConnection();
			String query = "SELECT * FROM BOARD WHERE NUM=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_num));

			rs = pstmt.executeQuery();

			if (rs.next()) {

				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWriteday(rs.getString("writeday"));
				data.setReadcnt(rs.getInt("readcnt"));
				data.setReproot(rs.getInt("reproot"));
				data.setRepstep(rs.getInt("repstep"));
				data.setRepindent(rs.getInt("repindent"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return data;
	}

	// step 처리 하는 메소드(증감 알고리즘)
	public void makeReply(String _root, String _step) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = dataFactory.getConnection();
			String query = "UPDATE BOARD SET REPSTEP = REPSTEP +1 WHERE REPROOT = ? AND REPSTEP  >  ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_root));
			pstmt.setInt(2, Integer.parseInt(_step));

			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	// 답변 다는 메소드
	public void reply(String _num, String _title, String _author, String _content, String _reproot, String _repstep,
			String _repindent) {

		makeReply(_reproot, _repstep);

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataFactory.getConnection();

			String query = "INSERT INTO board(NUM, TITLE, AUTHOR, CONTENT, REPROOT, REPSTEP, REPINDENT) VALUES(board_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _title);
			pstmt.setString(2, _author);
			pstmt.setString(3, _content);
			pstmt.setInt(4, Integer.parseInt(_reproot));
			pstmt.setInt(5, Integer.parseInt(_repstep) + 1);
			pstmt.setInt(6, Integer.parseInt(_repindent) + 1);

			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	// 페이지 전체 개수 구하는 메서드
	public int totalCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = dataFactory.getConnection();
			String query = "SELECT count(*) FROM board";
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return count;
	}

public PageTo page(int curPage) {
		
		PageTo to=new PageTo();
		int totalCount=totalCount();
		
		ArrayList<BoardDto> list=new ArrayList<BoardDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			
			conn = dataFactory.getConnection();
			String query = "SELECT num, author, title, content, to_char(writeday, 'YYYY/MM/DD') as writeday, readcnt, reproot, repstep, repindent FROM board ORDER BY reproot desc, repstep asc";
			pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pstmt.executeQuery(); //select는 무조건 executeQuery
			
			int perPage=to.getPerPage();
			int skip=(curPage-1) * perPage;
			
			if(skip > 0) {
				rs.absolute(skip);
			}
			
			for(int i=0; i<perPage && rs.next(); i++) { //무한대 데이터 읽어오기
				int num = rs.getInt("num"); 
				String author = rs.getString("author"); 
				String title = rs.getString("title"); 
				String content = rs.getString("content"); 
				String writeday = rs.getString("writeday"); 
				int readcnt = rs.getInt("readcnt"); 
				int reproot = rs.getInt("reproot"); 
				int repstep = rs.getInt("repstep"); 
				int repindent = rs.getInt("repindent"); 
				
				BoardDto data = new BoardDto();
				
				data.setNum(num);
				data.setAuthor(author);
				data.setTitle(title);
				data.setContent(content);
				data.setWriteday(writeday);
				data.setReadcnt(readcnt);
				data.setReproot(reproot);
				data.setRepstep(repstep);
				data.setRepindent(repindent);
				
				list.add(data);
				
			}
			
			to.setList(list);
			to.setTotalCount(totalCount);
			to.setCurPage(curPage);
			
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
		
		
		return to;
	}
}
