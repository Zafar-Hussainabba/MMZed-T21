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

JAVA_FILE_DIR=$PRG_HOME/Base/code/src/HttpRequest
JAVA_CLASS_DIR=$PRG_HOME/Base/code/classes

#Specifying classpath
CLASSPATH=$CLASSPATH:$JAVA_FILE_DIR:$LOG4J_JAR_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR

echo "SYSTEM ATTRIBUTES PATH -> BEGIN"
echo "Classpath is ...................: [CLASSPATH] -> [$CLASSPATH]"
echo "Path is ........................: [PATH] -> [$PATH]"
echo "SYSTEM ATTRIBUTES PATH -> END"

export CLASSPATH PATH

#Java class directories are specified here
HTTP_REQUEST_CLASS=$JAVA_FILE_DIR

#Java files
JAVA_FILE1=$HTTP_REQUEST_CLASS/Test_HttpRequest.java
JAVA_FILE2=$HTTP_REQUEST_CLASS/HttpRequest.java


$JAVAC -d "$JAVA_CLASS_DIR" -classpath $LOG4J_JAR_FILE $JAVA_FILE2 $JAVA_FILE1
