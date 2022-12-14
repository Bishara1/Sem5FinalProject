package logic;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Subscriber implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private String Fname, LName, id, PhoneNum, Email, Visa, SubNum,UserName,Password;

	public Subscriber(String fname, String lName, String Id, String phoneNum, String email, String visa, String subNum,String username,String password) {
		super();
		Fname = fname;
		LName = lName;
		id = Id;
		PhoneNum = phoneNum;
		Email = email;
		Visa = visa;
		SubNum = subNum;
		UserName = username;
		Password = password;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFname() {
		return Fname;
	}
	
	public void setFname(String fname) {
		Fname = fname;
	}
	
	public String getLName() {
		return LName;
	}
	
	public void setLName(String lName) {
		LName = lName;
	}
	
	public String getPhoneNum() {
		return PhoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getVisa() {
		return Visa;
	}
	
	public void setVisa(String visa) {
		Visa = visa;
	}
	
	public String getSubNum() {
		return SubNum;
	}
	
	public void setSubNum(String subNum) {
		SubNum = subNum;
	}
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return this.Fname + " " + this.LName + " " + this.id + " " + this.Email + " " + this.PhoneNum + " " + this.Visa + " " + this.SubNum +" "+ this.UserName+" "+ this.Password;
	}
}
