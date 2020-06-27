package com.delayed.api.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.common.Constant;
import com.delayed.model.UserModel;
import com.delayed.service.UserService;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/api/change-profile"})
public class ChangeProfileResource extends HttpServlet{

	private static final long serialVersionUID = 2132457301732160664L;
	
	private Gson gson = new Gson();
	
	@Inject
	private UserService userService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String requestBody = Constant._readJsonFromRequest(request);
		UserModel change = this.gson.fromJson(requestBody, UserModel.class);
		UserModel current = (UserModel) request.getSession().getAttribute("USERMODEL");
		if(change.getUsername().equals(current.getUsername())) {
			if(!change.getPassword().equals(current.getPassword())) {
				out.print(this.gson.toJson("INVALID"));
				out.flush();
			}
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String requestBody = Constant._readJsonFromRequest(request);
		UserModel change = this.gson.fromJson(requestBody, UserModel.class);
		UserModel current = (UserModel) request.getSession().getAttribute("USERMODEL");
		if(change.getUsername().equals(current.getUsername())) {
			userService.changeProfile(change);
			out.print(this.gson.toJson("SUCCESS"));
			out.flush();
		}
	}
}
