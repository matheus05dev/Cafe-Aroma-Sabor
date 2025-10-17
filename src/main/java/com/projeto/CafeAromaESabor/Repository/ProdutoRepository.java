package com.projeto.CafeAromaESabor.Repository;

import com.projeto.CafeAromaESabor.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
