package com.delayed.api.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.PostData;
import com.delayed.model.PostModel;
import com.delayed.model.UserModel;
import com.delayed.service.PostService;
import com.google.gson.Gson;

@WebServlet("/api/home")
public class HomeResource extends HttpServlet {

	private static final long serialVersionUID = 1883632707291670316L;

	private Gson gson = new Gson();

	@Inject
	private PostService postService;

	/**
	 * Do get API {@inheritDoc}
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action != null && action.equals("sidebar")) {
			List<PostModel> sidebar = postService.listRecordMostViewed();
			out.print(this.gson.toJson(sidebar));
			out.flush();
		} else if (action != null && action.equals("favorite")) {
			UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
			if (request.getSession().getAttribute("USERMODEL") != null) {
				List<PostModel> favorite = postService.listFavorite(user.getId());
				out.print(this.gson.toJson(favorite));
				out.flush();
			} else {
				out.print(this.gson.toJson(null));
				out.flush();
			}

		} else {
			String page = request.getParameter("page");
			String size = request.getParameter("size");
			List<PostModel> posts = postService.listRecord(Integer.parseInt(page) - 1, Integer.parseInt(size));
			List<PostData> postDataList = postService.listPostData(posts);
			out.print(this.gson.toJson(postDataList));
			out.flush();
		}
	}

	/**
	 * Do Post API {@inheritDoc}
	 * RequestBody
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//Lấy data từ requestBody
		String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		System.out.println("requestBody" + requestBody);
		//Convert to PostModel
		PostModel post = new Gson().fromJson(requestBody, PostModel.class);
		//Update data
		System.out.println("getTitle" + post.getTitle());
		System.out.println("getContent" + post.getContent());
		System.out.println("getDescription" + post.getDescription());
		System.out.println("getCategoryId" + post.getCategoryId());
		UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
		PostModel postModel = postService.save(post, user);
		//Print data đã update || null
		out.print(this.gson.toJson(postModel));
		out.flush();
	}

	/**
	 * Do Put API {@inheritDoc}
	 * 
	 * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		PostModel post = new Gson().fromJson(requestBody, PostModel.class);
		try {
			postService.updateById(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print(this.gson.toJson(post));
		out.flush();
	}

	/**
	 * Do Delete Example {@inheritDoc}
	 * 
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		postService.deleteById(Integer.parseInt(id));
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(this.gson.toJson(id));
		out.flush();
	}
}
