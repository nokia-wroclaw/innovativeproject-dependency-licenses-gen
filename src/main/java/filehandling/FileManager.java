package filehandling;

import model.Configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Adam on 2017-09-28.
 */
public class FileManager {

    @Autowired
    private ConfigProperties properties;

    private String pathToTargetDir;

    private ConfigurationFile confgFile;

    private FileConfigurationTypeEnum fileTypeEnum;
    private File targetFile;


    public void handleFile(MultipartFile multipartFile, FileConfigurationTypeEnum fileTypeEnum) throws IOException {
        this.fileTypeEnum = fileTypeEnum;
        pathToTargetDir = properties.getPaths().getTargetDir();
        targetFile = uploadFile(multipartFile);
        confgFile = ConfigurationFileFactory.getConfigurationFileInstanceByFileType(targetFile, fileTypeEnum, properties.getPaths());
        generateResults(confgFile);
    }

    private File createEmptyFileInTargetDir(String fileName) {
        String fullPath = pathToTargetDir + File.separator + fileName;
        File newFile = new File(fullPath);
        return newFile;
    }

    private File uploadFile(MultipartFile multipartFile) throws IOException {
        File targetFile = createEmptyFileInTargetDir(multipartFile.getOriginalFilename());
        multipartFile.transferTo(targetFile);
        return targetFile;
    }

    private void generateResults(ConfigurationFile confgFile) {
        confgFile.generateFileThirdPartDependeciesList();
        confgFile.generateZipLicenseFiles();
    }
}
