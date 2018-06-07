package barbatchov.openoffice.docconverter.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app")
public class ApplicationProperties {

    private String openOfficeHome = "/opt/openoffice4/";

    private Integer openOfficePort = 8100;

}
