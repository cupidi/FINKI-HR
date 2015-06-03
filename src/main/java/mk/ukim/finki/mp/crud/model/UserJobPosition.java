package mk.ukim.finki.mp.crud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_job_position")
public class UserJobPosition {
	
	@Id
	@GeneratedValue
	int id;
	
	int user_id;

	int job_id;
	
	@Type(type="date")
	Date date;
	
	int salary_id;
	
	public UserJobPosition() {
		// TODO Auto-generated constructor stub
	}

	public UserJobPosition(int id, int user_id, int job_id,Date date,int salary_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.job_id = job_id;
		this.date=date;
		this.salary_id = salary_id;
	}

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
	
}
