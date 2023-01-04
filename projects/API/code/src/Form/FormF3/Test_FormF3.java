package code.src.Form.FormF3;

import code.src.Form.FormF1.FormF1;
import code.src.Form.FormF1.Test_FormF1;
import methods.ReusableMethods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Test_FormF3 {
    private static final Logger logger = LogManager.getLogger( Test_FormF3.class );

    public static void main(String[] args) throws IOException, ParseException {
        ReusableMethods.configureLog4j("projects/API/conf/log4j", "log4j_API.properties");

        FormF3 formF3 = new FormF3("http://localhost:8080/F3");

        formF3.init();
        formF3.pre_process();

    }
}
