package com.softexpert.desafiosoftexpert.service.impl;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PedidoDTO;
import com.softexpert.desafiosoftexpert.service.PedidoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Override
    public List<Pedido> somaPedidosPorCliente(PedidoDTO pedidosDTO) {
        return pedidosDTO.getPedidos().stream()
                .collect(Collectors.groupingBy(
                        Pedido::getNomeCliente,
                        Collectors.reducing(BigDecimal.ZERO, Pedido::getValorPedido, BigDecimal::add)
                ))
                .entrySet()
                .stream()
                .map(entry ->Pedido.builder().nomeCliente(entry.getKey()).valorPedido(entry.getValue()).build())
                .toList();
    }

    @Override
    public BigDecimal somaTotalPedidos(List<Pedido>  pedidos) {

        BigDecimal ValorTotalPedidos = pedidos.stream()
                .map(Pedido::getValorPedido)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Pedido.valorTotalPedido = ValorTotalPedidos;
        return ValorTotalPedidos;
    }

    @Override
    public void calcularValorTotalComAcrecimosEDescontos(BigDecimal valorTotalPedidos, PedidoDTO pedidoDTO) {
       Pedido.valorTotalPedido =  valorTotalPedidos.add(pedidoDTO.getDescontoAcrescimo().getValorEntrega())
                .add(pedidoDTO.getDescontoAcrescimo().getValorAcrescimoEmReal())
                .add(pedidoDTO.getDescontoAcrescimo().getValorAcrescimoEmPorcentagem().multiply(valorTotalPedidos)
                        .divide(new BigDecimal(100), RoundingMode.HALF_UP))
                .subtract(pedidoDTO.getDescontoAcrescimo().getValorDescontoEmReal())
                .subtract((pedidoDTO.getDescontoAcrescimo().getValorDescontoEmPorcantagem().multiply(valorTotalPedidos)
                        .divide(new BigDecimal(100), RoundingMode.HALF_UP)));
    }
}
