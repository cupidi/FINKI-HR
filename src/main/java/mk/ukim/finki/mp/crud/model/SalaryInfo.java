package mk.ukim.finki.mp.crud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salary_info")
public class SalaryInfo {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int salary_id;
	   private Date datee;
	   private double salary;
	   @ManyToOne
	   private User user;
	   
	   public SalaryInfo()
	   {
		   
	   }
	   public SalaryInfo(Date datee,double salary,User user)
	   {
		   this.datee=datee;
		   this.salary=salary;
		   this.user=user;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	   
	   
	   
	   
	
	
	
	
	
}
