package filehandling;

import filehandling.impl.GradleConfigurationFile;
import filehandling.impl.MavenConfigurationFile;
import filehandling.impl.SBTConfigurationFile;
import model.Configuration.ConfigProperties;

import java.io.File;

/**
 * Created by Adam on 2017-09-29.
 */
public class ConfigurationFileFactory {
    public static ConfigurationFile getConfigurationFileInstanceByFileType(File file, FileConfigurationTypeEnum fileTypeEnum, ConfigProperties.Paths pathProperties){
        switch(fileTypeEnum) {
            case MAVEN:
                return new MavenConfigurationFile(file, pathProperties);
            case GRADLE:
                return new GradleConfigurationFile(file, pathProperties);
            case SBT:
                return new SBTConfigurationFile(file, pathProperties);
        }
        return null;
    }

}
