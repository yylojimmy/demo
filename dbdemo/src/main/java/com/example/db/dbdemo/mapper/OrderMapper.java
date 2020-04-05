package com.example.db.dbdemo.mapper;

import com.example.db.dbdemo.dto.OrderTable;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    OrderTable getOrderTable(OrderTable order);

    void insertOrderTable(OrderTable order);


}
