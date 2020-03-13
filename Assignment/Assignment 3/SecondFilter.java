

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondFilter
 */
@WebFilter("/RequestHandlerservlet")
public class SecondFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	        		if(request.getParameter("pass").equals("123")) {
	        			chain.doFilter(request, response);
	        		}
	        		else
	        		{
	        			response.getWriter().write("<h1>Invalid User</h1>");
	        		}
	        	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("from init of SecondFilter");
		
	}
	

}
