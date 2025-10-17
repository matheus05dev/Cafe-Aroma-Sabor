package com.projeto.CafeAromaESabor.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Getter
@Setter
public class LoginController {
    @GetMapping("/")
        public String login() {
            return "login";
        }
}
