package model;

public class Customer {
	private String customerID;
	private String fullname;
	private String phoneno;
	private String email;
	private int typeofcontact;
	
	public Customer() {}
	
	public Customer(String id, String f, String p, String e, int t) {
		this.setCustomerID(id);
		this.setEmail(e);
		this.setFullname(f);
		this.setPhoneno(p);
		this.setTypeofcontact(t);
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTypeofcontact() {
		return typeofcontact;
	}
	public void setTypeofcontact(int typeofcontact) {
		this.typeofcontact = typeofcontact;
	}
	
	
}
