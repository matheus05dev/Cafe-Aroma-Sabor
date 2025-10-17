package com.projeto.CafeAromaESabor.Controller;

import com.projeto.CafeAromaESabor.Model.Produto;
import com.projeto.CafeAromaESabor.Repository.ProdutoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @GetMapping("/produtos/novo")
    public String criarProdutoForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "criar-produto";
    }

    @PostMapping("/produtos/novo")
    public String CriarProduto(Produto produto, RedirectAttributes redirectAttributes) {
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("message", "Produto criado com sucesso!");
        return "redirect:/produtos-lista";
    }

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produtos-lista";
    }

    @GetMapping("/produtos/editar/{id}")
    public String editarProdutoForm(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Produto inválido:" + id));
        model.addAttribute("produto", produto);
        return "editar-produto";
    }

    @PostMapping("/produtos/editar/{id}")
    public String editarProduto(@PathVariable Long id, Produto produto, RedirectAttributes redirectAttributes) {
        Produto ProdutoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Produto inválido:" + id));

        ProdutoExistente.setNome(produto.getNome());
        ProdutoExistente.setMarca(produto.getMarca());
        ProdutoExistente.setCodigoInterno(produto.getCodigoInterno());
        ProdutoExistente.setTipo(produto.getTipo());
        ProdutoExistente.setCodigoInterno(produto.getCodigoInterno());

        produtoRepository.save(ProdutoExistente);
        redirectAttributes.addFlashAttribute("message", "Produto editado com sucesso!");
        return "redirect:/produtos";
    }

    @DeleteMapping("/produtos/apagar/{id}")
    public String deletarProduto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        produtoRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Produto deletado com sucesso!");
        return "redirect:/produtos";
    }
}

