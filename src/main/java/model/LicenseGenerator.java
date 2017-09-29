package model;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;

public class LicenseGenerator {
    private String company;
    private int year;
    private String clientProjecName;
    private List<ComponentsCommonLicenses> ListComponentsCommonLicenses;

    public LicenseGenerator(String company, int year, String componentName, List<ComponentsCommonLicenses> ListComponentsCommonLicenses) {
        this.company = company;
        this.year = year;
        this.clientProjecName = componentName;
        this.ListComponentsCommonLicenses = ListComponentsCommonLicenses;
    }

    public void generateLicenseMD() throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter("LICENSE.md"));
        BufferedReader fin = new BufferedReader(new FileReader(new ClassPathResource("LICENSE_temp.md").getFile()));
        String line;

        while ((line = fin.readLine()) != null) {
            line = line.replaceAll("<year>", Integer.toString(year));
            line = line.replaceAll("<company>", company);
            line = line.replaceAll("<component_name>", clientProjecName);

            fout.write(line + "\n");
        }

        fin.close();
        fout.close();
    }

    public void generateThirdPartyLicense() throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter("LICENSE-3RD-PARTY.txt"));
        BufferedReader fin = new BufferedReader(new FileReader(new ClassPathResource("LICENSE-3RD-PARTY-INIT_temp.txt").getFile()));
        String line;

        while ((line = fin.readLine()) != null) {
            line = line.replaceAll("<component>", clientProjecName);

            fout.write(line + "\n");
        }

        fout.write("\n");
        fin.close();

        for (ComponentsCommonLicenses component : ListComponentsCommonLicenses) {
            fin = component.openFile();

            while ((line = fin.readLine()) != null) {
                fout.write(line + "\n");
            }
            fout.write("\n");
            fin.close();
        }
        fout.close();

    }
}