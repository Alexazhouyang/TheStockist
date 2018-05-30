package model;

public class Users {
	private int userID,mechID;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String address;
	private String description;
	private String password;
	private String role;
	public Users(Integer userID,Integer mechID,String username, String firstname, String lastname, String email, String phonenumber, String address,String description,
			String password, String role) {
		super();
		this.mechID = mechID;
		this.userID = userID;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.description = description;
		this.password = password;
		this.role = role;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getMechID() {
		return mechID;
	}
	public void setMechID(int mechID) {
		this.mechID = mechID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userid="+userID+"usertname=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phonenumber=" + phonenumber + ", address=" + address + ", description=" + description +", password=" + password + ", role="
				+ role + "]";
	}
	

}
