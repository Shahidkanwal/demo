package com.boot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.model.RTJob;

public interface RTJobDao extends JpaRepository<RTJob, Integer>{

}
