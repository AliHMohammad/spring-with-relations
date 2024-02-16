package dk.kea.springwithrelations.controllers;


import dk.kea.springwithrelations.models.OrderLine;
import dk.kea.springwithrelations.repositories.OrderLineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orderlines")
public class OrderLineController {

    private OrderLineRepository orderLineRepository;

    public OrderLineController(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }


    @GetMapping
    public List<OrderLine> getOrderLines() {
        return orderLineRepository.findAll();
    }

    @PostMapping
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }
}
