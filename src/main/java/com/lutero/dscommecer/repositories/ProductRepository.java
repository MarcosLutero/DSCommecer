package com.lutero.dscommecer.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lutero.dscommecer.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
