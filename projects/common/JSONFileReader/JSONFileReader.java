package JSONFileReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class JSONFileReader {
    public static final Logger logger = LogManager.getLogger( JSONFileReader.class );
    private static String fileName;
    private static JSONObject jsonFormat;

    //public void JSON_FileReader(String fileName) { this.fileName = fileName; }

    public static String getFileName() {
        return fileName;
    }

    public static JSONObject getJsonFormat() {
        return jsonFormat;
    }

    public static void setFileName(String fileName) {
        JSONFileReader.fileName = fileName;
    }

    public static void setJsonFormat(JSONObject jsonFormat) {
        JSONFileReader.jsonFormat = jsonFormat;
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
}
