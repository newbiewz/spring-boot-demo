package com.newbiewz.learn.mapper;

import com.newbiewz.learn.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order queryById(Long id);

    Integer insert(Order order);
}
