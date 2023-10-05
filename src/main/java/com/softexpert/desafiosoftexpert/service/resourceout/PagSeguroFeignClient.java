package com.softexpert.desafiosoftexpert.service.resourceout;

import com.softexpert.desafiosoftexpert.dto.PagSeguroRequestDTO;
import com.softexpert.desafiosoftexpert.dto.PagSeguroResponseDTO;
import com.softexpert.desafiosoftexpert.properties.Propriedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "pagSeguroClient", url = "https://sandbox.api.pagseguro.com")
public interface PagSeguroFeignClient {


    @PostMapping("/orders")
    PagSeguroResponseDTO criarPedido(@RequestBody PagSeguroRequestDTO requestBody,
                                     @RequestHeader("Authorization") String token);
}