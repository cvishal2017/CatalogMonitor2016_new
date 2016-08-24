package com.ibm.bluemix.catalogm.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/monitorservlet")
public class MonitorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SP: Inside MonitorServlet.doGet");
		String user = req.getUserPrincipal().getName();
		System.out.println("Authenticated User : " + user);
		String remuser = req.getRemoteUser();
		System.out.println("Authenticated User : " + remuser);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("SP: Inside MonitorServlet.doPost");
		String user = req.getUserPrincipal().getName();
		System.out.println("Authenticated User : " + user);
		String remuser = req.getRemoteUser();
		System.out.println("Authenticated User : " + remuser);
		
		String button = req.getParameter("button");
		System.out.println("Button : " + button);
		super.doPost(req, resp);
	}

}
