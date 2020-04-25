package com.example.demo.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Products {
    @Id
    public String ProductID = UUID.randomUUID().toString();
    @Column(name = "productname")
    public String ProductName;
    @Column(name = "productprice")
    public double ProductPrice;
    @Column(name = "productsku")
    public int ProductSKU;


    public Products(String ProductName, double ProductPrice, int ProductSKU) {
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.ProductSKU = ProductSKU;
    }
    public Products()
    {

    }
    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getProductSKU() {
        return ProductSKU;
    }

    public void setProductSKU(int ProductSKU) {
        this.ProductSKU = ProductSKU;
    }
}
