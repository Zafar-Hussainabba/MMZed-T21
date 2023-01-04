#Java package information are set here 
JAVA_COMMON_ATTRIBUTES_FILE_NAME=common_attributes.sh
JAVA_COMMON_ATTRIBUTES_FILE_PATH=$HOME/MMZed-T21/projects/common/scripts

#Taking java package defaults 
source /$JAVA_COMMON_ATTRIBUTES_FILE_PATH/$JAVA_COMMON_ATTRIBUTES_FILE_NAME

#JAR file name for json parser is specified here
JASON_PARSER_FILE_NAME=json-sample-1.1.jar

#Path for jason parser JAR file is specified here
JASON_PARSER_JAR_DIR=$PRG_HOME/common/code/jars

#jason parser JAR file is specified here
JSON_PARSER_JAR_FILE=$JASON_PARSER_JAR_DIR/$JSON_PARSER_FILE_NAME

#Path for java file to compile is specified here
JAVA_FILE_DIR=$PRG_HOME/common/code/src/ConstantDefaults

#Specifying classpath
CLASSPATH=$CLASSPATH:$LOG4J_JAR_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR:$JASON_PARSER_JAR_DIR

export CLASSPATH PATH

#Compiling specified java file
$ECHO "compiling ConstantsDefaults..."
$JAVAC $JAVA_FILE_DIR/PropertiesDirectory.java $JAVA_FILE_DIR/Test_PropertiesDirectory.java
