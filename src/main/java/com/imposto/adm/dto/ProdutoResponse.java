package com.imposto.adm.dto;

import java.math.BigDecimal;

import com.imposto.adm.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String caracteristicas;
    private BigDecimal valorUnd;
    private String und;
    private Long qtd;
    private String tipo;

    public static ProdutoResponse fromEntity(Produto produto) {
        ProdutoResponse response = new ProdutoResponse();
        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setCaracteristicas(produto.getCaracteristicas());
        response.setValorUnd(produto.getValorUnd());
        response.setUnd(produto.getUnd());
        response.setQtd(produto.getQtd());
        response.setTipo(produto.getTipo());
        return response;
    }
}
