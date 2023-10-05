package com.softexpert.desafiosoftexpert.dto;

import lombok.Data;

import java.util.List;

@Data
public class PagSeguroResponseDTO {

    private String id;
    private String created_at;
    private Customer customer;
    private List<Charge> charges;
    private List<Link> notification_urls;
    private List<Link> links;

    // ... getters and setters ...

    @Data
    public static class Customer {
        private String name;
        private String email;
        private String tax_id;

        // ... getters and setters ...
    }

    @Data
    public static class Charge {
        private String id;
        private String reference_id;
        private String status;
        private String created_at;
        private String description;
        private Amount amount;
        private PaymentResponse payment_response;
        private PaymentMethod payment_method;
        private List<Link> links;

        // ... getters and setters ...
    }

    @Data
    public static class Amount {
        private int value;
        private String currency;
        private Summary summary;

        // ... getters and setters ...

        public static class Summary {
            private int total;
            private int paid;
            private int refunded;

            // ... getters and setters ...
        }
    }

    @Data
    public static class PaymentResponse {
        private String code;
        private String message;

        // ... getters and setters ...
    }

    @Data
    public static class PaymentMethod {
        private String type;
        private Boleto boleto;

        // ... getters and setters ...

        @Data
        public static class Boleto {
            private String id;
            private String barcode;
            private String formatted_barcode;
            private String due_date;
            private Object instruction_lines; // consider creating a specific type if needed
            private Holder holder;

            // ... getters and setters ...

            @Data
            public static class Holder {
                private String name;
                private String tax_id;
                private String email;
                private Address address;

                // ... getters and setters ...
            }

            @Data
            public static class Address {
                private String region;
                private String city;
                private String postal_code;
                private String street;
                private String number;
                private String locality;
                private String country;
                private String region_code;

                // ... getters and setters ...
            }
        }
    }

    @Data
    public static class Link {
        private String rel;
        private String href;
        private String media;
        private String type;

        // ... getters and setters ...
    }
}
