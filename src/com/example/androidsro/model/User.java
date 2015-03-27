package com.example.androidsro.model;

/**
 * type User struct {
		Firstname  string `bson:"firstname"`
		Lastname   string `bson:"lastname"`
		Password   string `bson:"password"`
		Email      string `bson:"email"`
		Login      string `bson:"login"`
		IsAdmin    bool   `bson:"isadmin"`
		IsDisabled bool   `bson:"isdisabled"`
	}
 *
 */

public class User {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String login;
	private boolean isAdmin;
	private boolean isDisabled;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isDisabled() {
		return isDisabled;
	}
	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
}
