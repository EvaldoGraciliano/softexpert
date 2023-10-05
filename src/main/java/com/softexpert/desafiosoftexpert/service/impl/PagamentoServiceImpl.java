package com.softexpert.desafiosoftexpert.service.impl;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;
import com.softexpert.desafiosoftexpert.service.PagamentoService;
import com.softexpert.desafiosoftexpert.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PedidoService pedidoService;
    @Override
    public List<PagamentoDTO> caclularPercentualParaCadaUsuario(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> {
                    PagamentoDTO pagamentoDTO = new PagamentoDTO();
                    pagamentoDTO.setNomeUsuario(pedido.getNomeCliente());
                    pagamentoDTO.setPorcentagemNoValorTotalPedido(pedido.getValorPedido()
                            .divide(pedidoService.somaTotalPedidos(pedidos), 2, RoundingMode.HALF_UP));
                    return pagamentoDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void calcularValorFinalPagamentoPedido(List<PagamentoDTO> pagamentosDTO, BigDecimal valorTotalComAcrecismosEDescontos) {
        DecimalFormatSymbols formatPtBr = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formatoMoeda = new DecimalFormat("R$ #,##0.00", formatPtBr);
        for (PagamentoDTO p: pagamentosDTO) {

            String formatMoeda = formatoMoeda.format(valorTotalComAcrecismosEDescontos.multiply(p.getPorcentagemNoValorTotalPedido()));
            p.setValorPagamento(formatMoeda);
        }
    }
}
