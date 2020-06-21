package com.delayed.api.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.PostModel;
import com.delayed.model.UserModel;
import com.delayed.service.PostService;
import com.google.gson.Gson;

@WebServlet("/api/post-edit")
public class PostResource extends HttpServlet {

	private static final long serialVersionUID = 3584501270979199767L;

	private Gson gson = new Gson();

	@Inject
	private PostService postService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		PostModel postDetail = postService.findById(Integer.parseInt(id));
		out.print(this.gson.toJson(postDetail));
		out.flush();
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		PostModel post = new Gson().fromJson(requestBody, PostModel.class);
		UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
		try {
			postService.updateById(post, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print(this.gson.toJson(post));
		out.flush();
	}
}
