package login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
	
	public User login(String email, String password)
	{
		User user = userRepository.findByEmail(email);
		if(user != null && user.getPassword().equals(password))
			return user;
		return null;
	}
	
	public User findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	public User findByID(long id)
	{
		return userRepository.findById(id);
	}
	
	public void resetPassword(User user, String newPassword)
	{
		user.setPassword(newPassword);
		userRepository.save(user);
	}
	
	public boolean isUserLogged()
	{
		// Get the current request and session
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		// Check if the user is logged in
		if(session.getAttribute("userID") == null)
			// If the user is not logged in
	        return false;
	    // If the user is logged in, display their profile
	    return true;
	}
}
