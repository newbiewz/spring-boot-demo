package com.newbiewz.learn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Long id;
    private Long orderId;
    private Long itemId;
    private Long skuId;
    private Long buyerId;
    private Long sellerId;
    private Date createTime;
    private String address;
}
