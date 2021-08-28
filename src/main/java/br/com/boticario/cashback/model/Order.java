package br.com.boticario.cashback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Entity(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal price;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.VALIDATING;
    @ManyToOne
    private Reseller reseller;

    public int getCashbackPer() {
        if (isLessOrEqualThan(price, new BigDecimal("1000.00"))) {
            return 10;
        }
        else if (isLessOrEqualThan(price, new BigDecimal("1500.00"))) {
            return 15;
        }
        else {
            return 20;
        }
    }

    public BigDecimal getCashbackValue() {
        int cashbackPer = getCashbackPer();
        return (price.multiply(new BigDecimal(cashbackPer))).divide(new BigDecimal("100.00"), RoundingMode.CEILING);
    }

    private boolean isLessOrEqualThan(BigDecimal price,  BigDecimal priceToCompare) {
        return price.compareTo(priceToCompare) == 0;
    }
}
