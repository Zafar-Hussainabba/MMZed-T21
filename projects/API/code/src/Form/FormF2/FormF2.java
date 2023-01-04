package code.src.Form.FormF2;

import AttributeControllers.ResultMap;
import FormValidator.Validator;
import Interfaces.ILogger;
import code.src.ApiData.ApiData;
import code.src.BaseAttributes.exceptions.SystemErrors;
import code.src.Form.FormDefinition.FormDefinitionF2.FormDefinitionF2;
import code.src.Form.FormErrors.FormErrorsF2.FormErrorsF2;
import code.src.Form.FormF2.interfaces.IFormF2;
import code.src.Form.FormHelp.FormHelpF2.FormHelpF2;
import code.src.Form.FormValidationResults.FormValidationResult_F1.FormValidationResult_F1;
import code.src.Form.FormValidationResults.FormValidationResult_F2.FormValidationResult_F2;
import code.src.HttpInput.HttpInputF2.HttpInputF2;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FormF2 implements IFormF2, ILogger {
    private SystemErrors systemErrors = new SystemErrors();
    private ResultMap resultMap = new ResultMap();
    private FormValidationResult_F2 formValidationResult_F2 = new FormValidationResult_F2();

    private FormErrorsF2 errorsF2 = new FormErrorsF2();
    private FormHelpF2 helpF2 = new FormHelpF2();
    private HttpInputF2 httpInput_F2 = new HttpInputF2();
    private FormDefinitionF2 formDefinitionF2;
    private Validator validator_F2;
    private ApiData apidata = new ApiData();
    private static String apiLinkForFormInput;

    private ArrayList<String> inputFieldList;
    private ArrayList<String> expectedFieldList;
    private ArrayList<String> mandatoryFieldList;



    HashMap<String, Object> validatorHash = new HashMap<>();
    HashMap<String, Boolean> validatorResultHash = new HashMap<>();

    public FormF2(String _apiLinkForFormInput) throws IOException, ParseException {
        setApiLinkForFormInput(_apiLinkForFormInput);
    }

    public static String getApiLinkForFormInput()
    {
        return apiLinkForFormInput;
    }

    public static void setApiLinkForFormInput(String apiLinkForFormInput) {
        FormF2.apiLinkForFormInput = apiLinkForFormInput;
    }

    @Override
    public void init() throws IOException, ParseException {
        httpInput_F2.setMap(apidata.get(getApiLinkForFormInput()));
        formDefinitionF2 = new FormDefinitionF2();
    }

    @Override
    public void pre_process() {

        inputFieldList = (ArrayList<String>) httpInput_F2.getSingleKey("__FORM__::F2::__FIELD_LIST__");
        expectedFieldList = (ArrayList<String>) formDefinitionF2.getSingleKey("__FORM__::F2::__FIELD_LIST__");
        mandatoryFieldList = (ArrayList<String>) formDefinitionF2.getSingleKey("__FORM__::F2::__FIELD_LIST__::Mandatory");

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
            validatorHash.put("inputString", httpInput_F2.getMap().get("__FORM__::F2::__FIELD_VALUE__::" + field));
            validatorHash.put("rules", formDefinitionF2.getMap().get("__FORM__::F2::__FIELD_VALUE__::" + field + "::__RULE_LIST__"));
            validatorResultHash = validator_F2.validate(validatorHash);

            setErrorCodeAndHelpCode(field);

            logger.info("Result of the validation for field : [ " + field + " ] is...");
            formValidationResult_F2.printHashmap(validatorResultHash);

            logger.trace("Printing error and help code if generated during validation...");
            errorsF2.printHashmap(errorsF2.getMap());
            helpF2.printHashmap(helpF2.getMap());
        }
    }

    public void setErrorCodeAndHelpCode(String field)
    {
        for(String rule : validatorResultHash.keySet())
        {
            if(!validatorResultHash.get(rule))
            {
                errorsF2.setSingleKey("__FORM__::F2::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::error_code", formDefinitionF2.getSingleKey("__FORM__::F2::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::error_code").toString());
                helpF2.setSingleKey("__FORM__::F2::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::help_code", formDefinitionF2.getSingleKey("__FORM__::F2::__FIELD_VALUE__::" + field + "::__RULE__:: " + rule + " ::help_code").toString());
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
