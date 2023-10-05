package com.softexpert.desafiosoftexpert.service.impl;

import com.softexpert.desafiosoftexpert.dto.PagSeguroRequestDTO;
import com.softexpert.desafiosoftexpert.dto.PagSeguroResponseDTO;
import com.softexpert.desafiosoftexpert.properties.Propriedades;
import com.softexpert.desafiosoftexpert.service.PagamentoPagSeguroService;
import com.softexpert.desafiosoftexpert.service.resourceout.PagSeguroFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;

@Service
public class PagamentoPagSeguroImpl implements PagamentoPagSeguroService {

    @Autowired
    PagSeguroFeignClient pagSeguroFeignClient;

    @Autowired
    Propriedades propriedades;

    @Override
    public String gerarPagamentoBoleto(String nome, String valor) {

        PagSeguroRequestDTO pagSeguroRequest = new PagSeguroRequestDTO();

        // Dados do cliente
        PagSeguroRequestDTO.Customer customer = new PagSeguroRequestDTO.Customer();
        customer.setName(nome);
        customer.setEmail("email@test.com");
        customer.setTax_id("12345678909");
        pagSeguroRequest.setCustomer(customer);

        // Detalhes da cobrança
        PagSeguroRequestDTO.Charge charge = new PagSeguroRequestDTO.Charge();
        charge.setReference_id("referencia da cobranca");
        charge.setDescription("descricao da cobranca");

        // Detalhes do valor
        PagSeguroRequestDTO.Amount amount = new PagSeguroRequestDTO.Amount();
        valor = valor.replace("R$ ", "").replace(",", "");
        amount.setValue(valor);
        amount.setCurrency("BRL");
        charge.setAmount(amount);

        // Detalhes do método de pagamento
        PagSeguroRequestDTO.PaymentMethod paymentMethod = new PagSeguroRequestDTO.PaymentMethod();
        paymentMethod.setType("BOLETO");

        // Detalhes do boleto
        PagSeguroRequestDTO.Boleto boleto = new PagSeguroRequestDTO.Boleto();
        boleto.setDue_date(LocalDate.now().plusDays(3).toString());

        // Detalhes do titular
        PagSeguroRequestDTO.Holder holder = new PagSeguroRequestDTO.Holder();
        holder.setName(nome);
        holder.setTax_id("22222222222");
        holder.setEmail("jose@email.com");

        // Preencha os detalhes do endereço
        PagSeguroRequestDTO.Address address = new PagSeguroRequestDTO.Address();
        address.setCountry("Brasil");
        address.setRegion("São Paulo");
        address.setRegion_code("SP");
        address.setCity("Sao Paulo");
        address.setPostal_code("01452002");
        address.setStreet("Avenida Brigadeiro Faria Lima");
        address.setNumber("1384");
        address.setLocality("Pinheiros");

        holder.setAddress(address);
        boleto.setHolder(holder);

        paymentMethod.setBoleto(boleto);
        charge.setPayment_method(paymentMethod);

        pagSeguroRequest.setCharges(Collections.singletonList(charge));


        //  String token = "DF73B98714AA48B59DF9AFC4A6412C33";

        String token = propriedades.getToken();

        PagSeguroResponseDTO pagSeguroResponseDTO = pagSeguroFeignClient
                .criarPedido(pagSeguroRequest, "Bearer " + token);

        var pdfLink = pagSeguroResponseDTO.getCharges().get(0).getLinks().stream()
                .filter(link -> "application/pdf".equals(link.getMedia()))
                .findFirst()
                .orElse(null);

        return pdfLink.getHref();
    }
}
