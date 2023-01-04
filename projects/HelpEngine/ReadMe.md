# HelpEngine
Java programme written for validating using data driven approach and test driven approach

* [Introduction](#introduction)
* [Technologies](#technologies)
* [Illustrations](#illustrations)
* [Jars used](#jars-used)
* [Examples of use](#examples-of-use)

##Introduction
The engine will provide a flexibility to log help messages in an indexed approach.

##Technologies
Engine is created with :
* java version "15.0.2" 2021-01-19
* Java(TM) SE Runtime Environment (build 15.0.2+7-27)
* Java HotSpot(TM) 64-Bit Server VM (build 15.0.2+7-27, mixed mode, sharing)

##Illustrations
Class definition
1. Help
    * Attributes :
        * helpMap
            * key - Help code
            * value - Help data
    * Constructor :
        *
    * methods :
        * isSingleHelpCodeExist
        * isMultipleHelpCodeExist
        * setSingleHelpCodeType
        * setMultipleHelpCodeType
        * getSingleHelpCode
        * getMultipleHelpCode
        * addSingleHelpCode
        * addMultipleHelpCode
        * deleteSingleHelpCode
        * deleteMultipleHelpCode
        * updateSingleHelpCode
        * updateMultipleHelpCode
2. HelpType
    * Attributes :
        * helpTypeMap
            * key - Help type
            * value - Help type data
    * Constructor :
        *
    * methods :
        * isSingleHelpTypeExist
        * isMultipleHelpTypeExist
        * setSingleHelpTypeData
        * setMultipleHelpTypeData
        * getSingleHelpTypeData
        * getMultipleHelpTypeData
        * addSingleHelpType
        * addMultipleHelpType
        * deleteSingleHelpType
        * deleteMultipleHelpType
        * updateSingleHelpType
        * updateMultipleHelpType
3. HelpTypeCode
    * Attributes :
        * helpTypeCodeMap
            * key - Help type code
            * value - Help type code data
    * Constructor :
        *
    * methods :
        * isSingleHelpTypeCodeExist
        * isMultipleHelpTypeCodeExist
        * setSingleHelpTypeCodeData
        * setMultipleHelpTypeCodeData
        * getSingleHelpTypeCodeData
        * getMultipleHelpTypeCodeData
        * addSingleHelpTypeCode
        * addMultipleHelpTypeCode
        * deleteSingleHelpTypeCode
        * deleteMultipleHelpTypeCode
        * updateSingleHelpTypeCode
        * updateMultipleHelpTypeCode
4. HelpMessage
    * Attributes :
        * helpMessageMap
            * key - Help message type
            * value - Help message
    * Constructor :
        *
    * methods :
        * isSingleHelpMessageTypeExist
        * isMultipleHelpMessageTypeExist
        * setSingleHelpMessage
        * setMultipleHelpMessage
        * getSingleHelpMessage
        * getMultipleHelpMessage
        * addSingleHelpMessageType
        * addMultipleHelpMessageType
        * deleteSingleHelpMessageType
        * deleteMultipleHelpMessageType
        * updateSingleHelpMessageType
        * updateMultipleHelpMessageType

##Jars used
    * log4j version 1.2.17

##Examples of use

##Project status
* Under construction

##Sources

##Other information