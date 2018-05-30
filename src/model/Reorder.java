package model;

public class Reorder {
	
	int productID,minOrderQty,qty,reorderQty,orderQty,supplierID,orderID;
	String partNO;
	float unitPrice,price;
	String orderDate;
	public Reorder(String orderDate,int productID,int orderID, int minOrderQty, int qty,int supplierID, int reorderQty, String partNO, int orderQty, float unitPrice,
			float price ) {
		super();
		this.orderID=orderID;
		this.supplierID=supplierID;
		this.productID = productID;
		this.minOrderQty = minOrderQty;
		this.qty = qty;
		this.reorderQty = reorderQty;
		this.partNO = partNO;
		this.orderQty = orderQty;
		this.unitPrice = unitPrice;
		this.price = price;
		this.orderDate = orderDate;
	}
	
	public Reorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getMinOrderQty() {
		return minOrderQty;
	}
	public void setMinOrderQty(int minOrderQty) {
		this.minOrderQty = minOrderQty;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getReorderQty() {
		return reorderQty;
	}
	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}
	public String getPartNO() {
		return partNO;
	}
	public void setPartNO(String partNO) {
		this.partNO = partNO;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	

}
