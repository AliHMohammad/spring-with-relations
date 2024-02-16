package dk.kea.springwithrelations.controllers;


import dk.kea.springwithrelations.models.OrderLine;
import dk.kea.springwithrelations.repositories.OrderLineRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
