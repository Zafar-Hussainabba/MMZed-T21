package MMZed_Errors;

import Interfaces.ILogger;
import JSONFileReader.JSONFileReader;
import com.google.gson.stream.JsonReader;
import converter.JSONToHashmap.JSONToHashmap;
import methods.ReusableMethods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Test_MMZed_ErrorEngine {
    public static final Logger logger = LogManager.getLogger( Test_MMZed_ErrorEngine.class );

    public static void main(String[] args) throws IOException, ParseException {

        PropertyConfigurator.configure("projects/ErrorEngine/conf/log4j/log4j_ErrorEngine.properties");
        MMZed_ErrorEngine errorEngine = new MMZed_ErrorEngine();
        HashMap<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap = errorEngine.getErrorMessageMap("firstName_EC_NE");
        ReusableMethods.printHashmapData(errorMessageMap);
        //errorTypes.add("system");
        //errorTypes.add("user");
        //String errorMessage = errorEngine.getDefaultErrorMessage();
        /*MMZed_ErrorEngine errorEngine = new MMZed_ErrorEngine();
        HashMap<String, String> getMap = new HashMap<>();
        HashMap<String, Object> keySetMap = new HashMap<>();
        HashMap<String, Object> updateMap = new HashMap<>();
        HashMap<String, String> testKeySetMap = new HashMap<>();
        JSONObject validationErrorJson = new JSONObject();
        JSONToHashmap convertJsonToHashmap = new JSONToHashmap();
        HashMap<String, Object> validationErrorMap = new HashMap<>();

        ReusableMethods.configureLog4j("projects/ErrorEngine/conf/log4j", "log4j_ErrorEngine.properties");

        validationErrorJson = JSONFileReader.readJsonFile("projects/ErrorEngine/data/json/SK_MMZed_COMMON_FORM_VALIDATION_error.json");
        validationErrorMap = convertJsonToHashmap.convertJSONToHashmap(validationErrorJson);

        errorEngine.setMap(validationErrorMap);
        errorEngine.getMap();*/

        /*errorEngine.setSingleKey("error_code_1", "key not found!!!");
        logger.info(errorEngine.isSingleKeyExist("error_code_1"));
        logger.info(errorEngine.getSingleKey("error_code_11"));
        errorEngine.setSingleKey("error_code_1", "key not found!!!");


        getMap.put("error_code_1", "");
        getMap.put("error_code_11", "");
        getMap.put("error_code_12", "");
        getMap.put("error_code_13", "");
        getMap.put("error_code_14", "");
        getMap.put("error_code_15", "");
        errorEngine.getMultipleKey(getMap);


        keySetMap.put("error_code_1", "error code 1");
        keySetMap.put("error_code_11", "error code 11");
        keySetMap.put("error_code_12", "error code 12");
        keySetMap.put("error_code_13", "error code 13");
        keySetMap.put("error_code_14", "error code 14");
        keySetMap.put("error_code_15", "error code 15");
        errorEngine.setMultipleKey(keySetMap);
        errorEngine.getMultipleKey(getMap);



        updateMap.put("error_code_0", "");
        updateMap.put("error_code_1", "");
        updateMap.put("error_code_11", "error code 111");
        updateMap.put("error_code_12", "error code 122");
        updateMap.put("error_code_13", "error code 133");
        updateMap.put("error_code_14", "error code 144");
        updateMap.put("error_code_15", "error code 155");
        errorEngine.updateMultipleKey(updateMap);
        errorEngine.getMultipleKey(getMap);


        testKeySetMap.put("error_code_1", "");
        testKeySetMap.put("error_code_11", "");
        testKeySetMap.put("error_code_12", "");
        testKeySetMap.put("error_code_13", "");
        testKeySetMap.put("error_code_14", "");
        testKeySetMap.put("error_code_15", "");
        errorEngine.deleteMultipleKey(testKeySetMap);
        errorEngine.getMultipleKey(getMap);*/
    }
}
