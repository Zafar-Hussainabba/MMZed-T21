package code.src.BaseAttributes.interfaces;

import code.src.BaseAttributes.BaseHashMapKeys;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

public interface IBaseHashMap {
    static final Logger logger = LogManager.getLogger( BaseHashMapKeys.class );
    static final HashMap<String, Object> baseHash = new HashMap<>();

    /*String getKeyValue(String key) throws KeyNotFoundException;
    String[] getKeys();
    void setKeyValue(String key,String value) ;
    JSONObject getJSON(IBaseHashMapString object) ;

    void deleteKey(String key);

    Boolean isExistsKey(String key) throws KeyNotFoundException;*/

    public HashMap<String, Object> getMap();
    public void setMap(HashMap<String, Object> map);
    public Boolean isSingleKeyExist( String key );
    public HashMap<String, Boolean> isMultipleKeyExist( HashMap<String, String> keySetMap );
    public String getSingleKey( String key );
    public HashMap<String, Object> getMultipleKey( HashMap<String, String> keySetMap );
    public void setSingleKey( String key, Object value );
    public void setMultipleKey( HashMap<String, Object> keySetMap );
    public void deleteSingleKey( String key );
    public void deleteMultipleKey( HashMap<String, String> keySetMap );
    public void updateSingleKey( String key, Object value );
    public void updateMultipleKey( HashMap<String, Object> keySetMap );

}
