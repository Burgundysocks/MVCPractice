package hello.servlet.web.frontcontroller;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ModelView {
    private String viewname;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewname) {
        this.viewname = viewname;
    }


}
