package com.imposto.adm.dto;

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
    private String valorUnd;
    private String und;
    private Long qtd;
    private String valorTotal;
    private String valorImposto;
    private String valorFinal;

    public static ProdutoResponse fromEntity(Produto produto) {
        ProdutoResponse response = new ProdutoResponse();
        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setCaracteristicas(produto.getCaracteristicas());
        response.setValorUnd(produto.getValorUnd().toString());
        response.setUnd(produto.getUnd());
        response.setQtd(produto.getQtd());
        return response;
    }
}

/* Produto;
o Valor unitário do produto;
o Unidade
o Um campo input para informar a quantidade;
o Valor Total do item;
o Valor imposto;
o Valor final. */
