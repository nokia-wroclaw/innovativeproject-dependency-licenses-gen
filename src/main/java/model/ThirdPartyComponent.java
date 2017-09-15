package model;

public class ThirdPartyComponent {
    private String upperLicense;
    private String name;
    private String version;

    public ThirdPartyComponent(String upperLicense, String name, String version) {
        this.name = name;
        this.upperLicense = upperLicense;
        this.version = version;
    }

    public String getUpperLicense() {
        return upperLicense;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}