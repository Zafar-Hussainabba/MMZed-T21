package AttributeControllers;

import Hashmap.interfaces.ICommonHashmap;
import Interfaces.ILogger;
import JSONFileReader.JSONFileReader;
import converter.JSONToHashmap.JSONToHashmap;
import methods.ReusableMethods;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class SystemErrors implements ICommonHashmap, ILogger {
    private static HashMap<String, Object> systemErrorsMap = new HashMap<>();
    private static HashMap<String, Object> getResultMap = new HashMap<>();
    private static HashMap<String, Boolean> isMultipleKeyExistResultMap = new HashMap<>();
    private JSONToHashmap convertJsonToHashmap = new JSONToHashmap();
    private String systemErrorJsonFile = "projects/common/data/json/systemError.json";

    public String getSystemErrorJsonFile() {
        return systemErrorJsonFile;
    }

    public void setSystemErrorJsonFile(String systemErrorJsonFile) {
        this.systemErrorJsonFile = systemErrorJsonFile;
    }

    public SystemErrors() throws IOException, ParseException {
        loadSystemErrors();
    }

    public void loadSystemErrors() throws IOException, ParseException {
        systemErrorsMap = convertJsonToHashmap.convertJSONToHashmap(JSONFileReader.readJsonFile(getSystemErrorJsonFile()));
    }

    public HashMap<String, Object> getMap() {
        return systemErrorsMap;
    }

    public void setMap(HashMap<String, Object> _systemErrorsMap) {
        systemErrorsMap = _systemErrorsMap;
    }

    public Boolean isSingleKeyExist(String key) {
        return systemErrorsMap.keySet().contains(key);
    }

    public HashMap<String, Boolean> isMultipleKeyExist(HashMap<String, String> keySetMap) {
        return isMultipleKeyExistResultMap;
    }

    public String getSingleKey(String key)
    {
        if (!isSingleKeyExist(key))
            return getSingleKey("-1");
        return systemErrorsMap.get(key).toString();
    }

    public HashMap<String, Object> getMultipleKey(HashMap<String, String> keySetMap) {
        // Method to check whether the key set specified are present in the map.
        logger.trace("Checking whether key set specified are present in the map...");
        for(String key : keySetMap.keySet())
        {
            if(!systemErrorsMap.keySet().contains(key))
            {
                logger.error(getSingleKey("-1"));
            }
            getResultMap.put(key, systemErrorsMap.get(key));
        }
        return getResultMap;
    }

    public void setSingleKey(String key, Object value) {
        if(!isSingleKeyExist(key))
            systemErrorsMap.put(key, value);
        logger.error(getSingleKey("-2"));
    }

    public void setMultipleKey(HashMap<String, Object> keySetMap)
    {
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
                setSingleKey(key, keySetMap.get(key));
            logger.error(getSingleKey("-2"));
        }
    }

    private void setDefaultKey(String key, String value)
    {
        if(!isSingleKeyExist(key))
            setSingleKey(key, value);
        logger.error("Key already exist!!!");
    }

    private void setMultipleDefaultKey(HashMap<String, String> keySetMap)
    {
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
                setSingleKey(key, keySetMap.get(key));
            logger.error(getSingleKey("-2"));
        }
    }

    public void deleteSingleKey(String key)
    {
        logger.trace("Deleting specified key if present in the map...");
        if (!isSingleKeyExist(key))
            logger.error(getSingleKey("-1"));
        systemErrorsMap.remove(key);
        logger.info("The key [ " + key + " ] is deleted from the map.");
    }

    public void deleteMultipleKey(HashMap<String, String> keySetMap)
    {
        logger.trace("Deleting set of keys specified, from the map...");
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
                logger.error(getSingleKey("-1"));
            systemErrorsMap.remove(key);
            logger.trace("The key [ " + key + " ] is deleted from the map successfully.");
        }
    }

    public void updateSingleKey(String key, Object newValue)
    {
        logger.trace("Updating specified key if present in the map...");
        if (!isSingleKeyExist(key))
            logger.error(getSingleKey("-1"));
        logger.info("The value of key [ " + key + " ] will be updated from [ " + systemErrorsMap.get(key) + " ] to [ " + newValue + " ] ");
        systemErrorsMap.replace(key, newValue);
        logger.info("The value is updated in the map successfully.");
    }

    public void updateMultipleKey(HashMap<String, Object> keySetMap)
    {
        logger.trace("Updating set of keys specified, from the map...");
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
                logger.error(getSingleKey("-1"));
            logger.info("The value of key [ " + key + " ] will be updated from [ " + systemErrorsMap.get(key) + " ] to [ " + keySetMap.get(key) + " ] ");
            systemErrorsMap.replace(key, keySetMap.get(key));
        }
        logger.trace("The values are updated in the map successfully.");
    }

    @Override
    public <T> void printHashmap(HashMap<String, T> hashMap) {
        logger.trace("Printing the hashmap values...");
        for(String key : hashMap.keySet())
        {
            logger.info("Key : [ " + key + " ], Value : [ " + hashMap.get(key) + " ] ");
        }
    }
}
