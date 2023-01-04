ECHO=`which echo`
#Java package information are set here 
JAVA_COMMON_ATTRIBUTES_FILE_NAME=common_attributes.sh
JAVA_COMMON_ATTRIBUTES_FILE_PATH=$HOME/MMZed-T21/projects/common/scripts



$ECHO "java common attributes file name: [JAVA_COMMON_ATTRIBUTES_FILE_NAME] -> [$JAVA_COMMON_ATTRIBUTES_FILE_NAME]"
$ECHO "java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"
#Taking java package defaults
SOURCE_FILENAME=/$JAVA_COMMON_ATTRIBUTES_FILE_PATH/$JAVA_COMMON_ATTRIBUTES_FILE_NAME

$ECHO "BEFORE SOURCE PROJECT DIRECTORY is ...........: [PRG_HOME] -> [$PRG_HOME]"
$ECHO "java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"
source $SOURCE_FILENAME

$ECHO "After Source java common attributes file name: [JAVA_COMMON_ATTRIBUTES_FILE_NAME] -> [$JAVA_COMMON_ATTRIBUTES_FILE_NAME]"
$ECHO "After source java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"
#read
#java file directory is specified here
$ECHO "After source java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"

$ECHO "AFTER SOURCE PROJECT DIRECTORY is ...........: [PRG_HOME] -> [$PRG_HOME]"

JAVA_FILE_DIR=$PRG_HOME/Base/code/src/BaseAttributes
JAVA_CLASS_DIR=$PRG_HOME/Base/code/classes

#specifying log4j property file for base attributes
LOG4J_PROPERTY_FILE_DIR=$PRG_HOME/Base/conf/log4j
LOG4J_PROPERTY_FILE_NAME=log4j_BaseAttributes.properties
LOG4J_PROPERTY_FILE=$LOG4J_PROPERTY_FILE_DIR/$LOG4J_PROPERTY_FILE_NAME

#json parser jar information is specified here
JSON_PARSER_JAR_FILE_DIR=$PRG_HOME/common/JSON_Reader/code/jars
JSON_PARSER_JAR_FILE_NAME=json-simple-1.1.jar
JSON_PARSER_JAR_FILE=$JSON_PARSER_JAR_FILE_DIR/$JSON_PARSER_JAR_FILE_NAME

#GSON jar information is specified here
GSON_PARSER_JAR_FILE_DIR=$PRG_HOME/Base/code/jars
GSON_PARSER_JAR_FILE_NAME=gson-2.2.2.jar
GSON_PARSER_JAR_FILE=$GSON_PARSER_JAR_FILE_DIR/$GSON_PARSER_JAR_FILE_NAME

echo "SYSTEM ATTRIBUTES JAR FILES -> BEGIN"
echo "Json parser jar file is ........: [JSON_PARSER_JAR_FILE] -> [$JSON_PARSER_JAR_FILE_NAME]"
echo "Gson parser jar file is ........: [GSON_PARSER_JAR_FILE] -> [$GSON_PARSER_JAR_FILE_NAME]"
echo "SYSTEM ATTRIBUTES JAR FILES -> END"

#Specifying classpath
CLASSPATH=$CLASSPATH:$JAVA_FILE_DIR:$LOG4J_JAR_FILE:$JSON_PARSER_JAR_FILE:$GSON_PARSER_JAR_FILE:$LOG4J_PROPERTY_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR:$JSON_PARSER_JAR_FILE_DIR:$GSON_PARSER_JAR_FILE_DIR:$LOG4J_PROPERTY_FILE_DIR

echo "SYSTEM ATTRIBUTES PATH -> BEGIN"
echo "Classpath is ...................: [CLASSPATH] -> [$CLASSPATH]"
echo "Path is ........................: [PATH] -> [$PATH]"
echo "SYSTEM ATTRIBUTES PATH -> END"

export CLASSPATH PATH

#Java class directories are specified here
BASE_KEYS_CLASS=$JAVA_FILE_DIR/
SYSTEM_KEYS_CLASS=$JAVA_FILE_DIR/system
EXCEPTIONS=$JAVA_FILE_DIR/exceptions
INTERFACES=$JAVA_FILE_DIR/interfaces

#Java files
JAVA_FILE1=$SYSTEM_KEYS_CLASS/Test_SystemAttributes.java
JAVA_FILE2=$SYSTEM_KEYS_CLASS/SystemAttributes.java

#Java Exceptions
JAVA_FILE3=$EXCEPTIONS/KeyNotFoundException.java

#Java Interfaces
JAVA_FILE4=$INTERFACES/IBaseHashMapString.java
JAVA_FILE5=$INTERFACES/IAttributes.java
JAVA_FILE6=$INTERFACES/IMMZedError.java


$JAVAC -d "$JAVA_CLASS_DIR" -classpath $LOG4J_JAR_FILE:$JSON_PARSER_JAR_FILE:$GSON_PARSER_JAR_FILE $JAVA_FILE4 $JAVA_FILE5 $JAVA_FILE6 $JAVA_FILE3 $JAVA_FILE2 $JAVA_FILE1
