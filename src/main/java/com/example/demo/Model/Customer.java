package com.example.demo.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    public String CustomerID = UUID.randomUUID().toString();
    @Column(name = "customername")
    public String customername;
    @Column(name = "customernum")
    public int customernum;


    public Customer(String customername, int customernum) {
        this.customername = customername;
        this.customernum = customernum;
    }
    public Customer()
    {

    }
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return customername;
    }

    public void setCustomerName(String customername) {
        this.customername = customername;
    }

    public int getCustomerNum() {
        return customernum;
    }

    public void setCustomerNum(int customernum) {
        this.customernum = customernum;
    }
}
