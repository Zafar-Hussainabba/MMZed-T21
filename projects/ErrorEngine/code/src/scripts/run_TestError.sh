#Java package information are set here 
JAVA_COMMON_ATTRIBUTES_FILE_NAME=common_attributes.sh
JAVA_COMMON_ATTRIBUTES_FILE_PATH=$HOME/projects/common/scripts

#Taking java package defaults 
source /$JAVA_COMMON_ATTRIBUTES_FILE_PATH/$JAVA_COMMON_ATTRIBUTES_FILE_NAME

LOG4J_PROPERTY_FILE_PATH=$PRG_HOME/ErrorEngine/conf/log4j
LOG4J_PROPERTY_FILE=$LOG4J_PROPERTY_FILE_PATH

#Path for java file to compile is specified here
JAVA_FILE_DIR=$PRG_HOME/ErrorEngine/code/src/Common_Errors

#Specifying classpath
CLASSPATH=$CLASSPATH:$JAVA_FILE_DIR:$LOG4J_JAR_FILE:$LOG4J_PROPERTY_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR

export CLASSPATH PATH

$ECHO "[PATH -> Begin]"
$ECHO "Classpath is ............: [CLASSPATH] -> [$CLASSPATH]"
$ECHO "Path is .................: [PATH] -> [$PATH]"
$ECHO "[PATH -> End]"

$JAVA Test_Common_Error
