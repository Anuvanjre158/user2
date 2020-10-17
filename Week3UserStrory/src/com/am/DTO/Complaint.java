package com.am.DTO;

public class Complaint {
public int cid;
public String title;
public String description;
public int status;
public int customer_id;
public Complaint() {
	super();
	// TODO Auto-generated constructor stub
}
public Complaint(int cid, String title, String description, int status, int customer_id) {
	super();
	this.cid = cid;
	this.title = title;
	this.description = description;
	this.status = status;
	this.customer_id = customer_id;
}
@Override
public String toString() {
	return  "cid=" + cid + ", title=" + title + ", description=" + description + ", status=" + status + ", customer_id="
			+ customer_id;
}


}
