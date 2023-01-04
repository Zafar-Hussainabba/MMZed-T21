
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSON_FileReader {

    private static String fileName;
    private static JSONObject jsonFormat;

    public JSON_FileReader(String fileName) { this.fileName = fileName; }

    public static String getFileName() {
        return fileName;
    }

    public static JSONObject getJsonFormat() {
        return jsonFormat;
    }

    public static void setFileName(String fileName) {
        JSON_FileReader.fileName = fileName;
    }

    public static void setJsonFormat(JSONObject jsonFormat) {
        JSON_FileReader.jsonFormat = jsonFormat;
    }

    public static JSONObject readJsonFile(String fileName) throws IOException, ParseException
    {
        setFileName(fileName);
        JSONParser parser = new JSONParser();
        Object parsedFile = parser.parse( new FileReader( getFileName() ) );
        JSONObject jsonObject = (JSONObject) parsedFile;
        setJsonFormat(jsonObject);
        return jsonFormat;
    }

    public static Boolean checkJsonFile(String fileName) throws IOException, ParseException {
        try
        {
            setFileName(fileName);
            JSONParser parser = new JSONParser();
            Object parsedFile = parser.parse( new FileReader( getFileName() ) );
            JSONObject jsonObject = (JSONObject) parsedFile;
        }
        catch (ParseException ex)
        {
            try {
                setFileName(fileName);
                JSONParser parser = new JSONParser();
                Object parsedFile = parser.parse( new FileReader( getFileName() ) );;
                JSONArray jsonObject = (JSONArray) parsedFile;
            } catch (ParseException ex1) {
                return false;
            }
        }
        return true;
    }

    public static void resetData() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter( getFileName() );
        writer.print("");
        writer.close();
    }

    public static final Logger logger = LogManager.getLogger( JSON_FileReader.class );
}
