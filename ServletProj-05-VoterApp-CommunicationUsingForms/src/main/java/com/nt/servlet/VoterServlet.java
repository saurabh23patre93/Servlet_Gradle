package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=null;
		int age=0;
		PrintWriter pw=null;
		
		//Get PrintWriter object
		pw=resp.getWriter();
		//Set contentType
		resp.setContentType("text/html");
		//Read Form data
		name=req.getParameter("pName");
		age=Integer.parseInt(req.getParameter("age"));
		//Write B logic
		if (age<18) {
			pw.println("<h1 style='color: red;text-align: center;'>Mr./Miss"+name+"Your Not eligible to voting</h1>");
		} else {
			pw.println("<h1 style='color: red;text-align: center;'>Mr./Miss"+name+"Your are eligible to voting</h1>");
		}
		//Add hyper home link
		pw.println("<a href='page.html'>Home</a>");
		//Close pw
		pw.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
