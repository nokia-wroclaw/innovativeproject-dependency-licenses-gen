package filehandling;

import java.io.File;

/**
 * Created by Adam on 2017-09-19.
 */
public abstract class ConfigurationFile {
    protected final File file;
    protected final FileConfigurationTypeEnum fileTypeEnum;

    protected ConfigurationFile(File file, FileConfigurationTypeEnum fileTypeEnum) {
        this.file = file;
        this.fileTypeEnum = fileTypeEnum;
    }
    public abstract void generateFileContainingThirdPartDependeciesList();
}
