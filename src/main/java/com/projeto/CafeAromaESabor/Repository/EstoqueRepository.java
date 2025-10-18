package com.projeto.CafeAromaESabor.Repository;

import com.projeto.CafeAromaESabor.Model.Estoque;
import com.projeto.CafeAromaESabor.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByProduto(Produto produto);
}
