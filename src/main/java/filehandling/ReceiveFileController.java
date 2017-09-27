package filehandling;

import filehandling.impl.MavenConfigurationFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ReceiveFileController {
    private File targetFile;
    private FileConfigurationTypeEnum fileTypeEnum;

    private ConfigurationFile confgFile;

    @Value("${paths.target}")
    private String pathToTargetDir;

    @Value("${paths.maven}")
    private String mvnExeecPath;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("file") MultipartFile multipartFile, @RequestParam( value="fileType") int idFileType) {
        if (!multipartFile.isEmpty()) {
            try {
                targetFile = createEmptyFileInTargetDir(multipartFile.getOriginalFilename());
                String fullPath = pathToTargetDir + File.separator + multipartFile.getOriginalFilename();
                targetFile = new File(fullPath);
                multipartFile.transferTo(targetFile);
                fileTypeEnum = FileConfigurationTypeEnum.getInstanceById(idFileType);
                confgFile = new MavenConfigurationFile(targetFile, fileTypeEnum);
                confgFile.generateFileThirdPartDependeciesList();
                File test = new File("E:\\target\\lol");
                return "You successfully uploaded file";
            } catch (Exception e) {
                return "You failed to upload " + e.getMessage();
            }
        } else {
            return "You failed to upload "
                    + " because the file was empty.";
        }
    }
    @RequestMapping("/mvn")
    public String mvnTest(){
        String test = "";
        Process p = null;
        StringBuilder sb = new StringBuilder();

        try {
            p = Runtime.getRuntime().exec(mvnExeecPath + " license:add-third-party", null, new File(pathToTargetDir));
            p.waitFor();


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";

            while ((line = reader.readLine())!= null) {
                sb.append(line + "\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    private File createEmptyFileInTargetDir(String fileName) {
        String fullPath = pathToTargetDir + File.separator + fileName;
        File newFile = new File(fullPath);
        return newFile;
    }

}
