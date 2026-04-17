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
public class ProdutoRequest {
    private String nome;
    private String caracteristicas;
    private String valorUnd;
    private String und;
    private String tipo;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setCaracteristicas(this.caracteristicas);
        produto.setValorUnd(new java.math.BigDecimal(this.valorUnd));
        produto.setUnd(this.und);
        produto.setTipo(this.tipo);
        produto.setQtd(1L);
        return produto;
    }
}
