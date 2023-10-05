package com.softexpert.desafiosoftexpert.dto;

import com.softexpert.desafiosoftexpert.domain.DescontoAcrescimo;
import com.softexpert.desafiosoftexpert.domain.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    @Valid
    private List<Pedido> pedidos;

    @Valid
    private DescontoAcrescimo descontoAcrescimo;

}

