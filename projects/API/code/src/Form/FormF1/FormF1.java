package code.src.Form.FormF1;

import AttributeControllers.ResultMap;
import FormValidator.Validator;
import Hashmap.CommonHashmap;
import MMZed_Errors.MMZed_ErrorEngine;
import code.src.ApiData.ApiData;
import code.src.BaseAttributes.exceptions.SystemErrors;
import code.src.Form.FormDefinition.FormDefinitionF1.FormDefinitionF1;
import code.src.Form.FormErrors.FormErrorsF1.FormErrorsF1;
import code.src.Form.FormF1.interfaces.IFormF1;
import code.src.Form.FormHelp.FormHelpF1.FormHelpF1;
import Interfaces.ILogger;
import code.src.Form.FormValidationResults.FormValidationResult_F1.FormValidationResult_F1;
import code.src.HttpInput.HttpInputF1.HttpInputF1;
import methods.ReusableMethods;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FormF1 extends CommonHashmap implements IFormF1, ILogger {
    private SystemErrors systemErrors = new SystemErrors();
    private ResultMap resultMap = new ResultMap();
    private FormValidationResult_F1 formValidationResult_F1 = new FormValidationResult_F1();
    private MMZed_ErrorEngine errorEngine = new MMZed_ErrorEngine();

    private FormErrorsF1 errorsF1 = new FormErrorsF1();
    private FormHelpF1 helpF1 = new FormHelpF1();
    private FormDefinitionF1 formDefinitionF1;
    private Validator validator_F1 = new Validator();
    private ApiData apidata = new ApiData();
    private static String apiLinkForFormInput;

    private ArrayList<String> inputFieldList;
    private ArrayList<String> expectedFieldList;
    private ArrayList<String> mandatoryFieldList;



    HashMap<String, Object> validatorHash = new HashMap<>();
    HashMap<String, Boolean> validatorResultHash = new HashMap<>();


    public FormF1(String _apiLinkForFormInput) throws IOException, ParseException {
        super.hashmapName = "FormF1Hashmap";
        setApiLinkForFormInput(_apiLinkForFormInput);
    }

    public static String getApiLinkForFormInput()
    {
        return apiLinkForFormInput;
    }

    public static void setApiLinkForFormInput(String apiLinkForFormInput) {
        FormF1.apiLinkForFormInput = apiLinkForFormInput;
    }

    @Override
    public void init() throws IOException, ParseException {
        logger.trace("Loading the http input to a hashmap...");
        this.setMap(apidata.get(getApiLinkForFormInput()));
        logger.trace("Http input is loaded to hashmap successfully.");
        formDefinitionF1 = new FormDefinitionF1();
    }

    @Override
    public void pre_process() {

        inputFieldList = (ArrayList<String>) this.getSingleKey("__FORM__::F1::__FIELD_LIST__");
        expectedFieldList = (ArrayList<String>) formDefinitionF1.getSingleKey("__FORM__::F1::__FIELD_LIST__");
        mandatoryFieldList = (ArrayList<String>) formDefinitionF1.getSingleKey("__FORM__::F1::__FIELD_LIST__::Mandatory");

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
                //logger.error(systemErrors.getSingleKey("-11"));
                logger.error("Expected field : [ " + field + " ] not found!!!");
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
                //logger.error(systemErrors.getSingleKey("-12"));
                logger.error("Mandatory field : [ " + field + " ] not found, Hence exiting!!!");
                System.exit(-3);
            }
        }
    }

    public void validate(ArrayList<String> inputFieldList)
    {
        for(String field : inputFieldList)
        {
            logger.trace("Validating field : [ " + field + " ] ");
            validatorHash.put("Mode", getMap().get("__FORM__::F1::VALIDATION_MODE"));
            validatorHash.put("inputString", getMap().get("__FORM__::F1::__FIELD_VALUE__::" + field));
            validatorHash.put("rules", formDefinitionF1.getMap().get("__FORM__::F1::__FIELD_VALUE__::" + field + "::__RULE_LIST__"));
            ReusableMethods.printHashmapData(validatorHash);
            validatorResultHash = validator_F1.validate(validatorHash);
            setErrorCodeAndHelpCode(field);
            //getErrorCodeDetails();

            logger.info("Validation result for field : [ " + field + " ] is...");
            formValidationResult_F1.printHashmap(validatorResultHash);

            getErrorCodeAndHelpCode(field);
        }
        /*if(errorsF1.getMap().keySet().size() != 0)
        {
            logger.trace("Printing error code generated during validation...");
            errorsF1.printHashmap(errorsF1.getMap());
        }

        if(errorsF1.getMap().keySet().size() != 0)
        {
            logger.trace("Printing help code generated during validation...");
            helpF1.printHashmap(helpF1.getMap());
        }*/
    }

    private void setErrorCodeAndHelpCode(String field)
    {
        for(String rule : validatorResultHash.keySet())
        {
            if(!validatorResultHash.get(rule))
            {
                errorsF1.setSingleKey("__FORM__::F1::__FIELD_VALUE__::" + field + "::__RULE__::" + rule + "::error_code", formDefinitionF1.getSingleKey("__FORM__::F1::__FIELD_VALUE__::" + field + "::__RULE__::" + rule + "::error_code").toString());
                helpF1.setSingleKey("__FORM__::F1::__FIELD_VALUE__::" + field + "::__RULE__::" + rule + "::help_code", formDefinitionF1.getSingleKey("__FORM__::F1::__FIELD_VALUE__::" + field + "::__RULE__::" + rule + "::help_code").toString());
            }
        }
    }

    private void getErrorCodeAndHelpCode(String field)
    {
        for(String rule : validatorResultHash.keySet())
        {
            if(!validatorResultHash.get(rule))
            {
                logger.info("Error code for field - [ " + field + " ], rule - [ " + rule + " ]  is : [ " + errorsF1.getSingleKey("__FORM__::F1::__FIELD_VALUE__::" + field + "::__RULE__::" + rule + "::error_code") + " ] ");
                logger.info("Help code for field - [ " + field + " ], rule - [ " + rule + " ]  is : [ " + helpF1.getSingleKey("__FORM__::F1::__FIELD_VALUE__::" + field + "::__RULE__::" + rule + "::help_code") + " ] ");
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
