CREATE TABLE `order`
(
   id   BIGINT(20) not null AUTO_INCREMENT,
   order_id   BIGINT(20) not null,
   item_id   BIGINT(20) not null,
   sku_id   BIGINT(20) not null,
   buyer_id   BIGINT(20) not null,
   seller_id   BIGINT(20) not null,
   create_time   DATETIME not null,
   address VARCHAR(20) not null,
   PRIMARY KEY (id)
);