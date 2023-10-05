package com.softexpert.desafiosoftexpert.service;

import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;
import com.softexpert.desafiosoftexpert.service.impl.PagamentoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static com.softexpert.desafiosoftexpert.commom.PagamentoConstants.PAGAMENTOS;
import static com.softexpert.desafiosoftexpert.commom.PagamentoConstants.PAGAMENTOS_INCORRETOS;
import static com.softexpert.desafiosoftexpert.commom.PedidoConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotEquals;


@SpringBootTest
public class PagamentoServiceTest {

    @Autowired
    private PagamentoService pagamentoService;

    @MockBean
    private PedidoService pedidoService;

    //operacao_status_retorno

    @Test
    public void caclularPercentualParaCadaUsuario_ComDadosValidos_ReturnPercentualCorreto() {

        when(pedidoService.somaTotalPedidos(PEDIDOS)).thenReturn(new BigDecimal("50.00"));
        List<PagamentoDTO> sut =  pagamentoService.caclularPercentualParaCadaUsuario(PEDIDOS);

        BigDecimal valorRealEvaldo = sut.get(0).getPorcentagemNoValorTotalPedido();
        BigDecimal valorRealAmigo =  sut.get(1).getPorcentagemNoValorTotalPedido();

        BigDecimal valorEsperadoEvaldo = new BigDecimal("0.84");
        BigDecimal valorEsperadoAmigo =  new BigDecimal("0.16");

        assertEquals (valorEsperadoEvaldo,valorRealEvaldo);
        assertEquals (valorEsperadoAmigo,valorRealAmigo);
   }

    @Test
    public void caclularPercentualParaCadaUsuario_ComDadosInvalidos_ReturnPercentualIncorreto() {

        when(pedidoService.somaTotalPedidos(PEDIDOS_INVALIDOS)).thenReturn(new BigDecimal("50.00"));
        List<PagamentoDTO> sut =  pagamentoService.caclularPercentualParaCadaUsuario(PEDIDOS_INVALIDOS);

        BigDecimal valorEsperadoEvaldo = sut.get(0).getPorcentagemNoValorTotalPedido();
        BigDecimal valorEsperadoAmigo =  sut.get(1).getPorcentagemNoValorTotalPedido();

        BigDecimal valorRealEvaldo = new BigDecimal("0.84");
        BigDecimal valorRealAmigo =  new BigDecimal("0.16");

        assertNotEquals (valorEsperadoEvaldo,valorRealEvaldo);
        assertNotEquals (valorEsperadoAmigo,valorRealAmigo);
    }

    @Test
    public void calcularValorFinalPagamentoPedido_ComDadosValidos_ReturnValorFinalPagamentoPedidoCorreto() {

        pagamentoService.calcularValorFinalPagamentoPedido(PAGAMENTOS,new BigDecimal("38.00"));
        assertEquals(PAGAMENTOS.get(0).getValorPagamento(),"R$ 6,08");
        assertEquals(PAGAMENTOS.get(1).getValorPagamento(),"R$ 31,92");
    }

    @Test
    public void calcularValorFinalPagamentoPedido_ComDadosInValidos_ReturnValorFinalPagamentoPedidoIncorreto() {
        pagamentoService.calcularValorFinalPagamentoPedido(PAGAMENTOS_INCORRETOS,new BigDecimal("38.00"));
        assertNotEquals(PAGAMENTOS_INCORRETOS.get(0).getValorPagamento(),"R$ 6,08");
        assertNotEquals(PAGAMENTOS_INCORRETOS.get(1).getValorPagamento(),"R$ 31,92");
    }








}
