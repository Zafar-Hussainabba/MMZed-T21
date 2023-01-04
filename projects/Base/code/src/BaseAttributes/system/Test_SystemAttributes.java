package code.src.BaseAttributes.system;

import code.src.BaseAttributes.exceptions.KeyNotFoundException;
import org.apache.log4j.BasicConfigurator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test_SystemAttributes {

    public static final Logger logger = LogManager.getLogger(Test_SystemAttributes.class);
    public static void main(String args[]) throws KeyNotFoundException {
        String log4jPropertiesFile = "../../../conf/log4j/log4j_BaseAttributes.properties";
        PropertyConfigurator.configure(log4jPropertiesFile);
        //BasicConfigurator.configure();
        SystemAttributes obj = new SystemAttributes();
        //String keys = obj.getKeyValue("__STATE");
        //logger.info(" value of  State is : " + keys );
        //System.out.println(" value of  State is : " + keys );
    }
}
