package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectionManager.ConnectionManager;
import model.Ticket;

public class TicketDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	String ticketid, typeofpurchase, timeframe, product, ticketdate, comments, customerid;
	double minbudget, maxbudget;
	int quantity;
	
	public void addTicket(Ticket bean) {
		ticketid = bean.getTicketid();
		typeofpurchase = bean.getTypesofpurchase();
		product = bean.getProduct();
		ticketdate = bean.getTicketdate();
		comments = bean.getComments();
		customerid = bean.getCustomerid();
		minbudget = bean.getMinbudget();
		maxbudget = bean.getMaxbudget();
		quantity = bean.getQuantity();
		timeframe = bean.getTimeframe();
		
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "INSERT INTO ticket(ticketid,typeofpurchase,timeframe,product, ticketdate, minbudget, maxbudget, comments, customerid, quantity)VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ticketid);
			ps.setString(2, typeofpurchase);
			ps.setString(3, timeframe);
			ps.setString(4, product);
			ps.setString(5, ticketdate);
			ps.setDouble(6, minbudget);
			ps.setDouble(7, maxbudget);
			ps.setString(8, comments);
			ps.setString(9, customerid);
			ps.setInt(10, quantity);
			//4. execute query
			ps.executeUpdate();	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Ticket getTicketById(String ticketid) {
		Ticket ticket = new Ticket();
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "SELECT * FROM ticket WHERE ticketid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ticketid);			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				ticket.setTicketid(rs.getString("ticketid"));
				ticket.setTypesofpurchase(rs.getString("typeofpurchase"));
				ticket.setComments(rs.getString("comments"));
				ticket.setCustomerid(rs.getString("customerid"));
				ticket.setMaxbudget(rs.getDouble("maxbudget"));
				ticket.setMinbudget(rs.getDouble("minbudget"));
				ticket.setProduct(rs.getString("product"));
				ticket.setQuantity(rs.getInt("quantity"));
				ticket.setTicketdate(rs.getString("ticketdate"));
				ticket.setTimeframe(rs.getString("timeframe"));
				
			}	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}				
		return ticket;
	}
	
	public static List<Ticket> getTickets(){
		List<Ticket> tickets  = new ArrayList<Ticket>();
		
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "SELECT * FROM ticket ORDER BY ticketid";
			stmt = con.createStatement();	
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setTicketid(rs.getString("ticketid"));
				ticket.setTypesofpurchase(rs.getString("typeofpurchase"));
				ticket.setComments(rs.getString("comments"));
				ticket.setCustomerid(rs.getString("customerid"));
				ticket.setMaxbudget(rs.getDouble("maxbudget"));
				ticket.setMinbudget(rs.getDouble("minbudget"));
				ticket.setProduct(rs.getString("product"));
				ticket.setQuantity(rs.getInt("quantity"));
				ticket.setTicketdate(rs.getString("ticketdate"));
				ticket.setTimeframe(rs.getString("timeframe"));
				tickets.add(ticket);
			}	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}				
		
		return tickets;
	}
	
	public void updateTicket(Ticket bean) {
		
		ticketid = bean.getTicketid();
		typeofpurchase = bean.getTypesofpurchase();
		timeframe = bean.getTimeframe();
		product = bean.getProduct();
		ticketdate = bean.getTicketdate();
		comments = bean.getComments();
		customerid = bean.getCustomerid();
		minbudget = bean.getMinbudget();
		maxbudget = bean.getMaxbudget();
		quantity = bean.getQuantity();

		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "UPDATE ticket SET typeofpurchase=?, timeframe=?, product=?, ticketdate=?, minbudget=?, maxbudget=?, comments=?, customerid=?, quantity=? WHERE ticketid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, typeofpurchase);
			ps.setString(2, timeframe);
			ps.setString(3, product);
			ps.setString(4, ticketdate);
			ps.setDouble(5, minbudget);
			ps.setDouble(6, maxbudget);
			ps.setString(7, comments);
			ps.setString(8, customerid);
			ps.setInt(9, quantity);	
			ps.setString(10, ticketid);
			//4. execute query
			ps.executeUpdate();				
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTicket(String ticketid) {
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "DELETE FROM ticket WHERE ticketid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ticketid);
			
			//4. execute query
			ps.executeUpdate();	
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
}
