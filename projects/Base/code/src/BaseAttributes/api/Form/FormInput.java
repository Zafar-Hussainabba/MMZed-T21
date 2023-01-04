package code.src.BaseAttributes.api.Form;

import Hashmap.interfaces.ICommonHashmap;
import AttributeControllers.SystemErrors;
import methods.ReusableMethods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class FormInput implements ICommonHashmap {
    public static final Logger logger = LogManager.getLogger( FormInput.class );
    private SystemErrors systemErrors = new SystemErrors();
    private HashMap<String, Object> formInputMap = new HashMap<>();
    private static HashMap<String, Boolean> isMultipleKeyExistResultMap = new HashMap<>();

    public FormInput() throws IOException, ParseException {
    }


    public HashMap<String, Object> getMap() {
        return null;
    }

    public void setMap(HashMap<String, Object> map) {

    }

    public Boolean isSingleKeyExist(String key) {
        return formInputMap.keySet().contains(key);
    }

    public HashMap<String, Boolean> isMultipleKeyExist(HashMap<String, String> keySetMap) {
        return isMultipleKeyExistResultMap;
    }

    public String getSingleKey(String key)
    {
        if (!isSingleKeyExist(key))
            return systemErrors.getSingleKey("-1");
        return formInputMap.get(key).toString();
    }

    public HashMap<String, Object> getMultipleKey(HashMap<String, String> keySetMap) {
        return null;
    }

    public void setSingleKey(String key, Object value) {

    }

    public void setMultipleKey(HashMap<String, Object> keySetMap) {

    }

    public void deleteSingleKey(String key) {

    }

    public void deleteMultipleKey(HashMap<String, String> keySetMap) {

    }

    public void updateSingleKey(String key, Object value) {

    }

    public void updateMultipleKey(HashMap<String, Object> keySetMap) {

    }

    @Override
    public <T> void printHashmap(HashMap<String, T> hashMap) {

    }
}
