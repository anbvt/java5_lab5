package com.fpoly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{

}
