package com.eventdriven.base_domains;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Order {
    private String orderId;
    private String name;
    private int quantity;
    private double price;



}
