package code.src.Form.FormDefinition;

import Hashmap.CommonHashmap;
import converter.JSONToHashmap.JSONToHashmap;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class FormDefinition extends CommonHashmap {
    private JSONToHashmap convertJsonToHashmap = new JSONToHashmap();

    public FormDefinition() throws IOException, ParseException {
    }
    //private String formDefinitionJsonFileName = "projects/API/data/json/SK_MMZed_COMMON_VALIDATION.json";

    // TODO - Take json data file in the constructor and store it in the hash
    /*public FormDefinition() {
        //setFormDefinitionJsonFileName(formDefinitionJsonFileName);
        //setMap(convertJsonToHashmap.convertJSONToHashmap(JSONFileReader.readJsonFile(formDefinitionJsonFileName)));
    }*/
}
