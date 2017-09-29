package filehandling.impl;

import filehandling.ConfigurationFile;
import model.Configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by Adam on 2017-09-19.
 */
public class MavenConfigurationFile extends ConfigurationFile {

    private String mavenExePath;

    private String pathToTargetDir;


    private static final String pathToOutputLicensesDir = "target" + File.separator + "generated-resources" + File.separator + "licenses";
    private static final String pathToOutputLicensesTxtFile = "target" + File.separator + "generated-sources" +
            File.separator + "license" + File.separator + "THIRD-PARTY.txt";


    private static final String mavenCommandGeneratingLicenseList = "license:add-third-party";
    private static final String mavenCommandGeneretingLicenseFiles = "license:download-licenses";

    public MavenConfigurationFile(File file, ConfigProperties.Paths pathProperties) {
        super(file, pathProperties);
        mavenExePath = pathProperties.getMaven();
        pathToTargetDir = pathProperties.getTargetDir();
    }

    @Override
    public void generateFileThirdPartDependeciesList() {
        String log = "";
        Process p = null;
        File dir = new File(pathToTargetDir);
        String fullCommand = mavenExePath + " " + mavenCommandGeneratingLicenseList;

        try {
            p = this.executeCommand(fullCommand, null, dir);
            log = this.getLogFromProcess(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(log);
        generatedTxtFileLicenseNameList = new File(pathToOutputLicensesTxtFile);
    }

    @Override
    public void generateZipLicenseFiles() {
        String log = "";
        Process p = null;
        File dir = new File(pathToTargetDir);
        String fullCommand = mavenExePath + " " + mavenCommandGeneretingLicenseFiles;
        try {
            p = this.executeCommand(fullCommand, null, dir);
            log = this.getLogFromProcess(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(log);

    }

    private String getLogFromProcess(Process p) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        return sb.toString();
    }

    private Process executeCommand(String command, String[] envp, File dir) throws IOException, InterruptedException {
        Process p = null;
        p = Runtime.getRuntime().exec(command, null, dir);
        p.waitFor();
        return p;
    }
}
