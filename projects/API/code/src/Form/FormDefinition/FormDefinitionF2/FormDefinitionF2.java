package code.src.Form.FormDefinition.FormDefinitionF2;

import Hashmap.CommonHashmap;
import JSONFileReader.JSONFileReader;
import converter.JSONToHashmap.JSONToHashmap;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class FormDefinitionF2 extends CommonHashmap {
    private JSONToHashmap convertJsonToHashmap = new JSONToHashmap();
    private String formDefinitionData = "projects/API/data/json/SK_MMZed_FormF2_Definition.json";

    public FormDefinitionF2() throws IOException, ParseException {
        setMap(convertJsonToHashmap.convertJSONToHashmap(JSONFileReader.readJsonFile(formDefinitionData)));
    }
}
