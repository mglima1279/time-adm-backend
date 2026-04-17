package com.imposto.adm.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "caracteristicas")
    private String caracteristicas;

    @Column(name = "valor_und")
    private BigDecimal valorUnd;

    @Column(name = "und")
    private String und;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "qtd")
    private long qtd;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "valor_imposto")
    private BigDecimal valorImposto;

    @Column(name = "valor_final")
    private BigDecimal valorFinal;
}
