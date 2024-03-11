package com.inn.cafe.doa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inn.cafe.POJO.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    List<Category> getAllCategory();

}
