package model;

import org.springframework.core.io.ClassPathResource;

import java.io.*;

public class LicenseGenerator {
    private String company;
    private int year;
    private String componentName;

    public LicenseGenerator(String company, int year, String componentName) {
        this.company = company;
        this.year = year;
        this.componentName = componentName;
    }

    public void generateLicenseMD() throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter("LICENSE.md"));
        BufferedReader fin = new BufferedReader(new FileReader(new ClassPathResource("LICENSE_temp.md").getFile()));
        String line;

        while ((line = fin.readLine()) != null) {
            line = line.replaceAll("<year>", Integer.toString(year));
            line = line.replaceAll("<company>", company);
            line = line.replaceAll("<component_name>", componentName);


            fout.write(line + "\n");
        }

        fin.close();
        fout.close();
    }
}
