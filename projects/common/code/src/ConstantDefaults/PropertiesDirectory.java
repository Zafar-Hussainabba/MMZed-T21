import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.HashMap;

public class PropertiesDirectory {

    private static String DIR_SEPERATOR = "/";
    private static String DIR_PROJECT   = "default-project";
    private static String DIR_BIN       = "bin";
    private static String DIR_CONF      = "conf";
    private static String DIR_DATA      = "data";
    private static String DIR_LOGS      = "logs";
    private static String DIR_RUNTIME   = "runtime";
    private static String DIR_SCRIPTS   = "scripts";
    private static String DIR_TEST      = "test";
    private static HashMap<String, String> DIR_MAP = new HashMap<>();

    public PropertiesDirectory ()
    {
        DIR_MAP.put("DIR_PROJECT", this.DIR_PROJECT);
        DIR_MAP.put("DIR_BIN", this.DIR_BIN);
        DIR_MAP.put("DIR_CONF", this.DIR_CONF);
        DIR_MAP.put("DIR_DATA", this.DIR_DATA);
        DIR_MAP.put("DIR_LOGS", this.DIR_LOGS);
        DIR_MAP.put("DIR_RUNTIME", this.DIR_RUNTIME);
        DIR_MAP.put("DIR_SCRIPTS", this.DIR_SCRIPTS);
        DIR_MAP.put("DIR_TEST", this.DIR_TEST);
    }


    public PropertiesDirectory(String I_DIR_PROJECT )
    {
        this.DIR_PROJECT   = I_DIR_PROJECT;
    }

    public static void setDirProject(String dirProject) {
        DIR_PROJECT = dirProject;
    }

    public static void setDirBin(String dirBin) {
        DIR_BIN = dirBin;
    }

    public static void setDirConf(String dirConf) {
        DIR_CONF = dirConf;
    }

    public static void setDirData(String dirData) {
        DIR_DATA = dirData;
    }

    public static void setDirLogs(String dirLogs) {
        DIR_LOGS = dirLogs;
    }

    public static void setDirRuntime(String dirRuntime) {
        DIR_RUNTIME = dirRuntime;
    }

    public static void setDirScripts(String dirScripts) {
        DIR_SCRIPTS = dirScripts;
    }

    public static void setDirTest(String dirTest) {
        DIR_TEST = dirTest;
    }

    public static String getDirProject() {
        return DIR_PROJECT;
    }

    public static String getDirBin() {
        return DIR_BIN;
    }

    public static String getDirConf() {
        return DIR_CONF;
    }

    public static String getDirData() {
        return DIR_DATA;
    }

    public static String getDirLogs() {
        return DIR_LOGS;
    }

    public static String getDirRuntime() {
        return DIR_RUNTIME;
    }

    public static String getDirScripts() {
        return DIR_SCRIPTS;
    }

    public static String getDirTest() {
        return DIR_TEST;
    }
}