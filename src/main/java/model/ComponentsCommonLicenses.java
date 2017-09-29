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
    private String licenseAbbreviation;
    private List<ThirdPartyComponent>  thirdPartyComponents;



    public ComponentsCommonLicenses(String commonLicense, String licenseAbbreviation, List<ThirdPartyComponent> thirdPartyComponents) {

        this.commonLicense = commonLicense;
        this.licenseAbbreviation = licenseAbbreviation;
        this.thirdPartyComponents = thirdPartyComponents;
    }

    public ComponentsCommonLicenses(String commonLicense, List<ThirdPartyComponent> thirdPartyComponents) {
        this(commonLicense, null,thirdPartyComponents);
    }

    private String parseToFileName() {
        return commonLicense.replaceAll(" ", "_") + ".txt";
    }

    public void createFile() throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter(parseToFileName()));
        BufferedReader fin = new BufferedReader(new FileReader(new ClassPathResource("LICENSE-3RD-PARTY_temp.txt").getFile()));
        String line;

        while ((line = fin.readLine()) != null) {
            if (licenseAbbreviation == null) {
                line = line.replaceAll("<name>", commonLicense);
            } else {
                line = line.replaceAll("<name>", commonLicense + " (" + licenseAbbreviation + ")");
            }
            fout.write(line + "\n");
        }
        for (ThirdPartyComponent component : thirdPartyComponents) {
            fout.write("    (" + component.getUpperLicense() + ") " +  component.getName() + " " + component.getVersion() + "\n");
        }

        fin.close();
        fout.close();
    }

    public BufferedReader openFile() throws IOException {
        return new BufferedReader(new FileReader(parseToFileName()));
    }
}