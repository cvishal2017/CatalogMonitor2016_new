package com.ibm.bluemix.catalogm.notifications.json;

public class Creation
{
    private String time;

    private Email email;

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public Email getEmail ()
    {
        return email;
    }

    public void setEmail (Email email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [time = "+time+", email = "+email+"]";
    }
}
			
	