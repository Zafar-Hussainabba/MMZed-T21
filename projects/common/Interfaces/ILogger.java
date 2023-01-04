package Interfaces;

import MMZed_Errors.Test_MMZed_ErrorEngine;
import code.src.Form.FormF1.Test_FormF1;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public interface ILogger {
    static final Logger logger = LogManager.getLogger( Test_FormF1.class );
}
