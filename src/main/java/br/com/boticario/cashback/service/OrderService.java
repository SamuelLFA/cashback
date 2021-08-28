package br.com.boticario.cashback.service;

import br.com.boticario.cashback.model.Order;
import br.com.boticario.cashback.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {
        orderRepository.save(order);
    }
}
