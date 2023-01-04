
JAVAC=`which javac`
#ECHO=`which echo`
JAVA=`which java`

#Project path is specified here
PRG_HOME=$HOME/MMZed-T21/projects

#JAR file names common across the project are specified here
LOG4J_FILE_NAME=log4j-1.2.17.jar

#LOG4J_PROPERTY_FILE_NAME=log4j_common.properties


#Path for JAR files common through the project are specified here
COMMON_JAVA_JAR_DIR=$PRG_HOME/common/code/jars

#JAR files for the project are specified here
LOG4J_JAR_FILE=$COMMON_JAVA_JAR_DIR/$LOG4J_FILE_NAME


echo "java compiler is ...............: [JAVAC] -> [$JAVAC]"
echo "JVM is .........................: [JAVA] -> [$JAVA]"

echo "[DIRECTORY -> Begin]"
echo "HOME DIRECTORY is ..............: [HOME] -> [$HOME]"
echo "PROJECT DIRECTORY is ...........: [PRG_HOME] -> [$PRG_HOME]"
echo "COMMON JAR FILES DIRECTORY is ..: [COMMON_JAVA_JAR_DIR] -> [$COMMON_JAVA_JAR_DIR]"
echo "[DIRECTORY -> End]"

echo "[COMMON JAR FILES -> Begin]"
echo "LOG4J ...................: [LOG4J_FILE_NAME] -> [$LOG4J_FILE_NAME]"
echo "[COMMON JAR FILES -> End]"
