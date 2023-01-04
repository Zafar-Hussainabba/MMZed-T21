import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Test_PropertiesDirectory {

    public static final Logger logger = LogManager.getLogger( Test_PropertiesDirectory.class );

    public static void main(String[] args)
    {
        PropertiesDirectory propertiesDirectory = new PropertiesDirectory();
        logger.info(propertiesDirectory.getDirBin());
    }
}