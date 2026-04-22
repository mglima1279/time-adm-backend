package com.imposto.adm.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imposto.adm.dto.ProdutoRequest;
import com.imposto.adm.dto.ProdutoResponse;
import com.imposto.adm.services.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequest request) {
        return ResponseEntity.ok(ProdutoResponse.fromEntity(produtoService.create(request)));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> getAll() {
        return ResponseEntity.ok(produtoService.getAll().stream().map(ProdutoResponse::fromEntity).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ProdutoResponse.fromEntity(produtoService.getById(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponse> updateById(@PathVariable Long id, @RequestBody ProdutoRequest request) {
        return ResponseEntity.ok(ProdutoResponse.fromEntity(produtoService.updateById(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        produtoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
