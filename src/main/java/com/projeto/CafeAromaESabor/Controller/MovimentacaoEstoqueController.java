package com.projeto.CafeAromaESabor.Controller;

import com.projeto.CafeAromaESabor.Model.Estoque;
import com.projeto.CafeAromaESabor.Model.MovimentacaoEstoque;
import com.projeto.CafeAromaESabor.Model.Produto;
import com.projeto.CafeAromaESabor.Model.TipoMovimento;
import com.projeto.CafeAromaESabor.Repository.EstoqueRepository;
import com.projeto.CafeAromaESabor.Repository.MovimentacaoEstoqueRepository;
import com.projeto.CafeAromaESabor.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class MovimentacaoEstoqueController {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping("/movimentacao")
    public String novaMovimentacao(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        List<MovimentacaoEstoque> movimentacoes = movimentacaoEstoqueRepository.findAll();
        model.addAttribute("movimentacaoEstoque", new MovimentacaoEstoque());
        model.addAttribute("produtos", produtos);
        model.addAttribute("tiposMovimento", TipoMovimento.values());
        model.addAttribute("movimentacoes", movimentacoes);
        return "movimentacao";
    }

    @PostMapping("/movimentacao/salvar")
    public String salvarMovimentacao(@ModelAttribute MovimentacaoEstoque movimentacaoEstoque, Model model, RedirectAttributes attributes) {
        Produto produto = movimentacaoEstoque.getProduto();
        if (produto == null || produto.getId() == null) {
            model.addAttribute("mensagem", "Produto não selecionado.");
            List<Produto> produtos = produtoRepository.findAll();
            List<MovimentacaoEstoque> movimentacoes = movimentacaoEstoqueRepository.findAll();
            model.addAttribute("produtos", produtos);
            model.addAttribute("tiposMovimento", TipoMovimento.values());
            model.addAttribute("movimentacoes", movimentacoes);
            return "movimentacao";
        }

        Optional<Estoque> estoqueOptional = estoqueRepository.findByProduto(produto);
        Estoque estoque;

        if (estoqueOptional.isPresent()) {
            estoque = estoqueOptional.get();
        } else {
            estoque = new Estoque();
            estoque.setProduto(produto);
            estoque.setQuantidadeAtual(0);
            estoque.setEstoqueMinimo(10);
        }

        int quantidadeMovimentada = movimentacaoEstoque.getQuantidade();

        if (movimentacaoEstoque.getTipoMovimento() == TipoMovimento.ENTRADA) {
            estoque.setQuantidadeAtual(estoque.getQuantidadeAtual() + quantidadeMovimentada);
        } else if (movimentacaoEstoque.getTipoMovimento() == TipoMovimento.SAIDA) {
            if (estoque.getQuantidadeAtual() < quantidadeMovimentada) {
                model.addAttribute("mensagem", "Quantidade em estoque insuficiente para a saída.");
                List<Produto> produtos = produtoRepository.findAll();
                List<MovimentacaoEstoque> movimentacoes = movimentacaoEstoqueRepository.findAll();
                model.addAttribute("produtos", produtos);
                model.addAttribute("tiposMovimento", TipoMovimento.values());
                model.addAttribute("movimentacoes", movimentacoes);
                return "movimentacao";
            }
            estoque.setQuantidadeAtual(estoque.getQuantidadeAtual() - quantidadeMovimentada);
        }

        estoqueRepository.save(estoque);
        movimentacaoEstoqueRepository.save(movimentacaoEstoque);

        attributes.addFlashAttribute("mensagem", "Movimentação registrada com sucesso!");
        return "redirect:/movimentacao";
    }
}
