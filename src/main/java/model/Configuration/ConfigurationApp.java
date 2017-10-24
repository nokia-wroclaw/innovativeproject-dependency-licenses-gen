package model.Configuration;

import businessLogic.impl.MavenService;
import filehandling.FileManager;
import filehandling.FileProccesor;
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
    public FileManager fileManager() {
        return new FileManager();
    }

    @Bean
    public FileProccesor fileProccesor() {
        return new FileProccesor();
    }

    @Bean
    public MavenService mavenService() {return new MavenService();}
}
