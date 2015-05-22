package mk.ukim.finki.mp.crud.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "job_positions")
public class JobPositions {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int job_id;
	 private String position_name;
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	 public JobPositions()
	 {
		 
	 }
	 public JobPositions(String position_name)
	 {
		 this.position_name=position_name;
	 }
	
	

}
