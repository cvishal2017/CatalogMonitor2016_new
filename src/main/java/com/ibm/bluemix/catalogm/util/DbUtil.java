package com.ibm.bluemix.catalogm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
    	try {
    		if (connection != null && !connection.isClosed())
            	return connection;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
//        else {
            try {
//				Properties prop = new Properties();
//				InputStream inputStream = DbUtil.class.getClassLoader()
//						.getResourceAsStream("db.properties");
//				prop.load(inputStream);
//				String DB_DRIVER = prop.getProperty("DB_DRIVER");
//				String DB_CONNECTION = prop.getProperty("DB_CONNECTION");
//				String DB_USER = prop.getProperty("DB_USER");
//				String DB_PASSWORD = prop.getProperty("DB_PASSWORD");
//            	String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
//            	String DB_CONNECTION = "jdbc:db2://23.246.235.83:50000/I9626565";
//        		String DB_USER ="wnxnrdfd";
//     			String DB_PASSWORD =  "45zfgd3gcgmn";
//            	Class.forName(DB_DRIVER);
//                connection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            	
            	try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 
                System.out.println("Connecting....");

                VCAPUtils mydb = new VCAPUtils();
                connection = DriverManager.getConnection(mydb.getDBUrl(),mydb.getDBUser(),mydb.getDBPassword());
                //connection.setSchema("ZGOSWDMD");
     
                System.out.println("Create statement.");
            	
                System.out.println("--- DB Connection is successfule............");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
//        }

    }
    
    public static void closeConnection(){
    	try {
    		if (connection != null) {
    			System.out.println("Closing db connection...");
    			connection.close();
    		}
    	} catch(SQLException e) {
          	e.printStackTrace();
        }
    	
    }


}
