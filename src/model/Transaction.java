package model;

public class Transaction {
	int transactionID,productID,mechID,usage;
	String customerName,dateofUsage;
	public Transaction(int transactionID, int productID, int mechID, int usage, String customerName, String dateofUsage) {
		super();
		this.transactionID = transactionID;
		this.productID = productID;
		this.mechID = mechID;
		this.usage = usage;
		this.customerName = customerName;
		this.dateofUsage = dateofUsage;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getMechID() {
		return mechID;
	}
	public void setMechID(int mechID) {
		this.mechID = mechID;
	}
	public int getUsage() {
		return usage;
	}
	public void setUsage(int usage) {
		this.usage = usage;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDateofUsage() {
		return dateofUsage;
	}
	public void setDateofUsage(String dateofUsage) {
		this.dateofUsage = dateofUsage;
	}
	

}
