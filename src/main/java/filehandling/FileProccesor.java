package filehandling;

import businessLogic.impl.MavenService;
import model.Configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created by Adam on 2017-10-24.
 */
public class FileProccesor {
    @Autowired
    ConfigProperties properties;

    @Autowired
    MavenService mvnService;

    public String process(File file, FileConfigurationTypeEnum fileTypeEnum) {
        String json = null;
                if(fileTypeEnum == FileConfigurationTypeEnum.MAVEN) {
            mvnService.generateFiles(file);
            json = mvnService.getJSON();
        }
    return json;
    }
}
