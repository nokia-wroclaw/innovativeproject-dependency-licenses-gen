package filehandling.impl;

import filehandling.ConfigurationFile;
import filehandling.FileConfigurationTypeEnum;
import model.Configuration.ConfigProperties;

import java.io.File;

/**
 * Created by Adam on 2017-09-19.
 */
public class SBTConfigurationFile extends ConfigurationFile {
    public SBTConfigurationFile(File file, ConfigProperties.Paths pathProperties) {
        super(file, pathProperties);
    }

    @Override
    public void generateFileThirdPartDependeciesList() {

    }

    @Override
    public void generateZipLicenseFiles() {

    }
}
