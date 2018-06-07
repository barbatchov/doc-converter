package barbatchov.openoffice.docconverter.config.ooffice;

import barbatchov.openoffice.docconverter.config.properties.ApplicationProperties;
import org.jodconverter.office.DefaultOfficeManagerBuilder;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenOfficeConfig {

    @Bean
    public OfficeManager officeManager(final ApplicationProperties applicationProperties) throws OfficeException {
        final DefaultOfficeManagerBuilder defaultOfficeManagerBuilder = new DefaultOfficeManagerBuilder();
        defaultOfficeManagerBuilder.setOfficeHome(applicationProperties.getOpenOfficeHome());
        defaultOfficeManagerBuilder.setPortNumber(applicationProperties.getOpenOfficePort());
        final OfficeManager officeManager = defaultOfficeManagerBuilder.build();
        officeManager.start();
        return officeManager;
    }

}
