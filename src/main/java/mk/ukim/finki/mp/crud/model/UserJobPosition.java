package mk.ukim.finki.mp.crud.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_job_position")
public class UserJobPosition {
	
	@Id
	@GeneratedValue
	int id;
	
	int user_id;

	int job_id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private JobPositions job;
	
	
	public UserJobPosition() {
		// TODO Auto-generated constructor stub
	}

	public UserJobPosition(int id, int user_id, int job_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.job_id = job_id;
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