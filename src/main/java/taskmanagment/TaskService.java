package taskmanagment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.User;
import repositories.TaskRepository;

@Service
public class TaskService 
{
	@Autowired
	private TaskRepository database;
	
	/**
	 * @param id
	 * @return List<Task> list of tasks associated with user id.
	 */
	public List<Task> getTasks_byUserId(Long id)
	{
		return database.findAllByUserIdOrderByPriorityDesc(id);
	}
	
	/**
	 * @param User
	 * @return List<Task> list of tasks associated with user object.
	 */
	public List<Task> getTasks_byUser(User user)
	{
		return database.findAllByUserOrderByPriorityDesc(user);
	}
	
	public List<Task> getAllTasks()
	{
		return database.findAllByOrderByPriorityDesc();
	}
	
	public Task findTaskById(Long id) 
	{
		return database.findTaskById(id);
	}
}
