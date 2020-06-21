/**
 * 
 */
package com.delayed.api.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delayed.service.UserService;
import com.google.gson.Gson;

/**
 * @author hoang
 *
 */
@WebServlet("/api/listUser")
public class UserResource extends HttpServlet {

	private static final long serialVersionUID = -2596347375610753961L;
	
	private Gson gson = new Gson();
	
	@Inject
	private UserService userService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.print(this.gson.toJson(userService.getAllUser()));
		out.flush();
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

	}
}
