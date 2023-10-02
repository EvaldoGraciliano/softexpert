package com.softexpert.desafiosoftexpert.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    private List<Pedido> pedidos;
    private DescontoAcrescimo descontoAcrescimo;
}
