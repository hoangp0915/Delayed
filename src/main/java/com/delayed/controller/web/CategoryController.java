package com.delayed.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.CategoryModel;
import com.delayed.service.CategoryService;

@WebServlet(urlPatterns = { "/category" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = -9073530184347982538L;

	@Inject
	private CategoryService categoryService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		if (request.getParameter("cat") != null && !request.getParameter("cat").isEmpty()) {
			CategoryModel cate = categoryService.findOneById(Integer.parseInt(request.getParameter("cat")));
			request.setAttribute("category", cate);
			rd = request.getRequestDispatcher("views/web/category.jsp");
		} else {
			rd = request.getRequestDispatcher("views/web/404notfound.jsp");
		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

	}
}
