/**
 * 
 */
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

/**
 * @author hoang
 *
 */
@WebServlet(urlPatterns = { "/post"})
public class PostDetailController extends HttpServlet {
	
	private static final long serialVersionUID = -3533249402463730091L;
	
	@Inject
	private PostService postService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/web/post-detail.jsp");
		String id = request.getParameter("id");
		PostModel postDetail = postService.findById(Integer.parseInt(id));
		List<PostModel> views = postService.findRecordLimit(3);
		request.setAttribute("views", views);
		request.setAttribute("postDetail", postDetail);
		rd.forward(request, response);
	}
}
