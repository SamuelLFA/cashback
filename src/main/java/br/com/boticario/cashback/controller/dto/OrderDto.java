package br.com.boticario.cashback.controller.dto;

import br.com.boticario.cashback.model.Order;
import br.com.boticario.cashback.model.Reseller;
import br.com.boticario.cashback.service.ResellerService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
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

    @JsonProperty("reseller")
    private ResellerDto resellerDto;

    public OrderDto(Order order) {
        this.code = order.getCode();
        this.price = order.getPrice();
        this.orderDate = order.getOrderDate();
        this.resellerDto = new ResellerDto(order.getReseller());
    }
}
