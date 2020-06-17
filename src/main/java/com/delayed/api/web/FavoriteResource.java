package com.delayed.api.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.UserModel;
import com.delayed.service.PostService;
import com.google.gson.Gson;

@WebServlet("/api/favorite")
public class FavoriteResource extends HttpServlet {

	private static final long serialVersionUID = -3465008861633972966L;

	private Gson gson = new Gson();

	@Inject
	private PostService postService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String postId = request.getParameter("postId");
		UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
		Integer favorite = 0;
		if (user != null) {
			favorite = this.postService.getFavoriteArticles(user.getId(), Integer.parseInt(postId));
		}
		out.print(this.gson.toJson(favorite));
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String postId = request.getParameter("postId");
		UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			Integer favorite = this.postService.insertFavoriteArticles(user.getId(), Integer.parseInt(postId));
			out.print(this.gson.toJson(favorite));
			out.flush();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String postId = request.getParameter("postId");
		UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
		postService.deleteFavoriteArticle(user.getId(), Integer.parseInt(postId));
	}
}
