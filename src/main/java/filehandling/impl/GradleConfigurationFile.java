package filehandling.impl;

import filehandling.ConfigurationFile;
import filehandling.FileConfigurationTypeEnum;

import java.io.File;

/**
 * Created by Adam on 2017-09-19.
 */
public class GradleConfigurationFile extends ConfigurationFile{
    public GradleConfigurationFile(File file, FileConfigurationTypeEnum fileTypeEnum) {
        super(file, fileTypeEnum);
    }

    @Override
    public void generateFileContainingThirdPartDependeciesList() {

    }
}
