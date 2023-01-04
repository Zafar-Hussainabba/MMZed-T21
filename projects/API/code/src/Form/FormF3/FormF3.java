package code.src.Form.FormF3;

import AttributeControllers.ResultMap;
import FormValidator.Validator;
import Interfaces.ILogger;
import code.src.ApiData.ApiData;
import code.src.BaseAttributes.exceptions.SystemErrors;
import code.src.Form.FormDefinition.FormDefinitionF3.FormDefinitionF3;
import code.src.Form.FormErrors.FormErrorsF3.FormErrorsF3;
import code.src.Form.FormF3.interfaces.IFormF3;
import code.src.Form.FormHelp.FormHelpF3.FormHelpF3;
import code.src.Form.FormValidationResults.FormValidationResult_F2.FormValidationResult_F2;
import code.src.Form.FormValidationResults.FormValidationResult_F3.FormValidationResult_F3;
import code.src.HttpInput.HttpInputF3.HttpInputF3;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FormF3 implements IFormF3, ILogger {
    private SystemErrors systemErrors = new SystemErrors();
    private ResultMap resultMap = new ResultMap();
    private FormValidationResult_F3 formValidationResult_F3 = new FormValidationResult_F3();

    private FormErrorsF3 errorsF3 = new FormErrorsF3();
    private FormHelpF3 helpF3 = new FormHelpF3();
    private HttpInputF3 httpInput_F3 = new HttpInputF3();
    private FormDefinitionF3 formDefinitionF3;
    private Validator validator_F3;
    private ApiData apidata = new ApiData();
    private static String apiLinkForFormInput;

    private ArrayList<String> inputFieldList;
    private ArrayList<String> expectedFieldList;
    private ArrayList<String> mandatoryFieldList;



    HashMap<String, Object> validatorHash = new HashMap<>();
    HashMap<String, Boolean> validatorResultHash = new HashMap<>();

    public FormF3(String _apiLinkForFormInput) throws IOException, ParseException {
        setApiLinkForFormInput(_apiLinkForFormInput);
    }

    public static String getApiLinkForFormInput()
    {
        return apiLinkForFormInput;
    }

    public static void setApiLinkForFormInput(String apiLinkForFormInput) {
        code.src.Form.FormF3.FormF3.apiLinkForFormInput = apiLinkForFormInput;
    }

    @Override
    public void init() throws IOException, ParseException {
        httpInput_F3.setMap(apidata.get(getApiLinkForFormInput()));
        formDefinitionF3 = new FormDefinitionF3();
    }

    @Override
    public void pre_process() {

        inputFieldList = (ArrayList<String>) httpInput_F3.getSingleKey("__FORM__::F3::__FIELD_LIST__");
        expectedFieldList = (ArrayList<String>) formDefinitionF3.getSingleKey("__FORM__::F3::__FIELD_LIST__");
        mandatoryFieldList = (ArrayList<String>) formDefinitionF3.getSingleKey("__FORM__::F3::__FIELD_LIST__::Mandatory");

        expectedFieldListCheck(inputFieldList, expectedFieldList);
        mandatoryFieldListCheck(inputFieldList, mandatoryFieldList);
        validate(inputFieldList);

    }

    public void expectedFieldListCheck(ArrayList<String> inputFieldList,ArrayList<String> expectedFieldList)
    {
        logger.trace("Checking whether expected fields have come in http input...");
        for(String field : expectedFieldList)
        {
            if(!inputFieldList.contains(field))
            {
                // - TODO - Have a proper format of logging the error
                logger.error(systemErrors.getSingleKey("-11"));
                //logger.error("Key : [ " + field + " ] " + systemErrors.getSingleKey("-11"));
                //resultMap.setSingleKey(field, systemErrors.getSingleKey("-11"));
            }
        }
    }

    public void mandatoryFieldListCheck(ArrayList<String> inputFieldList,ArrayList<String> mandatoryFieldList)
    {
        logger.trace("Checking whether mandatory fields have come in http input...");
        for(String field : mandatoryFieldList)
        {
            if(!inputFieldList.contains(field))
            {
                logger.error(systemErrors.getSingleKey("-12"));
            }
        }
    }

    public void validate(ArrayList<String> inputFieldList)
    {
        logger.trace("Validating each fields coming from http...");
        for(String field : inputFieldList)
        {
            validatorHash.put("inputString", httpInput_F3.getMap().get("__FORM__::F3::__FIELD_VALUE__::" + field));
            validatorHash.put("rules", formDefinitionF3.getMap().get("__FORM__::F3::__FIELD_VALUE__::" + field + "::__RULE_LIST__"));
            validatorResultHash = validator_F3.validate(validatorHash);

            setErrorCodeAndHelpCode(field);

            logger.info("Result of the validation for field : [ " + field + " ] is...");
            formValidationResult_F3.printHashmap(validatorResultHash);

            logger.trace("Printing error and help code if generated during validation...");
            errorsF3.printHashmap(errorsF3.getMap());
            helpF3.printHashmap(helpF3.getMap());
        }
    }

    public void setErrorCodeAndHelpCode(String field)
    {
        for(String rule : validatorResultHash.keySet())
        {
            if(!validatorResultHash.get(rule))
            {
                errorsF3.setSingleKey("__FORM__::F3::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::error_code", formDefinitionF3.getSingleKey("__FORM__::F3::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::error_code").toString());
                helpF3.setSingleKey("__FORM__::F3::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::help_code", formDefinitionF3.getSingleKey("__FORM__::F3::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::help_code").toString());
            }
        }
    }


    @Override
    public void process() {

    }

    @Override
    public void post_process() {

    }
}

