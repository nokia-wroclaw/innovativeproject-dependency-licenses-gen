package model;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ComponentsCommonLicenses {
    private String commonLicense;
    private String licenseAbreviation;
    private List<ThirdPartyComponent>  thirPartyComponents;

    public ComponentsCommonLicenses(String commonLicense, String licenseAbreviation, List<ThirdPartyComponent> thirdPartyComponents) {
        this.commonLicense = commonLicense;
        this.licenseAbreviation = licenseAbreviation;
        this.thirPartyComponents = thirdPartyComponents;
    }

    public ComponentsCommonLicenses(String commonLicense, List<ThirdPartyComponent> thirdPartyComponents) {
        this.commonLicense = commonLicense;
        this.thirPartyComponents = thirdPartyComponents;
        this.licenseAbreviation = null;
    }

    public void createFile() throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter(commonLicense.replaceAll(" ", "_") + ".txt"));
        BufferedReader fin = new BufferedReader(new FileReader(new ClassPathResource("LICENSE-3RD-PARTY_temp.txt").getFile()));
        String line;

        while ((line = fin.readLine()) != null) {
            if (licenseAbreviation == null) {
                line = line.replaceAll("<name>", commonLicense);
            } else {
                line = line.replaceAll("<name>", commonLicense + " (" + licenseAbreviation + ")");
            }
            fout.write(line + "\n");
        }
        for (ThirdPartyComponent component : thirPartyComponents) {
            fout.write("    (" + component.getUpperLicense() + ") " +  component.getName() + " " + component.getVersion() + "\n");
        }

        fin.close();
        fout.close();
    }
}
