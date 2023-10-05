package com.softexpert.desafiosoftexpert.domain;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class Pedido {


    /*@Min(value = 1, message = "O valor deve ser maior que zero")
    public static BigDecimal valorTotalPedido;*/

    @NotNull
    private String nomeCliente;

    @NotNull
    @Min(value = 1, message = "O valor deve ser maior que zero")
    private BigDecimal valorPedido;
}
