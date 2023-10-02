package com.softexpert.desafiosoftexpert.service;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;

import java.util.List;

public interface PagamentoService {
    List<PagamentoDTO> caclularPercentualParaCadaUsuario(List<Pedido> pedidos);

    void calcularValorPagamentoPedido(List<PagamentoDTO> pagamentosDTO);
}
