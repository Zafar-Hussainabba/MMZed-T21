package code.src.Form.FormDefinition.FormDefinitionF1;

import Hashmap.CommonHashmap;
import JSONFileReader.JSONFileReader;
import converter.JSONToHashmap.JSONToHashmap;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class FormDefinitionF1 extends CommonHashmap {
    private JSONToHashmap convertJsonToHashmap = new JSONToHashmap();
    private String formDefinitionData = "projects/API/data/json/SK_MMZed_FormF1_Definition.json";

    public FormDefinitionF1() throws IOException, ParseException {
        super.hashmapName = "FormDefinitionF1";
        logger.trace("Loading the definition for form F1...");
        setMap(convertJsonToHashmap.convertJSONToHashmap(JSONFileReader.readJsonFile(formDefinitionData)));
        logger.trace("Definition for form F1 loaded successfully.");
    }
}
