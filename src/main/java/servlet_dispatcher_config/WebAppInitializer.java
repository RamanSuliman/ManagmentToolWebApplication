package servlet_dispatcher_config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer 
{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException 
	{
		// Create the application context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        //Deinfe the xml file.
        appContext.setConfigLocation("configurations");

        
        // Create the dispatcher servlet with whatever name such as "dispatcher" will be used by the server container to identify the dispacter.
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}
	
}
