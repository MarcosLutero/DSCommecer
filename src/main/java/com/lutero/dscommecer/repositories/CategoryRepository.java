package com.lutero.dscommecer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lutero.dscommecer.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
