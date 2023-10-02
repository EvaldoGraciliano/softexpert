package com.softexpert.desafiosoftexpert.dto;

import com.softexpert.desafiosoftexpert.domain.DescontoAcrescimo;
import com.softexpert.desafiosoftexpert.domain.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private List<Pedido> pedidos;
    private DescontoAcrescimo descontoAcrescimo;
}

