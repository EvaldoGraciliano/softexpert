package com.softexpert.desafiosoftexpert.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescontoAcrescimo {

    @NotNull
    @PositiveOrZero
    private BigDecimal valorEntrega;

    @NotNull
    @PositiveOrZero
    private BigDecimal valorDescontoEmReal;

    @NotNull
    @PositiveOrZero
    private BigDecimal valorDescontoEmPorcantagem;

    @NotNull
    @PositiveOrZero
    private BigDecimal valorAcrescimoEmReal;

    @NotNull
    @PositiveOrZero
    private BigDecimal valorAcrescimoEmPorcentagem;
}
