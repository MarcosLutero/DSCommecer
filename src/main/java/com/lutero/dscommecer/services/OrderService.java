package com.lutero.dscommecer.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lutero.dscommecer.dto.OrderDTO;
import com.lutero.dscommecer.dto.OrderItemDTO;
import com.lutero.dscommecer.entities.Order;
import com.lutero.dscommecer.entities.OrderItem;
import com.lutero.dscommecer.entities.OrderStatus;
import com.lutero.dscommecer.entities.Product;
import com.lutero.dscommecer.entities.User;
import com.lutero.dscommecer.repositories.OrderItemRepository;
import com.lutero.dscommecer.repositories.OrderRepository;
import com.lutero.dscommecer.repositories.ProductRepository;
import com.lutero.dscommecer.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order();
	
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAGMENT);
		
		User user = userService.authenticated();
		order.setClient(user);
		
		for (OrderItemDTO itemDto : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDto.getProductId());
			OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
			order.getItens().add(item);
		}
		
		repository.save(order);
		orderItemRepository.saveAll(order.getItens());

		return new OrderDTO(order);
	}

}
