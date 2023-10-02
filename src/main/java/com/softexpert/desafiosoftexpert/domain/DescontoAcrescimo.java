package com.softexpert.desafiosoftexpert.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescontoAcrescimo {
    private BigDecimal valorEntrega;
    private BigDecimal valorDescontoEmReal;
    private BigDecimal valorDescontoEmPorcantagem;
    private BigDecimal valorAcrescimoEmReal;
    private BigDecimal valorAcrescimoEmPorcentagem;
}
