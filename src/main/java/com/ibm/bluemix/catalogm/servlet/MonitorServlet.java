package com.ibm.bluemix.catalogm.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bluemix.catalogm.dao.EmailSubscriptionsDao;

@WebServlet("/monitorservlet")
public class MonitorServlet extends HttpServlet {
	
	final String subButton = "Sunscribe";
	final String unsubButton = "Unsubscribe";
	
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
		String msg = "";
		
		EmailSubscriptionsDao emailsub = new EmailSubscriptionsDao();
		
		if(button.equalsIgnoreCase(subButton))
			msg = emailsub.addSubscription(remuser);
		else if(button.equalsIgnoreCase(unsubButton))
			msg = emailsub.removeSubscription(user);
		
		req.setAttribute("message", msg);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
