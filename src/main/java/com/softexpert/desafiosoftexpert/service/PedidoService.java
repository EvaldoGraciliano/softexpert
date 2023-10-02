package com.softexpert.desafiosoftexpert.service;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PedidoDTO;

import java.math.BigDecimal;
import java.util.List;


public interface PedidoService {
     List<Pedido> somaPedidosPorCliente(PedidoDTO pedidosDTO);
    BigDecimal somaTotalPedidos(List<Pedido> pedidos);

    void calcularValorTotalComAcrecimosEDescontos(BigDecimal valorTotalPedidos, PedidoDTO pedidoDTO);
}
