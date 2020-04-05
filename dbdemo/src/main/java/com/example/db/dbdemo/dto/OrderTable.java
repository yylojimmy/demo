package com.example.db.dbdemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderTable {
    @Id
    @GeneratedValue
    private Long idOrderTable;
    private String customerNo;

    public Long getIdOrderTable() {
        return idOrderTable;
    }

    public void setIdOrderTable(Long id) {
        this.idOrderTable = id;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }
}
