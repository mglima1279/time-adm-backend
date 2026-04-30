package com.imposto.adm.services;

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
