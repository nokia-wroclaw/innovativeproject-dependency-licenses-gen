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
        LicenseGenerator clg = new LicenseGenerator("Nokia", 2017, "ATV ADL");
        clg.generateLicenseMD();

        List<ThirdPartyComponent> list = new ArrayList<ThirdPartyComponent>();
        list.add(new ThirdPartyComponent("GNU GPL", "jackson-jaxrs", "1.8.3"));
        list.add(new ThirdPartyComponent("GPL v.2", "jaxb api", "2.2.2"));
        list.add(new ThirdPartyComponent("GPL v.2", "jaxb implementation", "2.2.3-1"));

        ComponentsCommonLicenses ccl = new ComponentsCommonLicenses("GNU General Public License", "GPL", list);
        ccl.createFile();
    }
}