package code.src.Form.FormF1;


import methods.ReusableMethods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Test_FormF1 {
    private static final Logger logger = LogManager.getLogger( Test_FormF1.class );

    public static void main(String[] args) throws IOException, ParseException {
        ReusableMethods.configureLog4j("projects/API/conf/log4j", "log4j_API.properties");

        FormF1 formF1 = new FormF1("http://localhost:8080/F1");

        formF1.init();
        formF1.pre_process();

    }


}
