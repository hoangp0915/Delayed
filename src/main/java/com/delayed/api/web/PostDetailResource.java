package com.delayed.api.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.model.CommentModel;
import com.delayed.model.CommentRequestBody;
import com.delayed.model.PostData;
import com.delayed.model.PostModel;
import com.delayed.model.UserModel;
import com.delayed.service.CommentService;
import com.google.gson.Gson;

@WebServlet("/api/comment")
public class PostDetailResource extends HttpServlet {

	private static final long serialVersionUID = 749848518786342726L;
	
	private Gson gson = new Gson();
	
	@Inject
	private CommentService commentService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String postId = request.getParameter("postId");
		List<CommentModel> comments = commentService.listCommentByPost(Integer.parseInt(postId));
		out.print(this.gson.toJson(comments));
		out.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel user = (UserModel) request.getSession().getAttribute("USERMODEL");
		String postId = request.getParameter("postId");
		CommentRequestBody crb = this.gson.fromJson(_readJsonFromRequest(request), CommentRequestBody.class);
		if(user != null) {
			commentService.insertComment(user.getId(), Integer.parseInt(postId), crb.getComment());
		}
	}
	
	private String _readJsonFromRequest(HttpServletRequest request) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    try (BufferedReader br = request.getReader()) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line);
	        }
	    }
	    return sb.toString();
	}
}
