package model;

public class Products {
	private int productID;
	private String partNO;
	private String productName ;
	private float unitPrice;
	private int supplierID;
	private String description;
	private String color;
	private String dimension;
	private String manufacturer;
	private String reorderLevel;
	private String shelfLocation;
	private int minOrderQty;
	private int qty;
	private int damageQty;
	public Products(int productID,String productName, String partNO,float unitPrice, int supplierID, String description, String color,
			String dimension, String manufacturer, String reorderLevel, String shelfLocation, int minOrderQty, int qty,
			int damageQty) {
		super();
		this.productID=productID;
		this.partNO=partNO;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.supplierID = supplierID;
		this.description = description;
		this.color = color;
		this.dimension = dimension;
		this.manufacturer = manufacturer;
		this.reorderLevel = reorderLevel;
		this.shelfLocation = shelfLocation;
		this.minOrderQty = minOrderQty;
		this.qty = qty;
		this.damageQty = damageQty;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getPartNO() {
		return partNO;
	}
	public void setPartNO(String partNO) {
		this.partNO = partNO;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(String reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public String getShelfLocation() {
		return shelfLocation;
	}
	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
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
	public int getDamageQty() {
		return damageQty;
	}
	public void setDamageQty(int damageQty) {
		this.damageQty = damageQty;
	}
	@Override
	public String toString() {
		return "Products [productName=" + productName + ", unitPrice=" + unitPrice + ", supplierID=" + supplierID
				+ ", description=" + description + ", color=" + color + ", dimension=" + dimension + ", manufacturer="
				+ manufacturer + ", reorderLevel=" + reorderLevel + ", shelfLocation=" + shelfLocation
				+ ", minOrderQty=" + minOrderQty + ", qty=" + qty + ", damageQty=" + damageQty + "]";
	}
	
	
	
	
	
	

}
