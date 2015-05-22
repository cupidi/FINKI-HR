package mk.ukim.finki.mp.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_job_position")
public class UserJobPosition {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 @ManyToOne
	private JobPositions jobPositions;
	 @ManyToOne
	 private User user;
	 public UserJobPosition()
	 {
		 
	 }
	 public UserJobPosition(JobPositions jobPositions,User user)
	 {
		 this.jobPositions=jobPositions;
		 this.user=user;
	 }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public JobPositions getJobPositions() {
		return jobPositions;
	}
	public void setJobPositions(JobPositions jobPositions) {
		this.jobPositions = jobPositions;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 
	 
	
}
