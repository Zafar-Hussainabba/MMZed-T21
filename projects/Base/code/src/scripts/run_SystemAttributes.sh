#Java package information are set here
JAVA_COMMON_ATTRIBUTES_FILE_NAME=common_attributes.sh
JAVA_COMMON_ATTRIBUTES_FILE_PATH=$HOME/MMZed-T21/projects/common/scripts

#Taking java package defaults
source /$JAVA_COMMON_ATTRIBUTES_FILE_PATH/$JAVA_COMMON_ATTRIBUTES_FILE_NAME

#Path for java file to RUN is specified here
JAVA_FILE_DIR=$PRG_HOME/Base/code/src/BaseAttributes
JAVA_CLASS_DIR=$PRG_HOME/Base/code/classes

#json parser jar information is specified here
JSON_PARSER_JAR_FILE_DIR=$PRG_HOME/common/JSON_Reader/code/jars
JSON_PARSER_JAR_FILE_NAME=json-simple-1.1.jar
JSON_PARSER_JAR_FILE=$JSON_PARSER_JAR_FILE_DIR/$JSON_PARSER_JAR_FILE_NAME

#GSON jar information is specified here
GSON_PARSER_JAR_FILE_DIR=$PRG_HOME/Base/code/jars
GSON_PARSER_JAR_FILE_NAME=gson-2.2.2.jar
GSON_PARSER_JAR_FILE=$GSON_PARSER_JAR_FILE_DIR/$GSON_PARSER_JAR_FILE_NAME

#Specifying classpath
#set CLASSPATH = ""
CLASSPATH=$CLASSPATH:$JAVA_CLASS_DIR:$JAVA_FILE_DIR:$LOG4J_JAR_FILE:$JSON_PARSER_JAR_FILE:$LOG4J_PROPERTY_FILE:$GSON_PARSER_JAR_FILE:$LOG4J_PROPERTY_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR:$JSON_PARSER_JAR_FILE_DIR:$GSON_PARSER_JAR_FILE_DIR:$LOG4J_PROPERTY_FILE_DIR

export CLASSPATH PATH

echo "[PATH -> Begin]"
echo "Classpath is ............: [CLASSPATH] -> [$CLASSPATH]"
echo "Path is .................: [PATH] -> [$PATH]"
echo "[PATH -> End]"

#Java files
JAVA_COMPILE_CLASS_FILE=code.src.BaseAttributes.system.Test_SystemAttributes

$JAVA $JAVA_COMPILE_CLASS_FILE



