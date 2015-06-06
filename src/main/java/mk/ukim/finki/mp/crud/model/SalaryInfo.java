package mk.ukim.finki.mp.crud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "salary_info")
public class SalaryInfo {

	public SalaryInfo() {
		
	}
	
	@Id
	@GeneratedValue
	int salary_id;
	int user_id;
	@Type(type="date")
	Date datee;
	int salary;
	
	public SalaryInfo(int user_id, int salary_id, Date datee, int salary) {
		super();
		this.user_id = user_id;
		this.salary_id = salary_id;
		this.datee = datee;
		this.salary = salary;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}	
}
