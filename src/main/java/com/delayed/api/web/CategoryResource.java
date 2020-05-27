/**
 * 
 */
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

import com.delayed.model.PostModel;
import com.delayed.service.PostService;
import com.google.gson.Gson;

/**
 * @author hoang
 *
 */
@WebServlet("/api/category")
public class CategoryResource extends HttpServlet {

	private static final long serialVersionUID = 2926458480279691589L;

	private Gson gson = new Gson();

	@Inject
	private PostService postService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cat = request.getParameter("cat");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		List<PostModel> posts = postService.listRecordByCategory(Integer.parseInt(cat), Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		out.print(this.gson.toJson(posts));
		out.flush();
	}
}
