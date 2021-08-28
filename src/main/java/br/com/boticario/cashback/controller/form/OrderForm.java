package br.com.boticario.cashback.controller.form;

import br.com.boticario.cashback.model.Order;
import br.com.boticario.cashback.service.ResellerService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderForm {

    @NotNull @NotEmpty @Length(min = 1, max = 50)
    @JsonProperty("codigo")
    private String code;

    @NotNull @PositiveOrZero
    @JsonProperty("valor")
    private BigDecimal price;

    @NotNull @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("data")
    private LocalDateTime orderDate;

    @CPF
    @JsonProperty("cpf")
    private String document;

    public Order toModel(ResellerService resellerService) {
        var reseller = resellerService.getByDocument(document)
                .orElseThrow(() -> new IllegalArgumentException("Reseller not found"));

        var model = new Order();
        model.setCode(code);
        model.setPrice(price);
        model.setOrderDate(orderDate);
        model.setReseller(reseller);

        return model;
    }
}
