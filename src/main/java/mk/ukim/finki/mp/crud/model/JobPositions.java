package mk.ukim.finki.mp.crud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "job_positions")
public class JobPositions {
	
	@Id
	@GeneratedValue
	int job_id;
	int user_id;
	String position_name;
	double salary;
	@Type(type="date")
	Date starting_date;
	
	public JobPositions() {
	}

	public JobPositions(int job_id, int user_id, String position_name,
			int salary, Date starting_date) {
		super();
		this.job_id = job_id;
		this.user_id = user_id;
		this.position_name = position_name;
		this.salary = salary;
		this.starting_date = starting_date;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getStarting_date() {
		return starting_date;
	}

	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}

	

}
