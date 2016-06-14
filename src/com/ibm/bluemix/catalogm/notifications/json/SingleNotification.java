package com.ibm.bluemix.catalogm.notifications.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

//import org.eclipse.jetty.util.Utf8Appendable.NotUtf8Exception;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.bluemix.catalogm.dao.BluemixNotificationDao;

public class SingleNotification {
	
	String __status_url;

	public SingleNotification(String url) {
		validateURL(url);
		__status_url = url;
	}

	private void validateURL(String url) {
		// TODO Auto-generated method stub
		
	}

	public List<OneNotification> processAnnouncements() {
		ObjectMapper objectMapper = new ObjectMapper();
		String response1 ="";
		List<OneNotification> list = null;
		List<OneNotification> listOfAnnouncements = new ArrayList<OneNotification>();
		BluemixNotificationDao bmNotification = new BluemixNotificationDao();
		
		try {
			
			URL url = new URL(__status_url);
			URLConnection conn = url.openConnection();
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder sb = new StringBuilder();
			while ((inputLine = br.readLine()) != null) {
			 sb.append(inputLine);
			}
			response1 = sb.toString();
			br.close();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		try {
			
			list = objectMapper.readValue(response1, new TypeReference<List<OneNotification>>() { });
			for(OneNotification notification : list)
			{
				String id = notification.get_id();
				OneNotification notificationDb = bmNotification.getBluemixNotificationById(id);
				if (notificationDb == null)
				{
					if(notification.getObj().getType().equalsIgnoreCase("ANNOUNCEMENT")){
						listOfAnnouncements.add(notification);
						System.out.println(notification.toString());
					}
					bmNotification.addBluemixNotification(notification);
				}
			}
			System.out.println("$$$$$ Processing of List is done. Total Notifications = " + listOfAnnouncements.size());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listOfAnnouncements;
	}
}
