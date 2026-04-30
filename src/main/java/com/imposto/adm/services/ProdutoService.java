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

        if (produto.getQtd() <= 0 || produto.getValorUnd().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Quantidade e valor unitário devem ser maiores que zero");
        }
        
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new RuntimeException("O nome do produto é obrigatório");
        }

        if (produto.getUnd() == null || produto.getUnd().isEmpty()) {
            throw new RuntimeException("A unidade de medida é obrigatória");
        }

        if (produto.getTipo() == null || produto.getTipo().isEmpty()) {
            throw new RuntimeException("O tipo do produto é obrigatório");
        }

        return produtoRepository.save(produto);
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto patchById(Long id, ProdutoRequest request) {
        Produto produto = getById(id);

        produto.setQtd(request.getQtd());

        return produtoRepository.save(produto);
    }
    
    public Produto updateById(Long id, ProdutoRequest request) {
        Produto produto = getById(id);

        if (request.getNome() != null) {
            produto.setNome(request.getNome());
        }

        if (request.getCaracteristicas() != null) {
            produto.setCaracteristicas(request.getCaracteristicas());
        }

        if (request.getValorUnd() != null) {
            produto.setValorUnd(request.getValorUnd());
        }

        if (request.getUnd() != null) {
            produto.setUnd(request.getUnd());
        }

        if (request.getTipo() != null) {
            produto.setTipo(request.getTipo());
        }

        return produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
