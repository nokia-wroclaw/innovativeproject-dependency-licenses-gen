package filehandling;

import businessLogic.impl.Maven.MavenService;
import license.jacksonTemplate.LicenseJackson;
import model.Configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileProccesor {
    @Autowired
    ConfigProperties properties;

    @Autowired
    MavenService mvnService;

    public File process(File file, FileConfigurationTypeEnum fileTypeEnum) {
        File zip = null;
                if(fileTypeEnum == FileConfigurationTypeEnum.MAVEN) {
            mvnService.generateFiles(file);
            String json = mvnService.getJSON();
            zip = mvnService.getGeneratedFiles();
        }
    return zip;
    }
}
