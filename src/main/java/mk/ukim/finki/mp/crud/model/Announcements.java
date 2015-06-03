package mk.ukim.finki.mp.crud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "announcements")
public class Announcements {

	@Id
	@GeneratedValue
	int announcement_id;
	
	int user_id;
	
	String announcement_title;
	
	public String getAnnouncement_title() {
		return announcement_title;
	}

	public void setAnnouncement_title(String announcement_title) {
		this.announcement_title = announcement_title;
	}

	@Type(type="date")
	Date datum;
	
	String announcement;
	
	public Announcements() {
		// TODO Auto-generated constructor stub
	}

	public Announcements(int announcement_id, int user_id, Date datum,String announcement_title,
			String announcement) {
		super();
		this.announcement_title=announcement_title;
		this.announcement_id = announcement_id;
		this.user_id = user_id;
		this.datum = datum;
		this.announcement = announcement;
	}

	public int getAnnouncement_id() {
		return announcement_id;
	}

	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	
	
	
}
