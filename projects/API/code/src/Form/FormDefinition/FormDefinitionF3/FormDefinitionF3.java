package code.src.Form.FormDefinition.FormDefinitionF3;

import Hashmap.CommonHashmap;
import JSONFileReader.JSONFileReader;
import converter.JSONToHashmap.JSONToHashmap;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class FormDefinitionF3 extends CommonHashmap {
    private JSONToHashmap convertJsonToHashmap = new JSONToHashmap();
    private String formDefinitionData = "projects/API/data/json/SK_MMZed_FormF3_Definition.json";

    public FormDefinitionF3() throws IOException, ParseException {
        setMap(convertJsonToHashmap.convertJSONToHashmap(JSONFileReader.readJsonFile(formDefinitionData)));
    }
}
