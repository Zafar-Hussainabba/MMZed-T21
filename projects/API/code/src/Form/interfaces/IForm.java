package code.src.Form.interfaces;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface IForm {
    public void init() throws IOException, ParseException;
    public void pre_process();
    public void process();
    public void post_process();
}
