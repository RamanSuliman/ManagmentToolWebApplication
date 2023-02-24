package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import login.User;
import taskmanagment.Task;

public interface TaskRepository extends JpaRepository<Task, Long>
{
	Task findTaskById(Long id);
	
	/**
	 * The method is defined using the Spring Data JPA naming convention:
			1- Specifies that the method should start with findAllBy.
			2- Followed by the name of the property to filter by (OrderByPriority).
			3- The direction of the sort (Desc for descending order).
	*/
	List<Task> findAllByOrderByPriorityDesc();
	List<Task> findAllByUserOrderByPriorityDesc(User user);
	List<Task> findAllByUserIdOrderByPriorityDesc(Long userId);
}
