package com.ibm.bluemix.catalogm.notifications.json;

public class OneNotification {
	    private String _id;

	    private Obj obj;

	    public String get_id ()
	    {
	        return _id;
	    }

	    public void set_id (String _id)
	    {
	        this._id = _id;
	    }

	    public Obj getObj ()
	    {
	        return obj;
	    }

	    public void setObj (Obj obj)
	    {
	        this.obj = obj;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [_id = "+_id+", obj = "+obj+"]";
	    }
}
