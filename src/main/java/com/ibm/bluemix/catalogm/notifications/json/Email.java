package com.ibm.bluemix.catalogm.notifications.json;


public class Email
{
    private String _id;

    private String userId;

    private String role;

    private String provider;

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    public String getProvider ()
    {
        return provider;
    }

    public void setProvider (String provider)
    {
        this.provider = provider;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_id = "+_id+", userId = "+userId+", role = "+role+", provider = "+provider+"]";
    }
}