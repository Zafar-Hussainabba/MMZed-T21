import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Test_JSON_FileReader {
    public static final Logger logger = LogManager.getLogger( Test_JSON_FileReader.class );

    public static void main(String[] args) throws IOException, ParseException
    {
        String log4jPropertiesFileDir = "../../../conf/log4j/";
        String log4jPropertiesFileName = "log4j/log4j_JSONReader.properties";
        PropertyConfigurator.configure(log4jPropertiesFileDir+log4jPropertiesFileName);
        Boolean isValid = JSON_FileReader.checkJsonFile(args[0]);
        if(isValid)
        {
            logger.info("File is a valid json");
        }
        else
        {
            logger.info("File is not a valid json");
        }
    }
}
