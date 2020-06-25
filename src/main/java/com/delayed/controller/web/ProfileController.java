package com.delayed.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.UserModel;

@WebServlet(urlPatterns = { "/profile"})
public class ProfileController extends HttpServlet {

	private static final long serialVersionUID = -437612352793130093L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
		if(user != null) {
			RequestDispatcher rd = request.getRequestDispatcher("views/web/profile.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}
	
}
