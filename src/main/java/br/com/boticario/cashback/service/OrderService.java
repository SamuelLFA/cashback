package br.com.boticario.cashback.service;

import br.com.boticario.cashback.model.Order;
import br.com.boticario.cashback.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ExceptionsUseCaseService exceptionsUseCaseService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ExceptionsUseCaseService exceptionsUseCaseService) {
        this.orderRepository = orderRepository;
        this.exceptionsUseCaseService = exceptionsUseCaseService;
    }

    public void create(Order order) {
        exceptionsUseCaseService.approveExceptions(order);
        orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
