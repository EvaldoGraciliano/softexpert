package com.softexpert.desafiosoftexpert.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;
import com.softexpert.desafiosoftexpert.dto.PedidoDTO;
import com.softexpert.desafiosoftexpert.service.PagamentoPagSeguroService;
import com.softexpert.desafiosoftexpert.service.PagamentoService;
import com.softexpert.desafiosoftexpert.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private PagamentoPagSeguroService pagamentoPagSeguroService;



    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> calcularValorPagamento(@RequestBody @Validated PedidoDTO pedidoDTO) throws JsonProcessingException {

        List<Pedido> pedidos = pedidoService.somaPedidosPorCliente(pedidoDTO);
        List<PagamentoDTO> pagamentosDTO = pagamentoService.caclularPercentualParaCadaUsuario(pedidos);
        BigDecimal valorTotalComAcrecismosEDescontos =  pedidoService.calcularValorTotalComAcrecimosEDescontos(pedidoService.somaTotalPedidos(pedidos),pedidoDTO);
        pagamentoService.calcularValorFinalPagamentoPedido(pagamentosDTO,valorTotalComAcrecismosEDescontos);

        for(PagamentoDTO pagamentoDTO: pagamentosDTO) {
            String link = pagamentoPagSeguroService.gerarPagamentoBoleto(pagamentoDTO.getNomeUsuario(), pagamentoDTO.getValorPagamento());
            pagamentoDTO.setLinkPagamento(link);
        }

        return ResponseEntity.ok(pagamentosDTO);

    }

}
