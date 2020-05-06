package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null;
		int age=0;
		String gender=null;
		
		//Get PrintWriter object
		pw=resp.getWriter();
		//Set contentType
		resp.setContentType("text/html");
		//Read form data
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		gender=req.getParameter("gender");
		//Write b logic
		if (gender.equalsIgnoreCase("m")) {
			if (age<18) {
				pw.println("<h1 style='color: gray;text-align: right;'>Mr."+name+" Your Not eligible for marriage</h1>");
			}else {
				pw.println("<h1 style='color: gray;text-align: right;'>Mr."+name+" Your eligible for marriage</h1>");
			}
		} else {
			if (age<18) {
				pw.println("<h1 style='color: gray;text-align: right;'>Mr."+name+" Your Not eligible for marriage</h1>");
			}else {
				pw.println("<h1 style='color: gray;text-align: right;'>Mr."+name+" Your eligible for marriage</h1>");
			}
		}
		//Add Hyperlink
		pw.println("<br><a href='form.html'>Home</a>");
		//Close writer
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
