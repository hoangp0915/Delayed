package com.delayed.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.UserModel;
import com.delayed.service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7675601573452387320L;

	@Inject
	private UserService userService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		UserModel userModel = userService.login(request.getParameter("username"), request.getParameter("password"));
		if(userModel != null) {
			request.getSession().setAttribute("USERMODEL", userModel);
			response.sendRedirect(request.getContextPath() + "/home");
		}else {
			response.sendRedirect(request.getContextPath()+"/login?message=username_password_invalid&alert=danger");
		}
		
	}
}
