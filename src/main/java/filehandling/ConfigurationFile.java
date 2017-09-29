package filehandling;

import lombok.Getter;
import lombok.Setter;
import model.Configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Adam on 2017-09-19.
 */

public abstract class ConfigurationFile {
    protected File file;
    protected @Getter File generatedTxtFileLicenseNameList;
    protected @Getter File generatedZipLicensesFile;
    @Autowired
    protected ConfigProperties configProperties;

    protected ConfigProperties.Paths pathProperties;

    protected ConfigurationFile(File file, ConfigProperties.Paths pathProperties) {
        this.file = file;
        this.pathProperties = pathProperties;
    }
    public abstract void generateFileThirdPartDependeciesList();

    public abstract void generateZipLicenseFiles();

}
