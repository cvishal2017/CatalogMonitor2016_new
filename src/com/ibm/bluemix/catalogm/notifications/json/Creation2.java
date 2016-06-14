package com.ibm.bluemix.catalogm.notifications.json;

public class Creation2
{
    private String time;

    private String email;

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [time = "+time+", email = "+email+"]";
    }
}