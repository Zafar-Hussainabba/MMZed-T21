package code.src.BaseAttributes.exceptions;

import Hashmap.interfaces.ICommonHashmap;
import methods.ReusableMethods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class SystemErrors implements ICommonHashmap {
    private static final Logger logger = LogManager.getLogger( SystemErrors.class );
    //private static Controller controller = new Controller();
    //private static ProcessMap processMap = new ProcessMap();
    //private static ResultMap resultMap = new ResultMap();
    private static HashMap<String, Boolean> IsExistKeyResultMap = new HashMap<>();
    private static HashMap<String, Object> systemErrorsMap = new HashMap<>();
    private static HashMap<String, Object> getResultMap = new HashMap<>();


    public SystemErrors()
    {
        setDefaultKey("-1", "Key not found!!!");
        setDefaultKey("-2", "Key already exist!!!");
        setDefaultKey("-3", "Mandatory key not found!!!");
        setDefaultKey("-4", "Mandatory value not found!!!");
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
        return IsExistKeyResultMap;
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
        logger.error(getSingleKey("-2"));
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

    }
}
