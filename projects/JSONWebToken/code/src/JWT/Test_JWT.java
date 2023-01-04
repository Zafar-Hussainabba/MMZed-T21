package code.src.JWT;

import methods.ReusableMethods;
import org.apache.log4j.LogManager;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Test_JWT {
    public static final org.apache.log4j.Logger logger = LogManager.getLogger( JWT.class );

    public static void main(String[] args) throws ParseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InterruptedException {
        ReusableMethods.configureLog4j("projects/JSONWebToken/conf/log4j","log4j_JWT.properties");
        JWT jwt = new JWT();
        TimeUnit.SECONDS.sleep(8);
        JWT jwt2 = new JWT(JWT.getJSONWebToken());
    }
}
