package com.am.DTO;

import java.util.Arrays;
import java.util.List;

import com.am.DAO.UserDAO;

//import com.sj.DAO.Complaint;

public class Person implements Customer {
public int id;
public String name;
public Complaint c;

	public Person() {
	super();
	// TODO Auto-generated constructor stub
}
UserDAO udao=new UserDAO();
	public Person(int id, String name, Complaint c1) {
		super();
		this.id = id;
		this.name = name;
		this.c=c1;
	}

	public List<Customer> viewAllCustomer(){
		List<Customer> list=udao.viewAllCustomer();
	return list;
	}
	public List<Complaint> viewComplaintById(int id)
	{
		System.out.println("here is the ");
		List<Complaint> list=udao.viewComplaintById(id);
		return list;
	}

	@Override
	public Complaint ViewCoomplaintStatus(int id) {
		// TODO Auto-generated method stub
		Complaint comp=udao.viewComplaintStatus(id); return comp;
		
	}

	@Override
	public boolean LunchComplaintWithExistingUser(Person p) {
		// TODO Auto-generated method stub
		 boolean b=udao.registerNewComplaint(p); 
		 return b;
		
	}

	@Override
	public boolean lunchComplaintWithOldUser(Person p) {
		// TODO Auto-generated method stub
		
		boolean b=udao.registerComplaintWithOldUser(p);
		  return b;
	}
	
	
	/*
	 * 
	 * @Override public String toString() { return "Person [id=" + id + ", name=" +
	 * name + ", c=" + Arrays.toString(c) + ", udao=" + udao + "]"; }
	 */

	/*
	 * @Override public Complaint ViewCoomplaintStatus(int id) {
	 * 
	 * Complaint comp=udao.viewComplaintStatus(id); return comp;
	 * 
	 * }
	 * 
	 * @Override public boolean LunchComplaintWithExistingUser(Person p) { // TODO
	 * Auto-generated method stub
	 * }
	 * 
	 * @Override public boolean lunchComplaintWithOldUser(Person p) { // TODO
	 * Auto-generated method stub boolean b=udao.registerComplaintWithOldUser(p);
	 * return b;
	 * 
	 * }
	 */


}
