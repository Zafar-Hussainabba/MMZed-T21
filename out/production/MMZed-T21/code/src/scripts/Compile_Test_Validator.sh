ECHO=`which echo`
#Java package information are set here
JAVA_COMMON_ATTRIBUTES_FILE_NAME=common_attributes.sh
JAVA_COMMON_ATTRIBUTES_FILE_PATH=$HOME/MMZed-T21/projects/common/scripts



echo "java common attributes file name: [JAVA_COMMON_ATTRIBUTES_FILE_NAME] -> [$JAVA_COMMON_ATTRIBUTES_FILE_NAME]"
echo "java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"
#Taking java package defaults
SOURCE_FILENAME=/$JAVA_COMMON_ATTRIBUTES_FILE_PATH/$JAVA_COMMON_ATTRIBUTES_FILE_NAME

echo "BEFORE SOURCE PROJECT DIRECTORY is ...........: [PRG_HOME] -> [$PRG_HOME]"
echo "java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"
source $SOURCE_FILENAME

echo "After Source java common attributes file name: [JAVA_COMMON_ATTRIBUTES_FILE_NAME] -> [$JAVA_COMMON_ATTRIBUTES_FILE_NAME]"
echo "After source java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"
#read
#java file directory is specified here
echo "After source java common attributes file path: [JAVA_COMMON_ATTRIBUTES_FILE_PATH] -> [$JAVA_COMMON_ATTRIBUTES_FILE_PATH]"

echo "AFTER SOURCE PROJECT DIRECTORY is ...........: [PRG_HOME] -> [$PRG_HOME]"

JAVA_FILE_DIR=$PRG_HOME/ValidationEngine/code/src/Validator
JAVA_CLASS_DIR=$PRG_HOME/ValidationEngine/code/classes

#REGEX jar information is specified here
REGEX_JAR_FILE_DIR=$PRG_HOME/ValidationEngine/code/jars
REGEX_JAR_FILE_NAME=regex.jar
REGEX_JAR_FILE=$GSON_PARSER_JAR_FILE_DIR/$GSON_PARSER_JAR_FILE_NAME

echo "VALIDATOR JAR FILES -> BEGIN"
echo "Regex jar file is ........: [JSON_PARSER_JAR_FILE] -> [$REGEX_JAR_FILE_NAME]"
echo "VALIDATOR JAR FILES -> END"

#Specifying classpath
CLASSPATH=$CLASSPATH:$JAVA_FILE_DIR:$LOG4J_JAR_FILE:$REGEX_JAR_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR:$REGEX_JAR_FILE

echo "VALIDATOR PATH -> BEGIN"
echo "Classpath is ...................: [CLASSPATH] -> [$CLASSPATH]"
echo "Path is ........................: [PATH] -> [$PATH]"
echo "VALIDATOR PATH -> END"

export CLASSPATH PATH

#Java class directories are specified here
TEST_VALIDATOR_CLASS=$JAVA_FILE_DIR

#Java files
JAVA_FILE1=$TEST_VALIDATOR_CLASS/Test_Validator.java
JAVA_FILE2=$TEST_VALIDATOR_CLASS/Validator.java


$JAVAC -d "$JAVA_CLASS_DIR" -classpath $LOG4J_JAR_FILE:$REGEX_JAR_FILE $JAVA_FILE2 $JAVA_FILE1
