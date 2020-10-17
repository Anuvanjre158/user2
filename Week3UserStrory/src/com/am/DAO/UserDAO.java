package com.am.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.am.DTO.Customer;
import com.am.DTO.Complaint;
import com.am.DTO.Person;

public class UserDAO {
Connection con;
Statement s;
PreparedStatement ps;
ResultSet r;
public UserDAO() {
	super();
	// TODO Auto-generated constructor stub
	con=new DBConnector().getcon();
	
}
public List<Customer> viewAllCustomer() {
	try {
		s=con.createStatement();
		r=s.executeQuery("select*from customer");
		List<Customer>clist=new ArrayList<Customer>();
		while(r.next()) {
			//System.out.println(r.getInt(1)+" "+r.getString(2));
			Person p=new Person();
			p.id=r.getInt(1);
			p.name=r.getString(2);
			clist.add(p);
		}return clist;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public List<Complaint>viewComplaintById(int id)
 {
	try {ps=con.prepareStatement("select*customer id=?");
		ps.setInt(1, id);
		ResultSet r=ps.executeQuery();
		boolean b=r.next();
		if(b) {
			ps=con.prepareStatement("select*complaint(customer id=?)");
			ps.setInt(1, id);
			r=ps.executeQuery();
			List<Complaint>clist=new ArrayList<Complaint>();
			while(r.next()) {
				Complaint c=new Complaint();
				c.cid=r.getInt(1);
				c.title=r.getString(2);
				c.description=r.getString(3);
				c.status=r.getInt(4);
				c.customer_id=r.getInt(5);
				clist.add(c);
			}return clist;
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}return null;
		
}
public Complaint viewComplaintStatus(int id) {

	try {
			ps=con.prepareStatement("select*complaint customer id ?");
			ps.setInt(1, id);
			r=ps.executeQuery();
			
			while(r.next()) {
				Complaint c=new Complaint();
				c.cid=r.getInt(1);
				c.title=r.getString(2);
				c.description=r.getString(3);
				c.status=r.getInt(4);
				c.customer_id=r.getInt(5);
				//clist.add(c);
				return c;
			}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}	
public boolean registerNewComplaint(Person p) {
	try {
		
		ps=con.prepareStatement("customer values ?,?");
		ps.setInt(1,p.id);
		ps.setNString(2,p.name);
		ps.execute();
		
		PreparedStatement ps1=con.prepareStatement("complaint values??");
		ps1.setInt(1, p.c.cid);
		ps1.setString(2, p.c.title);
		ps1.setString(3, p.c.description);
		ps1.setInt(4, 1);
		ps1.setInt(5, p.c.customer_id);
		ps1.execute();
		return true;
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
}



public boolean registerComplaintWithOldUser(Person p) {
	// TODO Auto-generated method stub
	try {
		ps=con.prepareStatement("select*customer id=?");
	
	ps.setInt(1, p.id);
	ResultSet r=ps.executeQuery();
	boolean b=r.next();
	if(b) {
		PreparedStatement ps1=con.prepareStatement("insert complaint ??");
	ps1.setInt(1, p.c.cid);
	ps1.setString(2, p.c.title);
	ps1.setString(3, p.c.description);
	ps1.setInt(4, 1);
	ps1.setInt(5, p.c.customer_id);
	ps1.execute();
	return false;

	}
	
	else {
	return false;
	}
	}
	catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
}


}