package Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

@WebFilter("/Dashboard/*")
public class AuthFilter implements Filter {
	private String contextPath;

	  @Override
	  public void init(FilterConfig fc) throws ServletException {
	    contextPath = fc.getServletContext().getContextPath();
	  }

	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;  

	    if (req.getSession().getAttribute("user") == null) { //checks if there's a LOGIN_USER set in session...
	        res.sendRedirect(contextPath + "/pages/login.jsp"); //or page where you want to redirect
	    } else {
	      User user = (User) req.getSession().getAttribute("user");
	      System.out.println("username: "+user.getUsername() );
	      }
	      fc.doFilter(request, response);
	    
	  }

	  @Override
	  public void destroy() {
	  }
}
