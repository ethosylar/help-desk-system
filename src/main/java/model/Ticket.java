package model;
public class Ticket {
	private String ticketid;
	private String typesofpurchase;
	private String timeframe;
	private String product;
	private String ticketdate;
	private double minbudget;
	private double maxbudget;
	private String comments;
	private String customerid;
	private int quantity;

	public Ticket() {}
	
	public Ticket(String id, String t, String f, String p, String d, double min, double max, String c, int q) {
		this.setComments(c);
		this.setMaxbudget(max);
		this.setMinbudget(min);
		this.setProduct(p);
		this.setTicketdate(d);
		this.setTicketid(id);
		this.setTimeframe(f);
		this.setTypesofpurchase(t);
		this.setQuantity(q);
	}
	
	public String getTicketid() {
		return ticketid;
	}
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}
	public String getTypesofpurchase() {
		return typesofpurchase;
	}
	public void setTypesofpurchase(String typesofpurchase) {
		this.typesofpurchase = typesofpurchase;
	}
	public String getTimeframe() {
		return timeframe;
	}
	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTicketdate() {
		return ticketdate;
	}
	public void setTicketdate(String ticketdate) {
		this.ticketdate = ticketdate;
	}
	public double getMinbudget() {
		return minbudget;
	}
	public void setMinbudget(double minbudget) {
		this.minbudget = minbudget;
	}
	public double getMaxbudget() {
		return maxbudget;
	}
	public void setMaxbudget(double maxbudget) {
		this.maxbudget = maxbudget;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
