package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.apache.taglibs.standard.lang.jstl.ImplicitObjects.createParamMap;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }


    @Override
    public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(req);
        ModelView mv = controller.process(paramMap);
        return mv;

    }

    private Map<String,String> createParamMap(HttpServletRequest req) {
        Map<String,String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }


}
