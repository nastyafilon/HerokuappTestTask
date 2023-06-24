package core.utility.constants;

import java.io.File;

public class ProjectDirPaths {
    /**
     * Here are paths to resources
     */
    public static final String PATH_TO_RESOURCE_DIR = System.getProperty("user.dir") + File.separator
            + "src" + File.separator + "resources" + File.separator;
    public static final String PATH_TO_TEST_RESOURCE_DIR = System.getProperty("user.dir") + File.separator
            + "src" + File.separator + "testResources" + File.separator;

}
