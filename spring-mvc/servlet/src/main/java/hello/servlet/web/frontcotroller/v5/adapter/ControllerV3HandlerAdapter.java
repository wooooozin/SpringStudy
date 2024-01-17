package hello.servlet.web.frontcotroller.v5.adapter;

import hello.servlet.web.frontcotroller.ModelView;
import hello.servlet.web.frontcotroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return false;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
