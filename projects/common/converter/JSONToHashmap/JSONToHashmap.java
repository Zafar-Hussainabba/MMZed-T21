package converter.JSONToHashmap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class JSONToHashmap {
    private static final Logger logger = LogManager.getLogger( JSONToHashmap.class );
    private static HashMap<String, Object> resultHashmap = new HashMap<>();


    public static void setResultHashmapKeyValue(String key, Object values)
    {
        resultHashmap.put(key, values);
    }

    public HashMap<String, Object> convertJSONToHashmap(JSONObject jsonToConvert)
    {
        for( Object key : jsonToConvert.keySet())
        {
                setResultHashmapKeyValue(key.toString(), jsonToConvert.get(key));
        }

        return resultHashmap;
    }
}
