package com.ibm.bluemix.catalogm.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MonitorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SP: Inside MonitorServlet.doGet");
		String user = req.getUserPrincipal().getName();
		System.out.println("Authenticated User : " + user);
		String remuser = req.getRemoteUser();
		System.out.println("Authenticated User : " + remuser);
		
		Enumeration params = req.getParameterNames();
		while(params.hasMoreElements()){
			 String paramName = (String)params.nextElement();
			 System.out.println("Parameter Name - "+paramName+", Value - "+req.getParameter(paramName));
		}
		
		Enumeration attrs = req.getAttributeNames();
		while(attrs.hasMoreElements()){
			 String paramName = (String)attrs.nextElement();
			 System.out.println("Attribute Name - "+paramName+", Value - "+req.getAttribute(paramName));
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("SP: Inside MonitorServlet.doPost");
		String user = req.getUserPrincipal().getName();
		System.out.println("Authenticated User : " + user);
		String remuser = req.getRemoteUser();
		System.out.println("Authenticated User : " + remuser);
		super.doPost(req, resp);
	}

}
