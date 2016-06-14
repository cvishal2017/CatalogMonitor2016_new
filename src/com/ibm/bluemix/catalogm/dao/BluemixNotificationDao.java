package com.ibm.bluemix.catalogm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.bluemix.catalogm.notifications.json.EventTime;
import com.ibm.bluemix.catalogm.notifications.json.LastUpdate;
import com.ibm.bluemix.catalogm.notifications.json.Obj;
import com.ibm.bluemix.catalogm.notifications.json.OneNotification;
import com.ibm.bluemix.catalogm.notifications.json.RegionsAffected;


public class BluemixNotificationDao {
	private Connection connection;
	PreparedStatement preparedStatement;
	String tableName = "blumix_notifications";
	
	public BluemixNotificationDao(){
		connection = com.ibm.bluemix.catalogm.util.DbUtil.getConnection();
	}

	
	public void addBluemixNotification(OneNotification notification) {
        try {
        	preparedStatement = (PreparedStatement) connection
                    .prepareStatement("insert into "+tableName+"(id, category, subcategory, type, text, title, regionsAffected, lastUpdateTime, lastUpdateEmail, eventTimeStart, eventTimeEnd) values (?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, notification.get_id());
            preparedStatement.setString(2, notification.getObj().getCategory());
            preparedStatement.setString(3, notification.getObj().getSubCategory());
            preparedStatement.setString(4, notification.getObj().getType());
            preparedStatement.setString(5, notification.getObj().getText());
            preparedStatement.setString(6, notification.getObj().getTitle());
            preparedStatement.setString(7, notification.getObj().getRegionsAffected()[0].getId());
            preparedStatement.setString(8, notification.getObj().getLastUpdate().getTime());
            preparedStatement.setString(9, notification.getObj().getLastUpdate().getEmail());
            preparedStatement.setString(10, notification.getObj().getEventTime().getStart());
            preparedStatement.setString(11, notification.getObj().getEventTime().getEnd());
            preparedStatement.executeUpdate();
            //System.out.println("&&&&&&&&&&&&&&& DB New Record Inserted..... for "+ notification.get_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        finally {
	        if (preparedStatement != null) {
	        	try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
    }

    public void __deleteBluemixNotification(String id) {
        try {
            preparedStatement = (PreparedStatement) connection
                    .prepareStatement("delete from "+tableName+" where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBluemixNotification(OneNotification notification) {
        try {
            preparedStatement = (PreparedStatement) connection
                    .prepareStatement("update "+tableName+" set catagory=?, vendor=?, long_description=? , stage=?" +
                            "where service_name=? and CATALOG_URL=?");
            // Parameters start with 1
            preparedStatement.setString(1, notification.get_id());
            preparedStatement.setString(2, notification.getObj().getCategory());
            preparedStatement.setString(3, notification.getObj().getText());
            preparedStatement.setString(4, notification.getObj().getTitle());
            preparedStatement.setString(5, notification.getObj().getRegionsAffected()[0].getId());
            preparedStatement.setString(6, notification.getObj().getLastUpdate().getTime());
            preparedStatement.setString(7, notification.getObj().getLastUpdate().getEmail());
            preparedStatement.setString(8, notification.getObj().getEventTime().getStart());
            preparedStatement.setString(9, notification.getObj().getEventTime().getEnd());
            preparedStatement.executeUpdate();
            //System.out.println("&&&&&&&&&&&&&&& DB Current Record updated..... for "+ notification.get_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        finally {
	        if (preparedStatement != null) {
	        	try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
    }
    
    public OneNotification getBluemixNotificationById(String id) {
    	OneNotification notification = null;
        try {
            preparedStatement = (PreparedStatement) connection.
                    prepareStatement("select * from "+tableName+" where id=?");
            preparedStatement.setString(1, id);
            ResultSet rs = (ResultSet) preparedStatement.executeQuery();

            if (rs.next()) {
            	notification = new OneNotification();
            	Obj obj = new Obj();
            	obj.setCategory(rs.getString("category"));
            	obj.setText(rs.getString("text"));
            	obj.setTitle(rs.getString("title"));
            	String regStr = rs.getString("regionsAffected");
            	String [] regArr = regStr.split(",");
            	RegionsAffected [] regions = new RegionsAffected[regArr.length];
            	for (int i = 0; i < regArr.length; i++)
            	{
            		regions[i] = new RegionsAffected();
            		regions[i].setId(regArr[i]);
            	}
            	obj.setRegionsAffected(regions);
            	
            	LastUpdate lastupdate = new LastUpdate();
            	lastupdate.setEmail(rs.getString("lastUpdateEmail"));
            	lastupdate.setTime(rs.getString("lastUpdateTime"));
            	obj.setLastUpdate(lastupdate);
            	
            	EventTime evttime = new EventTime();
            	evttime.setStart(rs.getString("eventTimeStart"));
            	evttime.setEnd(rs.getString("eventTimeEnd"));
            	obj.setEventTime(evttime);
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
	        if (preparedStatement != null) {
	        	try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
        return notification;
    }

}
