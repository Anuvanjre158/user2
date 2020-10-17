package com.am.DTO;

import java.util.List;

public interface Customer {

	public abstract List<Customer>  viewAllCustomer();
	public abstract List<Complaint> viewComplaintById(int id);
	public abstract Complaint ViewCoomplaintStatus(int id);
	public abstract boolean LunchComplaintWithExistingUser(Person p);
	public abstract boolean lunchComplaintWithOldUser(Person p);
}
