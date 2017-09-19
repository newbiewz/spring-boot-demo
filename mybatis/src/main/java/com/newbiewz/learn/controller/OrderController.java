package com.newbiewz.learn.controller;

import com.newbiewz.learn.domain.Order;
import com.newbiewz.learn.mapper.OrderMapper;
import com.newbiewz.learn.util.GsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderMapper orderMapper;

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Order getById(@PathVariable Long id) {
        return orderMapper.queryById(id);
    }

    /**
     * curl -H "Content-Type: application/json" -X POST --data '{"orderId":1, "address":"abc", "createTime":"2017-09-09"}' localhost:8080/order/add
     */
    @RequestMapping(value = "/add")
    public Long save(@RequestBody Order order) {
        Integer result = orderMapper.insert(order);
        System.out.println("insert: " + result + GsonUtil.toJson(order));
        return order.getId();
    }
}
