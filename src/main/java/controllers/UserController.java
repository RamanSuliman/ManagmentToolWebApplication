package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import login.User;
import login.UserService;

@Controller
@EnableWebMvc
public class UserController 
{
	@Autowired
	private UserService userService;

	
	@GetMapping("/home")
	public String getHome()
	{
		return "/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) 
	{	    
		String sessioner;
		if( session == null || (sessioner = (String) session.getAttribute("userID")) == null)
			return "redirect:/";
	    System.out.println("User ID: " +  (User) userService.findByID(Long.parseLong(sessioner)));
	    session.invalidate();  // Invalidates this session then unbinds any objects boundto it.
	    return "redirect:/login"; // Redirect to the login page after logout
	}
	
	@GetMapping("/login")
	public String showLoginForm()
	{
		if(userService.isUserLogged())
			return "redirect:/";
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, HttpSession session)
	{
		if(userService.isUserLogged())
			return "redirect:/";
		user = userService.findByEmail(user.getEmail());
		System.out.println(user.getEmail() + " " + user.getId());
		if(user.getId() > 0) {
			session.setAttribute("userID", user.getId().toString());
			return "redirect:/";
		}else
			return "redirect:/login";
	}
}
