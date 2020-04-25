package com.example.demo.Model;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepo extends CrudRepository<Products, String> {
}
