import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Test_Common_Error {

    public static final Logger logger = LogManager.getLogger( Test_Common_Error.class );

    public static void main(String[] args)
    {
        String commonErrorMessagesFile = "/home/zafar/projects/ErrorEngine/data/common_error.json";
        //JSON_FileReader.setFileName(commonErrorMessagesFile);
        //logger.info(JSON_FileReader.getFileName());
    }

}