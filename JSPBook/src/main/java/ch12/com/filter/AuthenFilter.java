package ch12.com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class AuthenFilter extends HttpFilter implements Filter {
       
    public AuthenFilter() {
        super();
      
    }

    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter01 초기화...");
	}
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		chain.doFilter(request, response);
		
		System.out.println("Filter01.jsp 수행...");
		String name = request.getParameter("name");
		
		if(name == null || name.equals("")) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			String message = "입력된 name 값은 null입니다.";
			writer.print(message);
			return;
		}
		
		chain.doFilter(request, response);
	}
    @Override
	public void destroy() {
		System.out.println("Filter01 해제...");
	}

}
