package kyh.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map,@RequestParam(value="username",required =false) String username) {
        map.put("hello", "欢迎进入HTML页面");
        map.put("username", username);
        return "/index";
    }
    
    @RequestMapping("/demo1")
    public String demo1(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "/demo1";
    }
    
}
