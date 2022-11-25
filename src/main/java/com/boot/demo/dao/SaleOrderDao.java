package com.boot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.model.SaleOrder;

public interface SaleOrderDao extends JpaRepository<SaleOrder, Integer>{

}
