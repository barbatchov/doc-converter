package barbatchov.openoffice.docconverter;

import barbatchov.openoffice.docconverter.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class DocConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocConverterApplication.class, args);
	}

}
