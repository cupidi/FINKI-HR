package mk.ukim.finki.mp.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salary_info")
public class SalaryInfo {

	@Id
	@GeneratedValue
	int salary_id;
	
	//int user_id;
	
	//Date datee;
	
	double salary;

	public SalaryInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public SalaryInfo(int salary_id, double salary) {
		super();
		this.salary_id = salary_id;
		//this.user_id = user_id;
		//this.datee = datee;
		this.salary = salary;
	}

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	/*
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}
*/
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
}
