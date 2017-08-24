package licenseReciver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseController {
	
	@RequestMapping("/license")
	public String requestLicense(
			@RequestParam(value = "owner", defaultValue = "nokia-wroclaw") String owner,
			@RequestParam(value = "repos", defaultValue = "innovativeprojects") String repos){
		License license =  new License(owner, repos);
		return license.getLicenseObj().getUrl();
	}
	
}
