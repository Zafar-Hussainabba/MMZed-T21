#taking json reader information
JSON_READER_ATTRIBUTES_FILE_NAME=compile_JSONReader.sh
JSON_READER_ATTRIBUTES_FILE_PATH=$HOME/projects/common/JSON_Reader/code/src/scripts
source /$JSON_READER_ATTRIBUTES_FILE_PATH/$JSON_READER_ATTRIBUTES_FILE_NAME

#Path for json reader class
JSONReader_File_Path=$PRG_HOME/common/JSON_Reader/code/src/JSON_Reader

#Path for java file to compile is specified here
JAVA_FILE_DIR=$PRG_HOME/ErrorEngine/code/src/Common_Errors

#Specifying classpath
CLASSPATH=$CLASSPATH:$LOG4J_JAR_FILE

#Speciying path
PATH=$PATH:$COMMON_JAVA_JAR_DIR

export CLASSPATH PATH

#Compiling specified java file
echo "compiling Test_Common_Error.java file..."
$JAVAC $JSONReader_File_Path/JSON_FileReader.java $JAVA_FILE_DIR/Common_Error.java $JAVA_FILE_DIR/Test_Common_Error.java
