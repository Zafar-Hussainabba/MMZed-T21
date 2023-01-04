package code.src.BaseAttributes.api.interfaces;

import code.src.BaseAttributes.interfaces.IBaseHashMap;

import java.util.HashMap;

public interface IEndPoint extends IBaseHashMap{
    static final HashMap<String, Object> apiHash = new HashMap<>();

    void init(String apiLink);
}
