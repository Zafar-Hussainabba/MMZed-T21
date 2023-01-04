#Java package information are set here
JAVA_COMMON_ATTRIBUTES_FILE_NAME=common_attributes.sh
JAVA_COMMON_ATTRIBUTES_FILE_PATH=$HOME/MMZed-T21/projects/common/scripts

#Taking java package defaults
source /$JAVA_COMMON_ATTRIBUTES_FILE_PATH/$JAVA_COMMON_ATTRIBUTES_FILE_NAME

#Path for java file to RUN is specified here
JAVA_FILE_DIR=$PRG_HOME/ValidationEngine/code/src/Validator
JAVA_CLASS_DIR=$PRG_HOME/ValidationEngine/code/classes

#REGEX jar information is specified here
REGEX_JAR_FILE_DIR=$PRG_HOME/ValidationEngine/code/jars
REGEX_JAR_FILE_NAME=regex.jar
REGEX_JAR_FILE=$GSON_PARSER_JAR_FILE_DIR/$GSON_PARSER_JAR_FILE_NAME

#Specifying classpath
CLASSPATH=$CLASSPATH:$JAVA_CLASS_DIR:$JAVA_FILE_DIR:$LOG4J_JAR_FILE:$REGEX_JAR_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR:$REGEX_JAR_FILE

export CLASSPATH PATH

echo "[PATH -> Begin]"
echo "Classpath is ............: [CLASSPATH] -> [$CLASSPATH]"
echo "Path is .................: [PATH] -> [$PATH]"
echo "[PATH -> End]"

#Java files
JAVA_COMPILE_CLASS_FILE=Test_Validator

$JAVA $JAVA_COMPILE_CLASS_FILE



