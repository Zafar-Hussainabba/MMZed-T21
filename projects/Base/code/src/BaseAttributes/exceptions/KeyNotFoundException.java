package code.src.BaseAttributes.exceptions;

import code.src.BaseAttributes.interfaces.IMMZedError;

public class KeyNotFoundException extends Exception implements IMMZedError {
    public KeyNotFoundException(String message)
    {
        super(message);
    }

}
