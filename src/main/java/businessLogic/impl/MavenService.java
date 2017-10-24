package businessLogic.impl;

import businessLogic.ConfigurationFileService;
import model.Configuration.ConfigProperties;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MavenService implements ConfigurationFileService {

    @Autowired
    private ConfigProperties properties;

    private static final String pathToOutputLicensesDir = "target" + File.separator + "generated-resources" + File.separator + "licenses";
    private static final String pathToOutputLicensesTxtFile = File.separator + "target" + File.separator + "generated-sources" +
            File.separator + "license" + File.separator + "THIRD-PARTY.txt";


    private static final String mavenCommandGeneratingLicenseList = "license:add-third-party ";
    private static final String mavenCommandGeneretingLicenseFiles = "license:download-licenses "+
            "-DlicensesOutputDirectory=\"output\" " + "-DlicensesOutputFile=\"output" + File.separator + "licenses.xml\"";

    @Override
    public File generateFiles(File file) {
        String mavenExePath = properties.getPaths().getMaven();
        String pathToTargetDir = properties.getPaths().getTargetDir();
        generateFileThirdPartDependeciesList(pathToTargetDir,mavenExePath);
        generateZipLicenseFiles(pathToTargetDir, mavenExePath);
        return null;
    }

    @Override
    public String getJSON() {
        String pathToLicenseListXml = properties.getPaths().getTargetDir() + File.separator + "output" + File.separator + "licenses.xml";
        String xmlString = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToLicenseListXml));
            xmlString = String.join("\n", lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = XML.toJSONObject(xmlString).toString();
        return json;
    }

    public void generateFileThirdPartDependeciesList(String pathToTargetDir, String mavenExePath) {
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

    public void generateZipLicenseFiles(String pathToTargetDir, String mavenExePath) {
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
