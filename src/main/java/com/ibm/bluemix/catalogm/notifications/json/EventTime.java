package com.ibm.bluemix.catalogm.notifications.json;

public class EventTime
{
    private String start;

    private String end;

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    public String getEnd ()
    {
        return end;
    }

    public void setEnd (String end)
    {
        this.end = end;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [start = "+start+", end = "+end+"]";
    }
}
			
			