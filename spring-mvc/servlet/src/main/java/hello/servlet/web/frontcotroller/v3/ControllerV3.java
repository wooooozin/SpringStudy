package hello.servlet.web.frontcotroller.v3;

import hello.servlet.web.frontcotroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);

}
