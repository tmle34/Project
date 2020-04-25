package com.example.demo.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Transactions")
public class Transactions {
    @Column(name = "transactionsid")
    public String TransactionsID = UUID.randomUUID().toString();
    @Column(name = "employeeid")
    public String EmployeeID;
    @Column(name = "productid")
    public String ProductID;
    @Column(name = "customerid")
    public String CustomerID;
    @Id
    public int Receipt;


    public Transactions(String EmployeeID, String ProductID, String CustomerID, String TransactionsID) {
        this.EmployeeID = EmployeeID;
        this.ProductID = ProductID;
        this.CustomerID = CustomerID;
        this.TransactionsID = TransactionsID;
    }
    public Transactions()
    {

    }
    public String getTransactionID() {
        return TransactionsID;
    }

    public void setTransactionID(String TransactionID) {
        this.TransactionsID = TransactionID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getReceipt(){
        return Receipt;
    }

    public void setReceipt(int Receipt){
        this.Receipt = Receipt;
    }
}
