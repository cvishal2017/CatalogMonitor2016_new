package com.ibm.bluemix.catalogm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.bluemix.catalogm.util.DbUtil;

public class EmailSubscriptionsDao {

	private Connection connection;
	PreparedStatement preparedStatement;
	String tableName = "email_subscriptions";
	
	public EmailSubscriptionsDao() {
		connection = DbUtil.getConnection();
	}
	
	public List<String> getSubscribedEmails() {
		List<String> emailIds = new ArrayList<String>();
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT email_id from " + tableName);
			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			while (rs.next()) {
				String email_id = rs.getString("email_id");
				emailIds.add(email_id);
				
				System.out.println("getSubscribedEmails : Foudn Email ID : " + email_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emailIds;
	}
	
	public String addSubscription(String emailId) {
		String result = "";
		
		boolean ifSubscribed = checkIfSubscribed(emailId);
		if(ifSubscribed)
			result = "You have already subscribed to Bluemix Monitor Service.";
		else {
			try {
				preparedStatement = (PreparedStatement) connection.prepareStatement("insert into " + tableName + " (`name`, `email_id`) VALUES ('" + emailId + "','" + emailId + "'");
				preparedStatement.executeUpdate();
				result = "You have been subscribed to Bluemix Monitor service.";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean checkIfSubscribed(String emailId) {
		boolean result = false;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT email_id from " + tableName + "where email_id='" + emailId + "'");
			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			while (rs.next()) {
				result = true;
				System.out.println("getSubscribedEmails : Found Email ID : " + emailId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
