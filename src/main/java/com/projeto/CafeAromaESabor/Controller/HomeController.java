package com.projeto.CafeAromaESabor.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
