package code.src.BaseAttributes.system.Runtime;

import code.src.BaseAttributes.system.Runtime.interfaces.IRuntimeAttributes;

import java.util.HashMap;

public class RuntimeSystemAttributes implements IRuntimeAttributes {

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
