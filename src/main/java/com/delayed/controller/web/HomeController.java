package com.delayed.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.PostModel;
import com.delayed.service.PostService;

@WebServlet(urlPatterns = { "/home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 8685190857914407353L;

	@Inject
	private PostService postService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("logout")) {
			request.getSession().removeAttribute("USERMODEL");
			response.sendRedirect(request.getContextPath()+"/home");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
			List<PostModel> views = postService.findRecordLimit(5);
			request.setAttribute("views", views);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

	}
}
