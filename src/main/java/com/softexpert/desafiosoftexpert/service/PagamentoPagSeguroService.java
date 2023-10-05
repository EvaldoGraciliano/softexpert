package com.softexpert.desafiosoftexpert.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

public interface PagamentoPagSeguroService {
    String gerarPagamentoBoleto(String nome, String valor) throws JsonProcessingException;
}
