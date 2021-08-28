package br.com.boticario.cashback.service;

import br.com.boticario.cashback.model.Status;
import br.com.boticario.cashback.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionsUseCaseService {

    public static final List<String> DOCUMENTS = List.of("15350946056");

    public void approveExceptions(Order order) {
        if (DOCUMENTS.contains(order.getReseller().getDocument())) {
            order.setStatus(Status.APPROVED);
        }
    }
}
