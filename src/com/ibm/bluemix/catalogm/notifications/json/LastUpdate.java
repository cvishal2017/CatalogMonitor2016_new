package com.ibm.bluemix.catalogm.notifications.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class LastUpdate {
	private String time;
	 
	@JsonDeserialize(as=String.class)
    public String email;

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    @JsonDeserialize(as=String.class)
    public String getEmail ()
    {
        return email;
    }

    @JsonDeserialize(as=String.class)
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
