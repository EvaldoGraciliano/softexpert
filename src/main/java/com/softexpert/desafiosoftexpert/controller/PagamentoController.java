package com.softexpert.desafiosoftexpert.controller;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;
import com.softexpert.desafiosoftexpert.dto.PedidoDTO;
import com.softexpert.desafiosoftexpert.service.PagamentoService;
import com.softexpert.desafiosoftexpert.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> calcularValorPagamento(@RequestBody PedidoDTO pedidoDTO) {

        List<Pedido> pedidos = pedidoService.somaPedidosPorCliente(pedidoDTO);
        BigDecimal valorTotalPedidos = pedidoService.somaTotalPedidos(pedidos);
        List<PagamentoDTO> pagamentosDTO = pagamentoService.caclularPercentualParaCadaUsuario(pedidos);
        pedidoService.calcularValorTotalComAcrecimosEDescontos(valorTotalPedidos,pedidoDTO);
        pagamentoService.calcularValorPagamentoPedido(pagamentosDTO);

        return ResponseEntity.ok(pagamentosDTO);

    }

}
