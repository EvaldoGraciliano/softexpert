package com.softexpert.desafiosoftexpert.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {
    private String nomeUsuario;

    @JsonIgnore
    private BigDecimal porcentagemNoValorTotalPedido;

    private String valorPagamento;
}
