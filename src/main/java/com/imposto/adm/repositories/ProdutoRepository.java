package com.imposto.adm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imposto.adm.entities.Produto;

public interface ProdutoRepository extends  JpaRepository<Produto, Long> {
}
