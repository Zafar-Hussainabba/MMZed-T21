package code.src.BaseAttributes.Validation;

import Hashmap.interfaces.ICommonHashmap;

import java.util.HashMap;

public class CommonValidation implements ICommonHashmap {
    private static HashMap<String, Object> commonValidation = new HashMap<>();

    public HashMap<String, Object> getMap()
    {
        return commonValidation;
    }

    public void setMap(HashMap<String, Object> commonValidation) {
        this.commonValidation = commonValidation;
    }

    public Boolean isSingleKeyExist(String key) {
        return null;
    }

    public HashMap<String, Boolean> isMultipleKeyExist(HashMap<String, String> keySetMap) {
        return null;
    }

    public String getSingleKey(String key) {
        return null;
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
