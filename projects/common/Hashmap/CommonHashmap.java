package Hashmap;

import Hashmap.interfaces.ICommonHashmap;
import AttributeControllers.SystemErrors;
import Interfaces.ILogger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class CommonHashmap implements ICommonHashmap, ILogger {
    private SystemErrors systemErrors = new SystemErrors();
    private HashMap<String, Object> hashMap = new HashMap<>();
    public String hashmapName;

    private HashMap<String, Boolean> isExistResultMap = new HashMap<>();
    private HashMap<String, Boolean> getResultMap = new HashMap<>();
    private HashMap<String, Boolean> setResultMap = new HashMap<>();
    private HashMap<String, String> deleteResultMap = new HashMap<>();
    private HashMap<String, String> updateResultMap = new HashMap<>();
    private HashMap<String, Object> getMultipleKeyMap = new HashMap<>();

    public CommonHashmap() throws IOException, ParseException {
    }

    @Override
    public HashMap<String, Object> getMap() {
        return hashMap;
    }

    @Override
    public void setMap(HashMap<String, Object> hashMap) {
        this.hashMap = hashMap;
        logger.trace("Map : [ " + hashmapName + " ], set successfully.");
    }

    @Override
    public Boolean isSingleKeyExist(String key) {
        return hashMap.keySet().contains(key);
    }

    @Override
    public HashMap<String, Boolean> isMultipleKeyExist(HashMap<String, String> keySetMap) {
        // Method to check whether the key set specified are present in the map.
        logger.trace("Checking whether key set specified are present in the map...");
        for(String key : keySetMap.keySet())
        {
            if(!hashMap.keySet().contains(key))
            {
                isExistResultMap.put(key, false);
            }
            else
                isExistResultMap.put(key, true);
        }
        printHashmap(isExistResultMap);
        return isExistResultMap;
    }

    @Override
    public Object getSingleKey(String key) {
        if(!isSingleKeyExist(key))
        {
            logger.error(systemErrors.getSingleKey("-1"));
            return "null";
        }
        return hashMap.get(key);
    }

    @Override
    public HashMap<String, Object> getMultipleKey(HashMap<String, String> keySetMap) {
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
            {
                getResultMap.put(key, false);
            }
            else
            {
                getResultMap.put(key, true);
                getMultipleKeyMap.put(key, keySetMap.get(key));
            }
        }
        logger.trace("Printing the get result for specified map...");
        printHashmap(getResultMap);

        logger.trace("Printing the values got from the map...");
        printHashmap(getMultipleKeyMap);

        return getMultipleKeyMap;
    }

    @Override
    public void setSingleKey(String key, Object value) {
        logger.trace("Setting a new key : [ " + key + " ] in map : [ " + hashmapName + " ] ");
        if(!isSingleKeyExist(key))
        {
            hashMap.put(key, value);
            logger.info("The key : [ " + key + " ] is set successfully.");
        }
        else
            logger.error(systemErrors.getSingleKey("-2"));
    }

    @Override
    public void setMultipleKey(HashMap<String, Object> keySetMap) {
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
            {
                setSingleKey(key, keySetMap.get(key));
                setResultMap.put(key, true);
            }
            else
                setResultMap.put(key, false);
        }
        logger.trace("Printing the set result for specified map...");
        printHashmap(setResultMap);

        logger.trace("Printing the hashmap after setting new values...");
        printHashmap(hashMap);
    }

    @Override
    public void deleteSingleKey(String key) {
        logger.trace("Deleting specified key if present in the map...");
        if (!isSingleKeyExist(key))
            logger.error(systemErrors.getSingleKey("-1"));
        else
        {
            hashMap.remove(key);
            logger.info("The key [ " + key + " ] is deleted from the map.");
        }

        logger.trace("Printing the hashmap after deleting the key...");
        printHashmap(hashMap);
    }

    @Override
    public void deleteMultipleKey(HashMap<String, String> keySetMap) {
        logger.trace("Deleting set of keys specified, from the map...");
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
            {
                deleteResultMap.put(key, systemErrors.getSingleKey("-1"));
            }
            else
            {
                hashMap.remove(key);
                deleteResultMap.put(key, "Deleted successfully");
            }
        }
        logger.trace("Printing the delete result for specified map...");
        printHashmap(deleteResultMap);

        logger.trace("Printing the hashmap after deleting the keys...");
        printHashmap(hashMap);
    }

    @Override
    public void updateSingleKey(String key, Object newValue) {
        logger.trace("Updating specified key if present in the map...");
        if (!isSingleKeyExist(key))
            logger.error(getSingleKey("-1"));
        else
        {
            logger.info("The value of key [ " + key + " ] will be updated from [ " + hashMap.get(key) + " ] to [ " + newValue + " ] ");
            hashMap.replace(key, newValue);
            logger.info("The value is updated in the map successfully.");
        }

        logger.trace("Printing the hashmap after updating the key...");
        printHashmap(hashMap);
    }

    @Override
    public void updateMultipleKey(HashMap<String, Object> keySetMap) {
        logger.trace("Updating set of keys specified, from the map...");
        for(String key : keySetMap.keySet())
        {
            if(!isSingleKeyExist(key))
            {
                updateResultMap.put(key, systemErrors.getSingleKey("-1"));
            }
            else
            {
                logger.info("The value of key [ " + key + " ] will be updated from [ " + hashMap.get(key) + " ] to [ " + keySetMap.get(key) + " ] ");
                hashMap.replace(key, keySetMap.get(key));
                updateResultMap.put(key, "Updated successfully");
            }
        }
        logger.trace("Printing the update result for specified map...");
        printHashmap(updateResultMap);

        logger.trace("Printing the hashmap after updating the keys...");
        printHashmap(hashMap);
    }

    public <T> void printHashmap(HashMap<String, T> hashMap)
    {
        logger.trace("Printing the values of hashmap : [ " + hashmapName + " ] ");
        for(String key : hashMap.keySet())
        {
            logger.info("Key : [ " + key + " ], Value : [ " + hashMap.get(key) + " ] ");
        }
    }

    public <T> void printGivenHashmap(HashMap<String, T> hashMap, String mapName)
    {
        logger.trace("Printing the values of hashmap : [ " + mapName + " ] ");
        for(String key : hashMap.keySet())
        {
            logger.info("Key : [ " + key + " ], Value : [ " + hashMap.get(key) + " ] ");
        }
    }
}
