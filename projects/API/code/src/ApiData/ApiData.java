package code.src.ApiData;

import Interfaces.ILogger;
import converter.JSONToHashmap.JSONToHashmap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class ApiData implements ILogger {
    private JSONToHashmap hashmapOfObject = new JSONToHashmap();
    private JSONObject apiDataObject = new JSONObject();
    private JSONParser jsonDataParser = new JSONParser();

    public HashMap<String, Object> get(String apiDataLink) throws IOException, ParseException {
        URL apiUrl;
        HttpURLConnection apiConnection;
        String requestType = "GET";
        int apiResponseCode;
        Scanner scanner;
        String apiData = "";

        logger.trace("Getting API data from the end point...");
        logger.trace("Initializing the api url...");
        apiUrl = new URL(apiDataLink);
        logger.info("The specified url is : [ " + apiUrl + " ] ");

        logger.trace("Initiating the http url connection...");
        apiConnection = (HttpURLConnection) apiUrl.openConnection();
        logger.trace("Http url connection initiated.");

        logger.trace("Setting the request type...");
        apiConnection.setRequestMethod(requestType);
        logger.info("The request type is : [ " + requestType + " ] ");

        logger.trace("Connecting to the API...");
        apiConnection.connect();
        logger.trace("API connection established.");

        //Getting the response code
        logger.trace("Getting the response code...");
        apiResponseCode = apiConnection.getResponseCode();
        logger.info("The response code is : [ " + apiResponseCode + " ] ");

        if (apiResponseCode != 200) {
            throw new RuntimeException("APIResponseCode: " + apiResponseCode);
        }
        else
        {
            logger.trace("Initializing the scanner...");
            scanner = new Scanner(apiUrl.openStream());
            logger.trace("scanner initialized...");

            logger.trace("Writing all the JSON data into a string...");
            while (scanner.hasNext()) {
                apiData += scanner.nextLine();
            }
            logger.trace("All the JSON data is written into a string successfully.");

            logger.trace("Closing the scanner...");
            scanner.close();
            logger.trace("Scanner closed...");

            logger.trace("Parsing the string into a json object...");
            apiDataObject = (JSONObject) jsonDataParser.parse(apiData);
            logger.info("Json object obtained after parsing the string is : \n " + apiDataObject);

            /*logger.trace("Storing input data from API in form input hashmap...");
            httpInputHash.setMap(hashmapOfObject.convertJSONToHashmap(apiDataObject));
            logger.trace("Input data from API is stored in form input hashmap.");*/
        }
        return hashmapOfObject.convertJSONToHashmap(apiDataObject);
    }
}
