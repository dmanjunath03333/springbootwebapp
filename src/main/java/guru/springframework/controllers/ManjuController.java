package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManjuController {
    @RequestMapping("/manju")
    String index(){
        return " Wellcome Hello All Good Morning!";
    }
}
