package mk.ukim.finki.mp.crud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "announcements")
public class Announcements {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int announcement_id;
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 private User user;
	 private Date datum;
	 @Column(name="announcement")
	 private String message;
	 public Announcements()
	 {
		 
	 }
	 public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Announcements(Date datum,String message)
	 {
		  
		 this.datum=datum;
		 this.message=message;
	 }
	public int getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	 
	 
	 
	
	
	
}
