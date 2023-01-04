package MMZed_Errors;

import Hashmap.CommonHashmap;
import JSONFileReader.JSONFileReader;
import converter.JSONToHashmap.JSONToHashmap;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MMZed_ErrorEngine extends CommonHashmap {
    private JSONToHashmap convertJsonToHashmap = new JSONToHashmap();
    private ArrayList<String> errorCodeList = new ArrayList<>();
    private ArrayList<String> errorTypeList = new ArrayList<>();
    private ArrayList<String> errorIdListOfErrorType = new ArrayList<>();
    private HashMap<String, String> errorMessageMap = new HashMap<>();

    public MMZed_ErrorEngine() throws IOException, ParseException {
        super.hashmapName = "ErrorEngineMap";
        setMap(convertJsonToHashmap.convertJSONToHashmap(JSONFileReader.readJsonFile("projects/ErrorEngine/data/json/SK_MMZed_COMMON_FORM_VALIDATION_error.json")));
    }

    private ArrayList<String> getErrorCodeList()
    {
        if(!isSingleKeyExist("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR_LIST__"))
            logger.error("key not found!!!");
        errorCodeList = (ArrayList<String>)this.getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR_LIST__");
        return errorCodeList;
    }

    private ArrayList<String> getErrorTypeList(String errorCode)
    {
        errorTypeList = (ArrayList<String>)getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPES__");
        return errorTypeList;
    }

    private ArrayList<String> getErrorIdOfErrorType(String errorCode, String errorType)
    {
        errorIdListOfErrorType = (ArrayList<String>)getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPE__::" + errorType + "::__ERROR_IDS__");
        return errorIdListOfErrorType;
    }

    public HashMap<String, String> getErrorMessageMap(String errorCode)
    {
        String errorMessage;
        if(!getErrorCodeList().contains(errorCode))
        {
            logger.error("Details for error code : [ " + errorCode + " ], not found!!!");
            System.exit(-3);
        }
        for (String errorType : getErrorTypeList(errorCode))
        {
            for(String errorIdOfErrorType : getErrorIdOfErrorType(errorCode, errorType))
            {
                if(!getMap().keySet().contains("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPE__::" + errorType + "::__ERROR_ID__::" + errorIdOfErrorType + "::message::custom") || getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPE__::" + errorType + "::__ERROR_ID__::" + errorIdOfErrorType + "::message::custom").equals(""))
                {
                    if(errorType.equals("system"))
                    {
                        errorMessage = getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPE__::" + errorType + "::__ERROR_ID__::" + errorIdOfErrorType + "::message::default").toString();
                        errorMessageMap.put("SystemErrorMessage", errorMessage);
                    }
                    else
                    {
                        errorMessage = getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPE__::" + errorType + "::__ERROR_ID__::" + errorIdOfErrorType + "::message::default").toString();
                        errorMessageMap.put("UserErrorMessage", errorMessage);
                    }
                }
                else
                {
                    if(errorType.equals("system"))
                    {
                        errorMessage = getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPE__::" + errorType + "::__ERROR_ID__::" + errorIdOfErrorType + "::message::custom").toString();
                        errorMessageMap.put("SystemErrorMessage", errorMessage);
                    }
                    else
                    {
                        errorMessage = getSingleKey("__FORM_VALIDATION_ERROR__::__COMMON__::__ERROR__::" + errorCode + "::__ERROR_TYPE__::" + errorType + "::__ERROR_ID__::" + errorIdOfErrorType + "::message::custom").toString();
                        errorMessageMap.put("UserErrorMessage", errorMessage);
                    }
                }
            }
        }
        return errorMessageMap;
    }
}