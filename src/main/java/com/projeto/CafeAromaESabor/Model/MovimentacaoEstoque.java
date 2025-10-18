package com.projeto.CafeAromaESabor.Model;

import jakarta.persistence.*;
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
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimento tipoMovimento;

    @Column(nullable = false)
    private int quantidade;

    private String lote;

    @Column(nullable = true)
    private LocalDate dataValidade;

    @Column(nullable = false)
    private LocalDate dataMovimentacao;

    private String responsavel;

    @PrePersist
    protected void onCreate() {
        dataMovimentacao = LocalDate.now();
    }
}
