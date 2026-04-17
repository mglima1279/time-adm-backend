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

    @Column(nullable = false, length = 255, name = "nome")
    private String nome;

    @Column(length = 255, name = "caracteristicas")
    private String caracteristicas;

    @Column(nullable = false, precision = 10, scale = 2, name = "valor_und")
    private BigDecimal valorUnd;

    @Column(nullable = false, length = 10, name = "und")
    private String und;

    @Column(nullable = false, length = 10, name = "tipo")
    private String tipo;

    @Column(nullable = false, precision = 10, scale = 3, name = "qtd")
    private Double qtd;

    @Column(nullable = false, precision = 12, scale = 2, name = "valor_total")
    private BigDecimal valorTotal;

    @Column(nullable = false, precision = 12, scale = 2, name = "valor_imposto")
    private BigDecimal valorImposto;

    @Column(nullable = false, precision = 12, scale = 2, name = "valor_final")
    private BigDecimal valorFinal;
}
