package com.softexpert.desafiosoftexpert.service.impl;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;
import com.softexpert.desafiosoftexpert.service.PagamentoService;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    @Override
    public List<PagamentoDTO> caclularPercentualParaCadaUsuario(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> {
                    PagamentoDTO pagamentoDTO = new PagamentoDTO();
                    pagamentoDTO.setNomeUsuario(pedido.getNomeCliente());
                    pagamentoDTO.setPorcentagemNoValorTotalPedido(pedido.getValorPedido()
                            .divide(Pedido.valorTotalPedido, RoundingMode.HALF_UP));
                    return pagamentoDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void calcularValorPagamentoPedido(List<PagamentoDTO> pagamentosDTO) {
        DecimalFormatSymbols formatPtBr = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formatoMoeda = new DecimalFormat("R$ #,##0.00", formatPtBr);
        for (PagamentoDTO p: pagamentosDTO) {

            String formatMoeda = formatoMoeda.format(Pedido.valorTotalPedido.multiply(p.getPorcentagemNoValorTotalPedido()));
            p.setValorPagamento(formatMoeda);
        }
    }
}
