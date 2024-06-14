package ch12.com.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class LoginCheckFilter extends HttpFilter implements Filter {
	
	private FilterConfig filterConfig = null;
       
    public LoginCheckFilter() {
        super();
   
    }
    
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
    	
    	this.filterConfig = fConfig;
    	System.out.println("초기화....");

	}
    
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	String id = request.getParameter("id");
    	String passwd = request.getParameter("passwd");
    	
    	String paId = filterConfig.getInitParameter("id");
    	String paWd = filterConfig.getInitParameter("pw");
    	
    	String message;
    	
    	if(id.equals(paId) && passwd.equals(paWd)) {
    		message = "로그인이 되었습니다.";
    	} else {
    		message = "로그인 실패했습니다.";
    	}
    	
		chain.doFilter(request, response);
	}

    @Override
	public void destroy() {
		
	}
}
