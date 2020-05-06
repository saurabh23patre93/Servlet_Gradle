package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		String gender=null,tage=null;
		List<String> errorlist=null;
		
		//Get PrintWriter object
		pw=resp.getWriter();
		//Set contentType
		resp.setContentType("text/html");
		//Read form data
		name=req.getParameter("name");
		tage=req.getParameter("age");
		gender=req.getParameter("gender");
		errorlist=new ArrayList<String>();
		
		//write all error messages
		if (name.equals("")||name.length()==0||name==null) {
			errorlist.add("Person Name is required...");
			}
		if (tage==null || tage.equals("") || tage.length()==0) {
			errorlist.add("Person Age is required...");
		}else {
			try {
				age=Integer.parseInt(req.getParameter("page"));
				if (age<1 ||age>110) {
					errorlist.add("Person Age is required in between 1 to 110...");
				}
			} catch(NumberFormatException enf) {
				errorlist.add("Person Age should be a numeric value...");
			}
		}//end if		
		//Display all form validation error together
				if (errorlist.size()!=0) {
					//this for loop in java 5 version it is advanced loop 
					for (String msg : errorlist) {
						pw.println("<h1 style='color:red;text-align:center'>"+msg);
					}
					pw.println("<br><br><a href='form.html'>home</a>");
					return;
				}
		//Form Validation in Server side
		/*if(name.equals("")||name.length()==0||name==null) {
			pw.println("<h4 style='color:red;text-align:center'>Person Name is required...</h4>");
			pw.println("<br><br><a href='form.html'>home</a>");
			return;
		}//
		if(tage==null || tage.equals("") || tage.length()==0) {
			pw.println("<h4 style='color:red;text-align:center'>Person Age is required...</h4>");
			pw.println("<br><br><a href='form.html'>home</a>");
			return;
		}else {
			try {
				age=Integer.parseInt(req.getParameter("page"));
				if (age<1 ||age>110) {
					pw.println("<h2 style='color:red;text-align:center'>Person Age is required in between 1 to 110...</h2>");
					pw.println("<br><br><a href='form.html'>home</a>");
					return;
				}
			} catch (NumberFormatException nfe) {
				pw.println("<h4 style='color:red;text-align:center'>Person Age should be a numeric value...</h4>");
				pw.println("<br><br><a href='form.html'>home</a>");
				return;
			}
		}*/
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
