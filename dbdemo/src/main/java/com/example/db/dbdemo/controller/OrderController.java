package com.example.db.dbdemo.controller;

import com.example.db.dbdemo.dto.OrderTable;
import com.example.db.dbdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    /*@Autowired
    private OrderRepository orderRepository;*/

    @Autowired
    private OrderMapper orderMapper;

   /* @GetMapping("/orders")
    List<OrderTable> findAll(){
        return orderRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/orders")
    OrderTable newOrder(@RequestBody OrderTable orderTable){
        System.out.println("orderTable customer_no "+orderTable.getCustomerNo());
        return orderRepository.save(orderTable);
    }

    @GetMapping("/orders/{id}")
    OrderTable findOne(@PathVariable Long id){

        return orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException(id));
    }*/

    @PostMapping("/ordersB")
    OrderTable findOneM(@RequestBody OrderTable orderTable){
        System.out.println("read customer_no - "+orderTable.getCustomerNo());
        return orderMapper.getOrderTable(orderTable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/ordersM")
    String newOrderM(@RequestBody OrderTable orderTable){
        //DatabaseContextHolder.setDatabaseType(DatabaseType.D3307);
        orderMapper.insertOrderTable(orderTable);
        return "-----ok-----";
    }
}
