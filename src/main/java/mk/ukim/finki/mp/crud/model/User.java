package mk.ukim.finki.mp.crud.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 


@Entity
@Table(name = "User")
public class User {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private  int user_id;
      private String name;
      private String surname;
      private String address;
      private String mail;
      private String phone;
      private String picture;
      private Date birth_date;
      private long ssn;
      @Column(name="type")
      private String Type;
      private Date  hire_date;
      @Column(name="gender")
      private String Gender;
      private String password;
      @Column(name="cv")
      private String CV;
      @ManyToOne(cascade={CascadeType.ALL})
      @JoinColumn(name="manager_id")
      private User manager;
      
      @OneToMany(mappedBy="manager")
      private Set<User> subordinates=new HashSet<User>();
      public User()
      {
    	  
      }
      public User(String name,String surname,String address,String mail,String phone,String picture,Date birth_date,long ssn,String Type,Date hire_date,String Gender,String password,String CV,User manager)
      {
    	  this.name=name;
    	  this.surname=surname;
    	  this.address=address;
    	  this.mail=mail;
    	  this.phone=phone;
    	  this.picture=picture;
    	  this.birth_date=birth_date;
    	  this.ssn=ssn;
    	  this.Type=Type;
    	  this.hire_date=hire_date;
    	  this.Gender=Gender;
    	  this.password=password;
    	  this.CV=CV;
    	  this.manager=manager;
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
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCV() {
		return CV;
	}

	public void setCV(String cV) {
		CV = cV;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public Set<User> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<User> subordinates) {
		this.subordinates = subordinates;
	}

	 
      
      
      

	 
	
	
	
}