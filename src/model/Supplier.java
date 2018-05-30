package model;

public class Supplier {
	private int supplierID;
	private String supplierName;
	private String contactNumber;
	private String email;
	public Supplier(int supplierID,String supplierName, String contactNumber, String email) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", supplierName=" + supplierName + ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}
	
	

}
