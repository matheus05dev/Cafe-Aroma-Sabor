package com.projeto.CafeAromaESabor.TestePagesController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class TestePagesController {
    @GetMapping("/home")
    public String Teste(){
        return "home";
    }
    @GetMapping("/login")
    public String Teste1(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String Teste2(){
        return "dashboard";
    }

    @GetMapping("/produtos")
    public String Teste3(){
        return "produtos";
    }

    @GetMapping("/movimentacao")
    public String Teste4(){
        return "movimentacao";
    }

    @GetMapping("/usuarios")
    public String Teste5(){
        return "usuarios";
    }

    @GetMapping("/historico")
    public String Teste6(){
        return "historico";
    }

    @GetMapping("/alertas")
    public String Teste7(){
        return "alertas";
    }

}
