package com.fpoly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{

}