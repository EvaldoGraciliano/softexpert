package com.softexpert.desafiosoftexpert.service;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface PagamentoService {
    List<PagamentoDTO> caclularPercentualParaCadaUsuario(List<Pedido> pedidos);
    void calcularValorFinalPagamentoPedido(List<PagamentoDTO> pagamentosDTO,BigDecimal valorTotalComAcrecismosEDescontos);
}
