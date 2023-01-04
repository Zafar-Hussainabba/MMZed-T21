package Interfaces;

import AttributeControllers.Controller;
import AttributeControllers.ProcessMap;
import AttributeControllers.ResultMap;
import AttributeControllers.SystemErrors;
import code.src.BaseAttributes.system.SystemAttributes;

public interface ICommonAttributes {
    public SystemAttributes systemAttributes = new SystemAttributes();
    public Controller controller = new Controller();
    public ProcessMap processMap = new ProcessMap();
    //public SystemErrors systemErrors = new SystemErrors();
    public ResultMap resultMap = new ResultMap();

}
