package pep.diva.trackevents.eventtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author divakar
 *
 */
@SpringBootApplication
public class EventTrackingApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EventTrackingApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EventTrackingApplication.class, args);
	}
}
