package filehandling;

/**
 * Created by Adam on 2017-09-19.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class ReceiveFileController {
    private String fileName;
    private File serverFile;
    private File dir;
    private FileConfigurationTypeEnum fileTypeEnum;
    private ConfigurationFile confgFile;

//    @Autowired
//    private ConfigurationFile confgFile;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("file") MultipartFile file, @RequestParam( value="fileType") int fileType) {
        if (!file.isEmpty()) {
            try {
                fileTypeEnum = FileConfigurationTypeEnum.getInstanceById(fileType);

                byte[] bytes = file.getBytes();

                String rootPath = System.getProperty("user.home");
                dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getName());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                confgFile.generateFileContainingThirdPartDependeciesList();

                return "You successfully uploaded file";
            } catch (Exception e) {
                return "You failed to upload " + e.getMessage();
            }
        } else {
            return "You failed to upload "
                    + " because the file was empty.";
        }
    }

}
