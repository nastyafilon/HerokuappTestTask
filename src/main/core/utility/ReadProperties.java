package core.utility;

import core.utility.constants.ProjectDirPaths;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    /**
     * Read property {@param propertyName} from file {@param fileName}
     */
    public static String readProperty(String fileName, String propertyName) {
        String propertyValue = null;
        try (InputStream input = new FileInputStream(ProjectDirPaths.PATH_TO_RESOURCE_DIR + fileName)) {
            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyName);
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        return propertyValue;
    }
}
