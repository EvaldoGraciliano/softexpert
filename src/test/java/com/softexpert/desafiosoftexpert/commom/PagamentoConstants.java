package com.softexpert.desafiosoftexpert.commom;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PagamentoConstants {

    public static final PagamentoDTO PAGAMENTO_EVALDO = PagamentoDTO.builder().porcentagemNoValorTotalPedido(new BigDecimal("0.16")).build();
    public static final PagamentoDTO PAGAMENTO_AMIGO = PagamentoDTO.builder().porcentagemNoValorTotalPedido(new BigDecimal("0.84")).build();

    public static  List<PagamentoDTO> PAGAMENTOS
            =  new ArrayList<>(Arrays.asList(PAGAMENTO_EVALDO, PAGAMENTO_AMIGO));


    public static final PagamentoDTO PAGAMENTO_EVALDO_INCORRETO = PagamentoDTO.builder().porcentagemNoValorTotalPedido(new BigDecimal("0.15")).build();
    public static final PagamentoDTO PAGAMENTO_AMIGO_INCORRETO = PagamentoDTO.builder().porcentagemNoValorTotalPedido(new BigDecimal("0.89")).build();

    public static  List<PagamentoDTO> PAGAMENTOS_INCORRETOS
            =  new ArrayList<>(Arrays.asList(PAGAMENTO_EVALDO_INCORRETO, PAGAMENTO_AMIGO_INCORRETO));

}
