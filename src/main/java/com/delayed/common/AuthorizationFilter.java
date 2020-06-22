package com.delayed.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.UserModel;

public class AuthorizationFilter implements Filter {

	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.contains("/admin")) {
        	UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
            if (user != null) {
                if (user.getRole().getCode().equals(Constant.ADMIN)) {
                	chain.doFilter(servletRequest, servletResponse);
                } else if (user.getRole().getCode().equals(Constant.MEMBER)) {
                    response.sendRedirect(request.getContextPath()+"/home");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/login");
            }
        } else {
        	chain.doFilter(servletRequest, servletResponse);
        }
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
