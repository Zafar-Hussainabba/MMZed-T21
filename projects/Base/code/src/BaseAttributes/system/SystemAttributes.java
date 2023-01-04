package code.src.BaseAttributes.system;

import code.src.BaseAttributes.exceptions.KeyNotFoundException;
import code.src.BaseAttributes.interfaces.IAttributes;
import code.src.BaseAttributes.interfaces.IBaseHashMap;
import code.src.BaseAttributes.system.interfaces.ISystemAttributes;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;

public class SystemAttributes implements ISystemAttributes
{

    @Override
    public HashMap<String, Object> getMap() {
        return null;
    }

    @Override
    public void setMap(HashMap<String, Object> map) {

    }

    @Override
    public Boolean isSingleKeyExist(String key) {
        return null;
    }

    @Override
    public HashMap<String, Boolean> isMultipleKeyExist(HashMap<String, String> keySetMap) {
        return null;
    }

    @Override
    public String getSingleKey(String key) {
        return null;
    }

    @Override
    public HashMap<String, Object> getMultipleKey(HashMap<String, String> keySetMap) {
        return null;
    }

    @Override
    public void setSingleKey(String key, Object value) {

    }

    @Override
    public void setMultipleKey(HashMap<String, Object> keySetMap) {

    }

    @Override
    public void deleteSingleKey(String key) {

    }

    @Override
    public void deleteMultipleKey(HashMap<String, String> keySetMap) {

    }

    @Override
    public void updateSingleKey(String key, Object value) {

    }

    @Override
    public void updateMultipleKey(HashMap<String, Object> keySetMap) {

    }
}
