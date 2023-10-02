package com.softexpert.desafiosoftexpert.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
public class Pedido {
    public static BigDecimal valorTotalPedido;
    private String nomeCliente;
    private BigDecimal valorPedido;

}
