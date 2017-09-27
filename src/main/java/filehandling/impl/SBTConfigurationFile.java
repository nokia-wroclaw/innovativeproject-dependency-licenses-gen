package filehandling.impl;

import filehandling.ConfigurationFile;
import filehandling.FileConfigurationTypeEnum;

import java.io.File;

/**
 * Created by Adam on 2017-09-19.
 */
public class SBTConfigurationFile extends ConfigurationFile {
    public SBTConfigurationFile(File file, FileConfigurationTypeEnum fileTypeEnum) {
        super(file, fileTypeEnum);
    }

    @Override
    public void generateFileThirdPartDependeciesList() {

    }

    @Override
    public void generateZipLicenseFiles() {

    }
}
