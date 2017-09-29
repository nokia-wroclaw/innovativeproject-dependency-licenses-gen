package model.Configuration;

import filehandling.FileManager;
import model.Configuration.ConfigProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Adam on 2017-09-29.
 */
@Configuration
@EnableConfigurationProperties(ConfigProperties.class)
@ConfigurationProperties
public class ConfigurationApp {

    @Bean
    public FileManager fileManager(){
        return new FileManager();
    }
}
