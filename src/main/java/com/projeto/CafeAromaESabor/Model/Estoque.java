package com.projeto.CafeAromaESabor.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    private int quantidadeAtual;

    @NotBlank
    private int estoqueMinimo;

    @NotBlank
    private String dataValidade;

    @OneToOne
    private Produto produto;

    //Verifica o nível do estoque e retorna uma mensagem de aviso se estiver baixo.

    public String getAvisoEstoque() {
        if (this.quantidadeAtual <= this.estoqueMinimo) {
            String nomeProduto = (this.produto != null) ? this.produto.toString() : "Produto não identificado";
            return "Aviso: Estoque baixo para o produto " + nomeProduto + 
                   ". Quantidade atual: " + this.quantidadeAtual + 
                   ", Mínimo necessário: " + this.estoqueMinimo;
        }
        return null; // Sem aviso se o estoque estiver ok.
    }
}
