package model;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);

        List<ThirdPartyComponent> list1 = new ArrayList<>();
        list1.add(new ThirdPartyComponent("GNU GPL", "jackson-jaxrs", "1.8.3"));
        list1.add(new ThirdPartyComponent("GPL v.2", "jaxb api", "2.2.2"));
        list1.add(new ThirdPartyComponent("GPL v.2", "jaxb implementation", "2.2.3-1"));

        ComponentsCommonLicenses ccl1 = new ComponentsCommonLicenses("GNU General Public License", "GPL", list1);
        ccl1.createFile();

        List<ThirdPartyComponent> list2 = new ArrayList<>();
        list2.add(new ThirdPartyComponent("Apache", "Apache Avro", "1.7.4"));
        list2.add(new ThirdPartyComponent("Apache", "Apache Commons Codec", "2.2.2"));
        list2.add(new ThirdPartyComponent("Apache", "Apache Commons Compress", "1.4.1"));

        ComponentsCommonLicenses ccl2 = new ComponentsCommonLicenses("Apache", list2);
        ccl2.createFile();

        List<ComponentsCommonLicenses> ListComponentsCommonLicenses = new ArrayList<>();
        ListComponentsCommonLicenses.add(ccl1);
        ListComponentsCommonLicenses.add(ccl2);

        LicenseGenerator clg = new LicenseGenerator("Nokia", 2017, "ATV ADL", ListComponentsCommonLicenses);
        clg.generateLicenseMD();
        clg.generateThirdPartyLicense();
    }
}