package filehandling;

import java.io.File;

/**
 * Created by Adam on 2017-09-19.
 */
public abstract class ConfigurationFile {
    protected final File file;
    protected final FileConfigurationTypeEnum fileTypeEnum;
    protected File generatedTxtFileLicenseNameList;
    protected File generatedZipLicensesFile;


    protected ConfigurationFile(File file, FileConfigurationTypeEnum fileTypeEnum) {
        this.file = file;
        this.fileTypeEnum = fileTypeEnum;
    }
    public abstract void generateFileThirdPartDependeciesList();

    public abstract void generateZipLicenseFiles();

    public File getGeneratedTxtFileLicenseNameList() {
        return generatedTxtFileLicenseNameList;
    }
    public File getGeneratedZipLicensesFile() {
        return generatedZipLicensesFile;
    }
}
