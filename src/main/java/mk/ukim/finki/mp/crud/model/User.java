package mk.ukim.finki.mp.crud.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	

	@Id
	@GeneratedValue
	int user_id;
	String name;
	String surname;
	String address;
	String mail;
	String phone;
	String picture;
	Date birth_date;
	long ssn;
	String type;
	Date hire_date;
	String gender;
	int manager_id;
	String password;
	String cv;
	//String jobTitle;
	
	public User(int user_id, String name, String surname, String address,
			String mail, String phone, String picture, Date birth_date,
			long ssn, String type, Date hire_date, String gender,
			int manager_id, String password, String cv) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.mail = mail;
		this.phone = phone;
		this.picture = picture;
		this.birth_date = birth_date;
		this.ssn = ssn;
		this.type = type;
		this.hire_date = hire_date;
		this.gender = gender;
		this.manager_id = manager_id;
		this.password = password;
		this.cv = cv;
		//this.jobTitle=jobTitle;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	
	/*
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	*/
	
}
