package edu.csuft.assess.service;

public class User {

	String name;
	String password;
	String authority;

	public User() {
	}

	public User(String name, String password, String authority) {
		super();
		this.name = name;
		this.password = password;
		this.authority = authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", authority=" + authority + "]";
	}

}
