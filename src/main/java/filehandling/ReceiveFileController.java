package filehandling;

import model.Configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ReceiveFileController {
    private FileConfigurationTypeEnum fileTypeEnum;

    @Autowired
    private FileManager fileManager;

    @Autowired
    private FileProccesor fileProccesor;

    @Autowired
    private ConfigProperties prop;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("file") MultipartFile multipartFile, @RequestParam(value = "fileType") String fileType) {
        if (!multipartFile.isEmpty()) {
                fileTypeEnum = FileConfigurationTypeEnum.getInstanceIgnoringCase(fileType);
            try {
                File uploadedFile = fileManager.uploadFile(multipartFile);
                String json = fileProccesor.process(uploadedFile, fileTypeEnum);
                return json;
            } catch (IOException e) {
                e.printStackTrace();
                return "You failed to upload file";

            }
        } else {
            return "You failed to upload "
                    + " because the file was empty.";
        }
    }
}
