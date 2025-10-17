package com.projeto.CafeAromaESabor.Controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Getter
@Setter
@NoArgsConstructor
public class EstoqueController {

    @GetMapping("/estoque")
    public String estoque(){
        return "estoque";
    }



}
