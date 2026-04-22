package com.imposto.adm.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imposto.adm.dto.ProdutoRequest;
import com.imposto.adm.entities.Produto;
import com.imposto.adm.repositories.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Produto create(ProdutoRequest request) {
        Produto produto = request.toProduto();

        calcValues(produto);

        return produtoRepository.save(produto);
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto updateById(Long id, ProdutoRequest request) {
        Produto produto = getById(id);
        
        produto.setQtd(request.getQtd());

        calcValues(produto);
        
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    private void calcValues(Produto produto) {
        produto.setValorTotal(produto.getValorUnd().multiply(BigDecimal.valueOf(produto.getQtd())));
        switch (produto.getTipo()) {
            case "1" -> produto.setValorImposto(BigDecimal.ZERO);
            case "2" -> produto.setValorImposto(produto.getValorTotal().multiply(BigDecimal.valueOf(0.08)));
            case "3" -> produto.setValorImposto(produto.getValorTotal().multiply(BigDecimal.valueOf(0.10)));
            case "4" -> produto.setValorImposto(produto.getValorTotal().multiply(BigDecimal.valueOf(0.12)));
            case "5" -> produto.setValorImposto(produto.getValorTotal().multiply(BigDecimal.valueOf(0.17)));
            default -> throw new IllegalArgumentException("Tipo de produto inválido: " + produto.getTipo());
        }
        produto.setValorFinal(produto.getValorTotal().add(produto.getValorImposto()));
    }
}
