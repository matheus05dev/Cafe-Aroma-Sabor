package com.projeto.CafeAromaESabor.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private int quantidadeAtual;

    private int estoqueMinimo;

    private LocalDate dataValidade;

    @OneToOne
    private Produto produto;

    //Verifica o nível do estoque e retorna uma mensagem de aviso se estiver baixo.

    public String getAvisoEstoque() {
        if (this.quantidadeAtual <= this.estoqueMinimo) {
            String nomeProduto = (this.produto != null) ? this.produto.getNome() : "Produto não identificado";
            return "ALERTA: O estoque do produto '" + nomeProduto + "' está abaixo do mínimo! Quantidade atual: " + this.quantidadeAtual + ", Mínimo: " + this.estoqueMinimo + ". Por favor, reponha o estoque.";
        }
        return null; // Sem aviso se o estoque estiver ok.
    }
}
