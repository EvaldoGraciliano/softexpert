package com.softexpert.desafiosoftexpert.commom;

import com.softexpert.desafiosoftexpert.domain.DescontoAcrescimo;
import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PedidoDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PedidoConstants {
    public static final Pedido PEDIDO_EVALDO =  Pedido.builder().nomeCliente("Evaldo")
                    .valorPedido(new BigDecimal("42.00")).build();

    public static final Pedido PEDIDO_AMIGO =  Pedido.builder().nomeCliente("amigo_evaldo")
            .valorPedido(new BigDecimal("8.00")).build();

    public static final Pedido PEDIDO_EVALDO_INVALIDO =  Pedido.builder().nomeCliente("Evaldo")
            .valorPedido(new BigDecimal("420.00")).build();

    public static final Pedido PEDIDO_AMIGO_INVALIDO =  Pedido.builder().nomeCliente("amigo_evaldo")
            .valorPedido(new BigDecimal("88.00")).build();

    public static final List<Pedido> PEDIDOS = new ArrayList<>(Arrays.asList(PEDIDO_EVALDO, PEDIDO_AMIGO));
    public static final List<Pedido> PEDIDOS_INVALIDOS =
            new ArrayList<>(Arrays.asList(PEDIDO_EVALDO_INVALIDO, PEDIDO_AMIGO_INVALIDO));

    public static final DescontoAcrescimo DESCONTO_ACRESCIMO =
        new DescontoAcrescimo(new BigDecimal("8.00"),new BigDecimal("20.00")
                ,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO);

    public static final PedidoDTO PEDIDOS_DTO = new PedidoDTO(PEDIDOS, DESCONTO_ACRESCIMO);





}
