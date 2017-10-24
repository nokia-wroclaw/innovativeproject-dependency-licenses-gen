package businessLogic;

import org.springframework.stereotype.Service;

import java.io.File;

public interface ConfigurationFileService {
    File generateFiles(File file);
    String getJSON();
}
