package com.softexpert.desafiosoftexpert.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PagSeguroRequestDTO {

    private Customer customer;
    private List<Charge> charges;
    @Data
    public static class Customer {
        private String name;
        private String email;
        private String tax_id;
    }

    @Data
    public static class Amount {
        private String value;
        private String currency;
    }

    @Data
    public static class Boleto {
        private String due_date;
        private Holder holder;
    }


    @Data
    public static class Holder {
        private String name;
        private String tax_id;
        private String email;
        private Address address;
    }
    @Data
    public static class Address {
        private String country;
        private String region;
        private String region_code;
        private String city;
        private String postal_code;
        private String street;
        private String number;
        private String locality;
    }
    @Data
    public static class PaymentMethod {
        private String type;
        private Boleto boleto;
    }
    @Data
    public static class Charge {
        private String reference_id;
        private String description;
        private Amount amount;
        private PaymentMethod payment_method;
    }

}
