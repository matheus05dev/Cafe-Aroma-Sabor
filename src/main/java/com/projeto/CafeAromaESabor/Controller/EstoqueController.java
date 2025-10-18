package com.projeto.CafeAromaESabor.Controller;

import com.projeto.CafeAromaESabor.Model.Estoque;
import com.projeto.CafeAromaESabor.Repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping("/estoque")
    public String estoque(Model model){
        List<Estoque> estoques = estoqueRepository.findAll();
        model.addAttribute("estoques", estoques);

        // Calculate summary statistics
        long totalProdutosEmEstoque = estoques.stream().mapToInt(Estoque::getQuantidadeAtual).sum();
        long produtosComEstoqueMinimo = estoques.stream()
                .filter(e -> e.getQuantidadeAtual() <= e.getEstoqueMinimo())
                .count();
        long produtosComValidadeProxima = estoques.stream()
                .filter(e -> e.getDataValidade() != null && e.getDataValidade().isBefore(LocalDate.now().plusMonths(3)))
                .count();

        model.addAttribute("totalProdutosEmEstoque", totalProdutosEmEstoque);
        model.addAttribute("produtosComEstoqueMinimo", produtosComEstoqueMinimo);
        model.addAttribute("produtosComValidadeProxima", produtosComValidadeProxima);

        return "estoque";
    }

}
