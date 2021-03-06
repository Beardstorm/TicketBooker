package se.ticketbooker.www;

public class User {
	
	private static User instance = null;
	private String name;
	private String phone;
	private String email;
	private String role;
	private String password;
	
	public User(){
		role = "guest";
	}
	
	public static User getInstance(){
		if(instance == null){
			instance = new User();
		}
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
