package br.com.boticario.cashback.service;

import br.com.boticario.cashback.model.Order;
import br.com.boticario.cashback.model.Reseller;
import br.com.boticario.cashback.repository.OrderRepository;
import br.com.boticario.cashback.repository.ResellerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Test
    void when_model_is_valid_should_success() {
        var orderService = new OrderService(orderRepository);
        Reseller reseller = new Reseller();
        reseller.setId(1L);
        reseller.setName("Reseller");
        reseller.setDocument("00000000000");
        reseller.setEmail("email@email.com");
        reseller.setPassword("123456");

        Order order = new Order();
        order.setId(1L);
        order.setOrderDate(LocalDateTime.now());
        order.setPrice(new BigDecimal("100.00"));
        order.setReseller(reseller);

        orderService.create(order);
        Mockito.verify(orderRepository, Mockito.times(1)).save(order);
    }
}
