package controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
@EnableWebMvc
public class ExceptionHandlerController
{
	@ExceptionHandler(Exception.class)
    public String handleException(Exception ex, RedirectAttributes redirectAttributes) 
	{
		// Handle the exception and set a message to be displayed on the error page
        String errorMessage = "An error occurred: " + ex.getMessage();
        redirectAttributes.addAttribute("errorMessage", errorMessage);
	    // Redirect to the error page
	    return "redirect:/errorHandler";
    }
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex, RedirectAttributes redirectAttributes) 
	{
	    // Handle the exception and set a message to be displayed on the error page
	    String errorMessage = "A NullPointerException occurred: " + ex.getMessage();
	    redirectAttributes.addAttribute("errorMessage", errorMessage);
	    // Redirect to the error page
	    return "redirect:/errorHandler";
	}
}
