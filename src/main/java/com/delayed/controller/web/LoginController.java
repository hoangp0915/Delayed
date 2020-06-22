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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(action != null && action.equals("register")) {
			String email = request.getParameter("email");
			System.out.println("username: " + username + " password: " + password + "email: " + email);
			UserModel userRegis = userService.registration(username, password, email);
			RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			if(userRegis != null) {
				request.setAttribute("alert", "success");
				request.setAttribute("message", "Đăng ký tài khoản thành công!");
			}else {
				request.setAttribute("alert", "fail");
				request.setAttribute("classActive", "right-panel-active");
				request.setAttribute("message", "Username tồn tại!");
			}
			
			rd.forward(request, response);
		}else {
			UserModel userModel = userService.login(username, password);
			if(userModel != null) {
				System.out.println("Role: " + userModel.getRole().getCode());
				request.getSession().setAttribute("USERMODEL", userModel);
				response.sendRedirect(request.getContextPath() + "/home");
			}else {
				request.setAttribute("alert", "invalid");
				RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
				rd.forward(request, response);
			}
		}
		
	}
}
