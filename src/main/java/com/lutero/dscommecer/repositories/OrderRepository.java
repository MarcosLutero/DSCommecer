package com.lutero.dscommecer.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lutero.dscommecer.entities.Order;
import com.lutero.dscommecer.entities.User;
import com.lutero.dscommecer.projection.UserDetailsProjection;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


	
}
