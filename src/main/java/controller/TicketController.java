package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDAO;
import dao.CustomerDAO;
import model.Customer;
import model.Ticket;

import java.time.*;
import java.time.format.DateTimeFormatter;


/**
 * Servlet implementation class TicketController
 */
@WebServlet("/TicketController")
public class TicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketDAO dao;
	private CustomerDAO dao1;
	RequestDispatcher view;
	private String forward;   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketController() {
		super();
		dao = new TicketDAO();
		dao1 = new CustomerDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("listTicket")) {
			forward = "listTicket.jsp";
			request.setAttribute("tickets", TicketDAO.getTickets());
		}
		if(action.equalsIgnoreCase("viewTicket")) {
			forward = "viewTicket.jsp";
			String tempTicketid = request.getParameter("ticketid");
			String ticketid = tempTicketid.trim();
			String tempCustomerid = request.getParameter("customerid");
			String customerid = tempCustomerid.trim();
			request.setAttribute("ticket", TicketDAO.getTicketById(ticketid));
			request.setAttribute("customer", CustomerDAO.getCustomerById(customerid));

		}
		if(action.equalsIgnoreCase("deleteTicket")) {
			forward = "listTicket.jsp";
			String tempTicketid = request.getParameter("ticketid");
			String ticketid = tempTicketid.trim();
			dao.deleteTicket(ticketid);
			request.setAttribute("tickets", TicketDAO.getTickets());
		}
		if(action.equalsIgnoreCase("updateTicket")) {
			forward = "updateTicket.jsp";
			String tempTicketid = request.getParameter("ticketid");
			String ticketid = tempTicketid.trim();
			String tempCustomerid = request.getParameter("customerid");
			String customerid = tempCustomerid.trim();
			request.setAttribute("ticket", TicketDAO.getTicketById(ticketid));
			request.setAttribute("customer", CustomerDAO.getCustomerById(customerid));
		}
		if(action.equalsIgnoreCase("addTicket")) {
			forward = "addTicket.jsp";
			request.setAttribute("tickets", TicketDAO.getTickets());

		}
		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDateTime dateNow = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateFormat2 = DateTimeFormatter.ofPattern("ddMMyyyy");

		Ticket tic = new Ticket();
		Customer cust = new Customer();
		tic.setComments(request.getParameter("comment"));
		tic.setMaxbudget(Double.parseDouble(request.getParameter("max-budget")));
		tic.setMinbudget(Double.parseDouble(request.getParameter("min-budget")));
		tic.setProduct(request.getParameter("products"));
		tic.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		tic.setTimeframe(request.getParameter("time-frame"));
		tic.setTypesofpurchase(request.getParameter("purchase-type"));

		String date = dateNow.format(dateFormat);
		String date2 = dateNow.format(dateFormat2);
		cust.setFullname(request.getParameter("fullname")) ;
		cust.setPhoneno(request.getParameter("phoneno"));
		cust.setEmail(request.getParameter("email"));
		cust.setTypeofcontact(Integer.parseInt(request.getParameter("contact-type")));

		cust.setCustomerID(cust.getPhoneno());

		tic.setCustomerid(cust.getCustomerID());

		tic.setTicketdate(date);

		String tempTicketid = request.getParameter("ticketid");
		if(tempTicketid == null || tempTicketid.isEmpty()) {
			String ticketid = date2 + cust.getPhoneno();
			tic.setTicketid(ticketid);
			dao1.addCustomer(cust);
			dao.addTicket(tic);
			
		}
		else{
			String ticketid = tempTicketid.trim();
			tic.setTicketid(ticketid);
			dao1.updateCustomer(cust);
			dao.updateTicket(tic);
			
		}

		//forward quest
		request.setAttribute("tickets", TicketDAO.getTickets());
		view = request.getRequestDispatcher("listTicket.jsp");
		view.forward(request, response);
	}

}
