package br.com.boticario.cashback.repository;

import br.com.boticario.cashback.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
