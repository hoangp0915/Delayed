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

import com.delayed.model.CategoryModel;
import com.delayed.model.PostData;
import com.delayed.model.PostModel;
import com.delayed.service.CategoryService;
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
	
	@Inject
	private CategoryService categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action != null && action.equals("all")) {
			List<CategoryModel> categories = categoryService.findAll();
			out.print(this.gson.toJson(categories));
			out.flush();
		}else {
			String cat = request.getParameter("cat");
			String page = request.getParameter("page");
			String size = request.getParameter("size");
			List<PostModel> posts = postService.listRecordByCategory(Integer.parseInt(cat), Integer.parseInt(page) - 1,
					Integer.parseInt(size));
			List<PostData> postDataList = postService.listPostData(posts);
			out.print(this.gson.toJson(postDataList));
			out.flush();
		}
	}
}
