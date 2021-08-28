package br.com.boticario.cashback.controller;

import br.com.boticario.cashback.controller.dto.OrderDto;
import br.com.boticario.cashback.controller.form.OrderForm;
import br.com.boticario.cashback.service.OrderService;
import br.com.boticario.cashback.service.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final ResellerService resellerService;
    private final OrderService orderService;

    @Autowired
    public OrderController(ResellerService resellerService, OrderService orderService) {
        this.resellerService = resellerService;
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> create(@Valid @RequestBody OrderForm form, UriComponentsBuilder uriBuilder) {
        var model = form.toModel(resellerService);

        orderService.create(model);

        URI uri = uriBuilder.path("/resellers/{id}").buildAndExpand(model.getId()).toUri();
        var dto = new OrderDto(model);
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> list() {
        var listOfOrders = orderService.findAll();

        var dto = listOfOrders.stream().map(OrderDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }
}
