package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.model.Status;
import br.com.boticario.cashback.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderDto {

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("valor")
    private BigDecimal price;

    @JsonProperty("data")
    private LocalDateTime orderDate;

    @JsonProperty("revendedor")
    private ResellerDto resellerDto;

    @JsonProperty("porcentagem_cashback")
    private int cashbackPer;

    @JsonProperty("valor_cashback")
    private BigDecimal cashbackValue;

    @JsonProperty("status")
    private String status;

    public OrderDto(Order order) {
        this.code = order.getCode();
        this.price = order.getPrice();
        this.orderDate = order.getOrderDate();
        this.resellerDto = new ResellerDto(order.getReseller());
        this.cashbackPer = order.getCashbackPer();
        this.cashbackValue = order.getCashbackValue();
        this.status = order.getStatus().name();
    }
}
