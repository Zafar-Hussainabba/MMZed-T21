package Hashmap.interfaces;

import java.util.HashMap;

public interface ICommonHashmap {
    public HashMap<String, Object> getMap();
    public void setMap(HashMap<String, Object> map);
    public Boolean isSingleKeyExist( String key );
    public HashMap<String, Boolean> isMultipleKeyExist( HashMap<String, String> keySetMap );
    public Object getSingleKey( String key );
    public HashMap<String, Object> getMultipleKey( HashMap<String, String> keySetMap );
    public void setSingleKey( String key, Object value );
    public void setMultipleKey( HashMap<String, Object> keySetMap );
    public void deleteSingleKey( String key );
    public void deleteMultipleKey( HashMap<String, String> keySetMap );
    public void updateSingleKey( String key, Object value );
    public void updateMultipleKey( HashMap<String, Object> keySetMap );
    public <T> void printHashmap(HashMap<String, T> hashMap);
}
