package ch12.com.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class LogFileFilter extends HttpFilter implements Filter {

	PrintWriter writer;
	
    public LogFileFilter() {
        super();
        
    }

	public void init(FilterConfig fConfig) throws ServletException {
		String filename = fConfig.getInitParameter("filename");
		
		if(filename == null) throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		writer.printf("현재일시 : %s \n", getCurrentTime());
		String clientAddr = request.getRemoteAddr();
		writer.printf("클라이언트 주소 : %s \n", clientAddr);
		
		chain.doFilter(request, response);
		
		String contentType = response.getContentType();
		writer.printf("문서의 콘텐츠 유형 : %s \n", contentType);
		writer.println("-------------------------------------");
	}

	public void destroy() {
		writer.close();
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		return formatter.format(calendar.getTime());
	}

}
