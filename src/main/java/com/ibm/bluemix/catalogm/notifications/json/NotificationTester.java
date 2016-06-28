package com.ibm.bluemix.catalogm.notifications.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.nosql.json.util.JSON;

public class NotificationTester {

	public static String response = "[{\"_id\":\"0022a1d67d2f1063693584da36603424\",\"obj\":{\"_id\":\"0022a1d67d2f1063693584da36603424\",\"_rev\":\"2-b31b4e766f9960935fcacb8e372cd0b3\",\"title\":\"Analytics for Hadoop maintenance at Nov 8 6:00 AM US Eastern time\",\"type\":\"MAINTENANCE\",\"text\":\"There will be a brief outage of provisioning new instances of Analytics for Hadoop at Nov 8 6AM Eastern time. Direct access to existing provisioned clusters should not be affected. The outage should be under 30 minutes and all changes should be complete by 8am Eastern time.\",\"category\":\"SERVICES\",\"subCategory\":\"cloudoe.sop.enum.paratureCategory.literal.l110\",\"regionsAffected\":[{\"id\":\"US-SOUTH\"}],\"archived\":true,\"eventTime\":{\"start\":\"2014-11-08T11:00:00.000Z\",\"end\":\"2014-11-08T13:00:00.000Z\"},\"creation\":{\"time\":\"2014-11-07T23:05:05.178Z\",\"email\":{\"_id\":\"dpj@us.ibm.com\",\"userId\":\"dpj@us.ibm.com\",\"role\":\"admin\",\"provider\":\"bluemix\"}},\"lastUpdate\":{\"time\":\"2015-04-09T14:54:57.016Z\",\"email\":\"jmorriss2@us.ibm.com\"}}},{\"_id\":\"0027d3f2ba4625fb9faedc151c3af32a\",\"obj\":{\"_id\":\"0027d3f2ba4625fb9faedc151c3af32a\",\"_rev\":\"2-5a1b1771b2e4b18c5e9d08b93ba8030e\",\"title\":\"IBM Bluemix Platform maintenance US-SOUTH region June 2 10:00 PM EDT\",\"type\":\"MAINTENANCE\",\"text\":\"Starting at 10pm US EST Tuesday June 2, and lasting approximately 24 hours, there will be a maintenance update rolling out across the Bluemix platform US-South region.<br>During this time, you may experience temporary errors logging in to Bluemix, or managing applications (starting, staging, etc.). If this happens, please retry the operation later. Latest status will be available at https://developer.ibm.com/bluemix/support/#status throughout the upgrade.<br>\n\nExisting applications will see a brief restart of instances, with near continuous availability expected.<br/>\n<br/>\n<b>Update:</b> This maintenance is complete.\",\"category\":\"PLATFORM\",\"subCategory\":\"cloudoe.sop.enum.paratureCategory.literal.l133\",\"regionsAffected\":[{\"id\":\"US-SOUTH\"}],\"archived\":false,\"eventTime\":{\"start\":\"2015-06-03T02:00:00.000Z\",\"end\":\"2015-06-03T14:00:00.000Z\"},\"creation\":{\"time\":\"2015-06-01T11:46:18.671Z\",\"email\":\"jmorriss2@us.ibm.com\"},\"lastUpdate\":{\"time\":\"2015-06-03T14:27:25.916Z\",\"email\":\"dpj_local@us.ibm.com\"}}}]";

	// {
	// "_id": "0022a1d67d2f1063693584da36603424",
	// "obj": {
	// "_id": "0022a1d67d2f1063693584da36603424",
	// "_rev": "2-b31b4e766f9960935fcacb8e372cd0b3",
	// "title":
	// "Analytics for Hadoop maintenance at Nov 8 6:00 AM US Eastern time",
	// "type": "MAINTENANCE",
	// "text":
	// "There will be a brief outage of provisioning new instances of Analytics for Hadoop at Nov 8 6AM Eastern time. Direct access to existing provisioned clusters should not be affected. The outage should be under 30 minutes and all changes should be complete by 8am Eastern time.",
	// "category": "SERVICES",
	// "subCategory": "cloudoe.sop.enum.paratureCategory.literal.l110",
	// "regionsAffected": [{
	// "id": "US-SOUTH"
	// }],
	// "archived": true,
	// "eventTime": {
	// "start": "2014-11-08T11:00:00.000Z",
	// "end": "2014-11-08T13:00:00.000Z"
	// },
	// "creation": {
	// "time": "2014-11-07T23:05:05.178Z",
	// "email": {
	// "_id": "dpj@us.ibm.com",
	// "userId": "dpj@us.ibm.com",
	// "role": "admin",
	// "provider": "bluemix"
	// }
	// },
	// "lastUpdate": {
	// "time": "2015-04-09T14:54:57.016Z",
	// "email": "jmorriss2@us.ibm.com"
	// }
	// }
	// }"

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		OneNotification[] arr;
		String response1 = "";

		try {

			URL url = new URL("https://status.ng.bluemix.net/api/notifications");
			URLConnection conn = url.openConnection();
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String inputLine;
			StringBuilder sb = new StringBuilder();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
				// System.out.println(inputLine);
			}
			response1 = sb.toString();
			br.close();
			System.out.println("Done");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			List<OneNotification> list = objectMapper.readValue(response1,
					new TypeReference<List<OneNotification>>() {
					});
			arr = objectMapper.readValue(response1, OneNotification[].class);
			for (int i = 0; i < arr.length; i++) {
				OneNotification oneNotification = arr[i];
				if (oneNotification.getObj().getType()
						.equalsIgnoreCase("ANNOUNCEMENT")) {
					processAnnouncement(oneNotification);
				}
			}

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

	}

	private static void processAnnouncement(OneNotification oneNotification) {
		System.out.println("Found Announcement : " + oneNotification.get_id()
				+ "   :     Text : " + oneNotification.getObj().getText());
	}

}
