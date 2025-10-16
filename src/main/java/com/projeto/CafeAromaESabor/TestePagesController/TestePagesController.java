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
    @GetMapping("")
    public String Teste1(){
        return "login";
    }

    @GetMapping("/estoque")
    public String Teste2(){
        return "estoque";
    }

    @GetMapping("/produtos")
    public String Teste3(){
        return "produtos-lista";
    }

    @GetMapping("/movimentacao")
    public String Teste4(){
        return "movimentacao";
    }

    @GetMapping("/usuarios")
    public String Teste5(){
        return "usuarios-lista";
    }

    @GetMapping("/historico")
    public String Teste6(){
        return "historico";
    }

    @GetMapping("/alertas")
    public String Teste7(){
        return "alertas";
    }

    @GetMapping("/produtos/criar")
    public String Teste8(){
        return "criar-produtos";
    }

    @GetMapping("/usuarios/criar")
    public String Teste9(){
        return "criar-usuario";
    }

    @GetMapping("/usuarios/editar")
    public String Teste10(){
        return "editar-usuario";
    }

    @GetMapping("/produtos/editar")
    public String Teste11(){
        return "editar-produtos";
    }

}
