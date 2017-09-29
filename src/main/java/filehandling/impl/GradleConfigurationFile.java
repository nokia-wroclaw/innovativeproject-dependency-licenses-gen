package filehandling.impl;

import filehandling.ConfigurationFile;
import filehandling.FileConfigurationTypeEnum;
import model.Configuration.ConfigProperties;

import java.io.File;

/**
 * Created by Adam on 2017-09-19.
 */
public class GradleConfigurationFile extends ConfigurationFile{
    public GradleConfigurationFile(File file, ConfigProperties.Paths pathProperties) {
        super(file, pathProperties);
    }

    @Override
    public void generateFileThirdPartDependeciesList() {

    }

    @Override
    public void generateZipLicenseFiles() {

    }
}
