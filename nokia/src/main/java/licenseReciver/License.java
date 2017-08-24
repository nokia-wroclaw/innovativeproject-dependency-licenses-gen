package licenseReciver;

import org.springframework.web.client.RestTemplate;
import lombok.Getter;

@lombok.Getter
public class License {
	private String licenseName;
	private final String owner;
	private final String repoName;
	private final String prefixUrlApIGitHubLicense = "https://api.github.com/repos";
	private final String suffixUrlApiGitHubLicense = "license";
	@Getter private final LicenseJson licenseObj;
	
	
	public License(String owner, String repoName){
		this.owner = owner;
		this.repoName = repoName;
		
		RestTemplate restTemplate = new RestTemplate();
		licenseObj = restTemplate.getForObject(prepareUrl(owner, repoName), LicenseJson.class);			
	}
	
	private String prepareUrl(String owner, String repoName) {
		return prefixUrlApIGitHubLicense + "/" + owner + "/" + repoName + "/" + suffixUrlApiGitHubLicense;
	}
	public LicenseJson getLicenseObj(){
		return licenseObj;
	}
}
