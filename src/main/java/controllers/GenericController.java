package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class GenericController 
{
	@RequestMapping(value = "/errorHandler")
	public String handleError(Model model, @RequestParam("errorMessage") String errorMessage) 
	{
        System.out.println("Message found");
        model.addAttribute("errorMessage", errorMessage);
        return "/error";
    }
}
