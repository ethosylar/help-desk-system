

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Ticket;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class helpDesk
 */
@WebServlet("/helpDesk")	
public class helpDesk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public helpDesk() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LocalDateTime dateNow = LocalDateTime.now();
		Customer cust = new Customer();
		Ticket tic = new Ticket();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMyyyy");
		
		//retrieve input
		String fullname = request.getParameter("fullname");
		String phoneno = request.getParameter("phoneno");
		String email = request.getParameter("email");
		int contactType = Integer.parseInt(request.getParameter("contact-type"));
		String purchaseType = request.getParameter("purchase-type");
		String date = dateNow.format(dateFormat);
		double minBudget = Double.parseDouble(request.getParameter("min-budget"));
		double maxBudget = Double.parseDouble(request.getParameter("max-budget"));
		String timeFrame = request.getParameter("time-frame");
		String product = request.getParameter("products");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String comment = request.getParameter("comment");
		
		String custid = phoneno;
		String ticketid = date + phoneno;
				
		cust = new Customer(custid, fullname, phoneno, email, contactType);
		
		tic = new Ticket(ticketid, purchaseType, timeFrame, product, date, minBudget, maxBudget, comment, quantity);
		tic.setCustomerid(custid);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><title>Thank You For Your Response</title></head><body>");
		out.println("<h1>Thank you for your feeback! We will give our reply as soon as possible :)</h1>");
		out.println("Full Name: " + cust.getFullname() + "<br>");
		out.println("Phone No: " + cust.getPhoneno() + "<br>");
		out.println("Email: " + cust.getEmail() + "<br>");
		if(cust.getTypeofcontact()== 1)
			out.println("Preferred Contact: " + "Email" + "<br>");
		else
			out.println("Preferred Contact: " + "Phone No" + "<br>");
		
		out.println("Types of purchase: " + tic.getTypesofpurchase() + "<br>");
		out.println("Budget range: RM" + tic.getMinbudget() + " - " + tic.getMaxbudget() + "<br>");
		out.println("Time frame of your purchase: " + tic.getTimeframe() + "<br>");
		out.println("You're interested to buy: " + tic.getProduct() + "<br>");
		out.println("Product Quantity: " + tic.getQuantity() + "<br>");
		
		if(tic.getComments().isEmpty())
			out.println("Your Comments, Enquiries, Instruction: " + "None" + "<br>");
		else
			out.println("Your Comments, Enquiries, Instruction: " + tic.getComments() + "<br>");
		out.println("</body></html>");
	}

}
