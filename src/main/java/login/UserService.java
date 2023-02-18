package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	public void register(User user)
	{
		userRepository.save(user);
	}
	
	public User login(String username, String password)
	{
		User user = userRepository.findByUsername(username);
		if(user != null && user.getPassword().equals(password))
			return user;
		return null;
	}
	
	public User findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	public void resetPassword(User user, String newPassword)
	{
		user.setPassword(newPassword);
		userRepository.save(user);
	}
}
