# ErrorEngine
Java programme written for validating using data driven approach and test driven approach

* [Introduction](#introduction)
* [Technologies](#technologies)
* [Illustrations](#illustrations)
* [Jars used](#jars-used)
* [Examples of use](#examples-of-use)

##Introduction
The engine will provide a flexibility to log errorr messages in an indexed approach.

##Technologies
Engine is created with :
* java version "15.0.2" 2021-01-19
* Java(TM) SE Runtime Environment (build 15.0.2+7-27)
* Java HotSpot(TM) 64-Bit Server VM (build 15.0.2+7-27, mixed mode, sharing)

##Illustrations
Class definition
1. MMZed_ErrorEngine
    * Attributes :
        * errorMap
            * key - MMZed_ErrorEngine code
            * value - MMZed_ErrorEngine data
    * Constructor :
        * 
    * methods :
        * isSingleErrorCodeExist
        * isMultipleErrorCodeExist
        * setSingleErrorCodeType
        * setMultipleErrorCodeType
        * getSingleErrorCode
        * getMultipleErrorCode
        * addSingleErrorCode
        * addMultipleErrorCode
        * deleteSingleErrorCode
        * deleteMultipleErrorCode
        * updateSingleErrorCode
        * updateMultipleErrorCode
2. ErrorType
    * Attributes :
        * errorTypeMap
            * key - MMZed_ErrorEngine type
            * value - MMZed_ErrorEngine type data
    * Constructor :
        *
    * methods :
        * isSingleErrorTypeExist
        * isMultipleErrorTypeExist
        * setSingleErrorTypeData
        * setMultipleErrorTypeData
        * getSingleErrorTypeData
        * getMultipleErrorTypeData
        * addSingleErrorType
        * addMultipleErrorType
        * deleteSingleErrorType
        * deleteMultipleErrorType
        * updateSingleErrorType
        * updateMultipleErrorType
3. ErrorTypeCode
    * Attributes :
        * errorTypeCodeMap
            * key - MMZed_ErrorEngine type code
            * value - MMZed_ErrorEngine type code data
    * Constructor :
        *
    * methods :
        * isSingleErrorTypeCodeExist
        * isMultipleErrorTypeCodeExist
        * setSingleErrorTypeCodeData
        * setMultipleErrorTypeCodeData
        * getSingleErrorTypeCodeData
        * getMultipleErrorTypeCodeData
        * addSingleErrorTypeCode
        * addMultipleErrorTypeCode
        * deleteSingleErrorTypeCode
        * deleteMultipleErrorTypeCode
        * updateSingleErrorTypeCode
        * updateMultipleErrorTypeCode
4. ErrorMessage
    * Attributes :
        * errorMessageMap
            * key - MMZed_ErrorEngine message type
            * value - MMZed_ErrorEngine message
    * Constructor :
        *
    * methods :
        * isSingleErrorMessageTypeExist
        * isMultipleErrorMessageTypeExist
        * setSingleErrorMessage
        * setMultipleErrorMessage
        * getSingleErrorMessage
        * getMultipleErrorMessage
        * addSingleErrorMessageType
        * addMultipleErrorMessageType
        * deleteSingleErrorMessageType
        * deleteMultipleErrorMessageType
        * updateSingleErrorMessageType
        * updateMultipleErrorMessageType

##Jars used
    * log4j version 1.2.17

##Examples of use

##Project status
* Under construction

##Sources

##Other information