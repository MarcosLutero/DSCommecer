package com.lutero.dscommecer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lutero.dscommecer.dto.OrderDTO;
import com.lutero.dscommecer.entities.Order;
import com.lutero.dscommecer.repositories.OrderRepository;
import com.lutero.dscommecer.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
		return new OrderDTO(order);
	}

	
}
