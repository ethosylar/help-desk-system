package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectionManager.ConnectionManager;
import model.Customer;

public class CustomerDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	String customerid, fullname, email, phoneno;
	int typeofcontact;

	public void addCustomer(Customer bean) {
		customerid = bean.getCustomerID();
		fullname = bean.getFullname();
		email = bean.getEmail();
		phoneno = bean.getPhoneno();
		typeofcontact = bean.getTypeofcontact();
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "INSERT INTO customer(customerid, fullname, email, phoneno, typeofcontact)VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, customerid);
			ps.setString(2, fullname);
			ps.setString(3, email);
			ps.setString(4, phoneno);
			ps.setInt(5, typeofcontact);
			//4. execute query
			ps.executeUpdate();	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Customer getCustomerById(String customerid) {
		Customer customer = new Customer();
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "SELECT * FROM customer WHERE customerid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, customerid);			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				customer.setCustomerID(rs.getString("customerid"));
				customer.setEmail(rs.getString("email"));
				customer.setFullname(rs.getString("fullname"));
				customer.setPhoneno(rs.getString("phoneno"));
				customer.setTypeofcontact(rs.getInt("typeofcontact"));

			}	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}				
		return customer;
	}

	public static List<Customer> getCustomers(){
		List<Customer> customers  = new ArrayList<Customer>();

		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "SELECT * FROM ticket ORDER BY ticketid";
			stmt = con.createStatement();			

			//4. execute query
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(rs.getString("customerid"));
				customer.setEmail(rs.getString("email"));
				customer.setFullname(rs.getString("fullname"));
				customer.setPhoneno(rs.getString("phoneno"));
				customer.setTypeofcontact(rs.getInt("typeofcontact"));
				customers.add(customer);
			}	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}				

		return customers;
	}

	public void updateCustomer(Customer bean) {

		customerid = bean.getCustomerID();
		fullname = bean.getFullname();
		email = bean.getEmail();
		phoneno = bean.getPhoneno();
		typeofcontact = bean.getTypeofcontact();

		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "UPDATE customer SET fullname=?, email=?, phoneno=?, typeofcontact=? WHERE customerid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, fullname);
			ps.setString(2, email);
			ps.setString(3, phoneno);
			ps.setInt(4, typeofcontact);
			ps.setString(5, customerid);
			//4. execute query
			ps.executeUpdate();				
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(String customerid) {
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "DELETE FROM customer WHERE customerid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, customerid);
			
			//4. execute query
			ps.executeUpdate();	
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
