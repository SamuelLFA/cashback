package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.model.Order;
import br.com.boticario.cashback.model.Reseller;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDtoTest {

    @Test
    void when_model_is_valid_should_instantiates() {
        Reseller reseller = new Reseller();
        reseller.setId(1L);
        reseller.setName("Reseller");
        reseller.setDocument("00000000000");
        reseller.setEmail("email@email.com");
        reseller.setPassword("123456");

        Order model = new Order();
        model.setId(1L);
        model.setOrderDate(LocalDateTime.now());
        model.setPrice(new BigDecimal("100.00"));
        model.setReseller(reseller);

        OrderDto orderDto = new OrderDto(model);

        assertEquals(orderDto.getCode(), model.getCode());
        assertEquals(orderDto.getOrderDate(), model.getOrderDate());
        assertEquals(orderDto.getPrice(), model.getPrice());

        assertEquals(orderDto.getResellerDto().getName(), reseller.getName());
        assertEquals(orderDto.getResellerDto().getDocument(), reseller.getDocument());
        assertEquals(orderDto.getResellerDto().getEmail(), reseller.getEmail());
    }
}
