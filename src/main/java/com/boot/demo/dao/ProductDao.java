package com.boot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
