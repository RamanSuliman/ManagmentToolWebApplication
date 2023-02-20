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
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
	{
		if(userService.isUserLogged())
			return "redirect:/";
		model.addAttribute("user", new User());
		return "login/register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user, HttpSession session)
	{
		if(userService.isUserLogged())
			return "redirect:/";
		userService.register(user);
		return "redirect:/login";
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
	
	@GetMapping("/reset-password")
	public String getPasswordResetForm()
	{
		return "login/resetPasswordForm";
	}
	
	@PostMapping("/reset-password")
	public String getPasswordResetForm(@RequestParam String email, Model model)
	{
		User user = userService.findByEmail(email);
		if(user != null)
		{
			model.addAttribute("user", user);
			return "redirect:/newPaswordForm";
		}else {
			model.addAttribute("message", "User not found");
			return "redirect:/reset-password";
		}
	}
	
	@GetMapping("/newPaswordForm")
	public String getNewPasswordForm()
	{
		return "login/newPasswordForm";
	}	
	
	@PostMapping("/setNewUserPassword")
	public String saveNewPassword(@ModelAttribute("user") User user, @RequestParam String newPassword)
	{
		userService.resetPassword(user, newPassword);
		//Call the getmapping loggin.
		return "redirect:/login";
	}
}
