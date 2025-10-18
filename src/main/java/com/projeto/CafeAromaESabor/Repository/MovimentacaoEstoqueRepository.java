package com.projeto.CafeAromaESabor.Repository;

import com.projeto.CafeAromaESabor.Model.MovimentacaoEstoque;
import com.projeto.CafeAromaESabor.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {
    Optional<MovimentacaoEstoque> findTopByProdutoOrderByDataValidadeAsc(Produto produto);
    
    @Query("SELECT MIN(me.dataValidade) FROM MovimentacaoEstoque me WHERE me.produto = :produto AND me.dataValidade IS NOT NULL")
    Optional<LocalDate> findEarliestDataValidadeByProduto(Produto produto);
}
