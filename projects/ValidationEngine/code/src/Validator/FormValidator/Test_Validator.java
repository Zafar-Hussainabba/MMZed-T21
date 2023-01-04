package FormValidator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Test_Validator {
    public static final Logger logger = LogManager.getLogger( Test_Validator.class );

    public static JSONObject getApiData(String apiURL) throws IOException, ParseException {

        //Taking data from API
        JSONObject apiDataObject = new JSONObject();
        URL apiDataURL = new URL(apiURL);

        HttpURLConnection apiConnection = (HttpURLConnection) apiDataURL.openConnection();
        apiConnection.setRequestMethod("GET");
        apiConnection.connect();

        //Getting the response code
        int apiResponseCode = apiConnection.getResponseCode();
        if (apiResponseCode != 200) {
            throw new RuntimeException("APIResponseCode: " + apiResponseCode);
        }
        else
        {

            String apiData = "";
            Scanner scanner = new Scanner(apiDataURL.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                apiData += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();

            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            apiDataObject = (JSONObject) parse.parse(apiData);

            logger.info(apiDataObject);
        }

        return apiDataObject;
    }

    public static void main(String[] args) throws IOException, ParseException {

        JSONObject formInputData = new JSONObject();
        JSONObject commonValidationData = new JSONObject();

        formInputData = getApiData("http://localhost:8080/FormInput");
        commonValidationData = getApiData("http://localhost:8080/Validation");

        //FormValidator.Validator validate = new FormValidator.Validator(formInputData, commonValidationData);

        //  Check whether the mandatory fields are present
        /*JSONArray formFieldList = new JSONArray();
        JSONArray mandatoryFormFieldList = new JSONArray();

        formFieldList = (JSONArray)formInputData.get("__FORM__::F1::__FIELD_LIST__");
        mandatoryFormFieldList = (JSONArray)commonValidationData.get("VALIDATION::__COMMON__::__FORM__::F1::__FIELD_LIST__::__MANDATORY__");


        for( Object formField : mandatoryFormFieldList)
        {
            if(!formFieldList.contains(formField))
            {
                System.out.println(formField + " is not present ");
            }
        }*/

    }

}
