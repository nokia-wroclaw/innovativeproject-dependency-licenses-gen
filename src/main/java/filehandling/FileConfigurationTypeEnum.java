package filehandling;

/**
 * Created by Adam on 2017-09-19.
 */
public enum FileConfigurationTypeEnum {
    MAVEN(1), GRADLE(2), SBT(3);

    FileConfigurationTypeEnum(int idFileConfigurationType) {
        this.idFileConfigurationType = idFileConfigurationType;
    }

    public int getIdFileConfigurationType() {
        return idFileConfigurationType;
    }

    public void setIdFileConfigurationType(int idFileConfigurationType) {
        this.idFileConfigurationType = idFileConfigurationType;
    }

    private int idFileConfigurationType;

    public static FileConfigurationTypeEnum getInstanceById(int id) {
        for(FileConfigurationTypeEnum instance : FileConfigurationTypeEnum.values()) {
            if(instance.getIdFileConfigurationType() == id)
                return instance;
        }
        return null;
    }
 
}
