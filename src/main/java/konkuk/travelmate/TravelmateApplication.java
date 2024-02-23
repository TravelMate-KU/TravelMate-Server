package konkuk.travelmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TravelmateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelmateApplication.class, args);
	}

}
