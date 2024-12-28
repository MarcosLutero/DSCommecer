package com.lutero.dscommecer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lutero.dscommecer.entities.OrderItem;
import com.lutero.dscommecer.entities.OrderItemPk;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {


	
}
