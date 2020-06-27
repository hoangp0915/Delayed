package com.delayed.common;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class Constant {
	
	public static final Integer ROLE_ADMIN = 5;
	public static final Integer ROLE_MEMBER = 6;
	
	public static final String USER_CURRENT = "USER_CURRENT";
	public static final String NOT_PERMISSION = "NOT_PERMISSION";
	public static final String DELETE_SUCCESS = "DELETE_SUCCESS";
	
	public static final String ADMIN = "ADMIN";
	public static final String MEMBER = "MEMBER";
	
	public static String _readJsonFromRequest(HttpServletRequest request) throws IOException {
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
