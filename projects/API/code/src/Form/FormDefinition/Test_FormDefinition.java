package code.src.Form.FormDefinition;

import JSONFileReader.JSONFileReader;
import converter.JSONToHashmap.JSONToHashmap;
import methods.ReusableMethods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class Test_FormDefinition {
    private static final Logger logger = LogManager.getLogger( Test_FormDefinition.class );

    public static void main(String[] args) throws IOException, ParseException {
        FormDefinition formDefinition = new FormDefinition();
        JSONToHashmap convertJsonToHashmap = new JSONToHashmap();
        String formDefinitionJsonFileName = "projects/API/data/json/SK_MMZed_COMMON_VALIDATION.json";
        HashMap<String, Object> formDefinitionMap = new HashMap<>();

        ReusableMethods.configureLog4j("projects/API/conf/log4j","log4j_API.properties");

        formDefinitionMap = convertJsonToHashmap.convertJSONToHashmap(JSONFileReader.readJsonFile(formDefinitionJsonFileName));
        formDefinition.setMap(formDefinitionMap);
        formDefinition.getMap();
    }
}
