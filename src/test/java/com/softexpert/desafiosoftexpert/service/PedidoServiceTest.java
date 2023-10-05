package com.softexpert.desafiosoftexpert.service;


import com.softexpert.desafiosoftexpert.domain.Pedido;
import com.softexpert.desafiosoftexpert.dto.PagamentoDTO;
import com.softexpert.desafiosoftexpert.dto.PedidoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.List;

import static com.softexpert.desafiosoftexpert.commom.PagamentoConstants.PAGAMENTOS;
import static com.softexpert.desafiosoftexpert.commom.PagamentoConstants.PAGAMENTOS_INCORRETOS;
import static com.softexpert.desafiosoftexpert.commom.PedidoConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PedidoServiceTest {

    @Autowired
    private PedidoService pedidoService;

    @Test
    public void somaTotalPedidos_ComDadosValidos_ReturnSomaTotalPedidosCorreta() {

        BigDecimal valorRealEvaldo =  pedidoService.somaTotalPedidos(PEDIDOS);
        BigDecimal valorEsperadoEvaldo = new BigDecimal("50.00");
        assertEquals (valorEsperadoEvaldo,valorRealEvaldo);
    }

    @Test
    public void somaTotalPedidos_ComDadosInvalidos_ReturnSomaTotalPedidosIncorreta() {
        BigDecimal valorRealEvaldo =  pedidoService.somaTotalPedidos(PEDIDOS_INVALIDOS);
        BigDecimal valorEsperadoEvaldo = new BigDecimal("50.00");
        assertNotEquals (valorEsperadoEvaldo,valorRealEvaldo);
    }


    @Test
    public void somaPedidosPorCliente_ComDadosValidos_ReturnSomaPedidosPorCliente() {
        List<Pedido> pedidos =  pedidoService.somaPedidosPorCliente(PEDIDOS_DTO);
       BigDecimal valorRealPedidoEvaldo = pedidos.get(0).getValorPedido();
       BigDecimal valorRealPedidoAmigo = pedidos.get(1).getValorPedido();

        assertNotEquals (new BigDecimal("42.00"),valorRealPedidoEvaldo);
        assertNotEquals (new BigDecimal("8.00"),valorRealPedidoAmigo);
    }


    @Test
    public void calcularValorTotalComAcrecimosEDescontos_ComDadosValidos_ReturnValorTotalCorreto() {
       BigDecimal valorTotalComAcrescimosEDescontosReal =  pedidoService
               .calcularValorTotalComAcrecimosEDescontos(new BigDecimal("50.00"), PEDIDOS_DTO);

       BigDecimal valorTotalComAcrescimosEDescontosEsperado = new BigDecimal("38.00");
        assertEquals (valorTotalComAcrescimosEDescontosReal, valorTotalComAcrescimosEDescontosEsperado);
    }









}
