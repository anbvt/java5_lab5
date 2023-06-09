package com.fpoly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
