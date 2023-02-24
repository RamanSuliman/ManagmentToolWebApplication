package taskmanagment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "tasks")
public class Task 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Min(value = 1, message = "Priority must be at least 1")
	@Max(value = 3, message = "Priority must be maximum 3")
	private int priority;
	
	@Column(name = "due_date", nullable = false)
	@Enumerated(EnumType.STRING)
	private String date;
	
	@Column(name = "my_field", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private String status;		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getDue_date() {
		return date;
	}
	public void setDue_date(String due_date) {
		this.date = due_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
