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

import com.delayed.model.CategoryModel;
import com.delayed.model.PostData;
import com.delayed.model.PostModel;
import com.delayed.service.PostService;
import com.google.gson.Gson;

@WebServlet("/api/search")
public class SearchResource extends HttpServlet {
	private Gson gson = new Gson();

	@Inject
	private PostService postService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String searchKey = request.getParameter("searchKey");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		List<PostModel> posts = postService.searchByKey(searchKey, Integer.parseInt(page) - 1, Integer.parseInt(size));
		List<PostData> postDataList = postService.listPostData(posts);
		out.print(this.gson.toJson(postDataList));
		out.flush();
	}
}
