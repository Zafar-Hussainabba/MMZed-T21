# code.src.ValidationEngine
Java programme written for validating using data driven approach and test driven approach

* [Introduction](#introduction)
* [Technologies](#technologies)
* [Illustrations](#illustrations)
* [Examples of use](#examples-of-use)

##Introduction 
The engine will provide a flexibility to validate forms using data driven approach, test driven approach and object-oriented approach.

##Technologies
Engine is created with :
* java version "15.0.2" 2021-01-19
* Java(TM) SE Runtime Environment (build 15.0.2+7-27)
* Java HotSpot(TM) 64-Bit Server VM (build 15.0.2+7-27, mixed mode, sharing)

##Illustrations
Class definition
1. FormValidator.Validator
    * Attributes :
      * patternMap
        * key - Pattern name
        * value - Regex pattern
    * Constructor :
      * Creates default keys and will have regular expression patterns
    * methods : 
      * isKeyExist
        * Checks for the existence of the key
      * isKeySetExist
        * Checks for the existence of multiple keys
      * getSingleKey
        * returns specified key if exists
      * getMultipleKey
        * returns map of key set
      * setSingleValue
        * sets value for a specified key
      * setMultipleValue
        * sets value for a specified set of keys
      * getSingleValue
        * returns value of a specified key
      * getMultipleValue
        * returns value of a specified key set
      * addSingleKey
        * adds specified key to pattern map
      * addMultipleKeys
        * adds specified key set to the pattern map
      * deleteSingleKey
        * deletes specified key from the pattern map
      * deleteMultipleKeys
        * deletes specified set of keys from the pattern map
      * updateSingleKey
        * updates specified key in the pattern map
      * updateMultipleKeys
        * updates set of keys in the pattern map
      * trimString
        * deletes leading and trailing space of a given string
      * lengthOfString
        * returns the length of the string
      * validate
        * applies validation logic for a given object
      * isResultSuccess
        * returns result status
      * setErrorCodeSingle
        * sets error code in error map
      * setErrorCodeMultiple
        * sets multiple error code in error map
      * getErrorCodeSingle
        * returns specified error code from error map
      * getErrorCodeMultiple
        * returns error set from error map
      * setHelpCodeSingle
        * sets help code in help map
      * setHelpCodeMultiple
        * sets help code set in help map
      * getHelpCodeSingle
        * returns help code from help map
      * getHelpCodeMultiple
        * returns help code set from help map
      * objectProcessInformation
        * stores information of the last object processed
      * setDefaultSequence
        * sets default sequence for validation
      * updateDefaultSequence
        * updates the default sequence given for validation
   
2. Jars used
   * log4j version 1.2.17

##Examples of use

##Project status
   * Under construction

##Sources

##Other information