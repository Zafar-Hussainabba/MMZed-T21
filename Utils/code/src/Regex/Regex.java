package code.src.Regex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{
    public static final Logger logger = LogManager.getLogger( Regex.class );

    private String inputString;
    private String regexPattern;

    // Creating a compiled regular expression
    Pattern compiledPattern = Pattern.compile(regexPattern);

    // Creating a matcher object to input string.
    Matcher patternMatcher = compiledPattern.matcher(inputString);

    
    //private Pattern

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getRegexPattern() {
        return regexPattern;
    }

    public void setRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public static void main(String[] args)
    {
    }
}
