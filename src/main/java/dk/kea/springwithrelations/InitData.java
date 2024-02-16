package dk.kea.springwithrelations;

import dk.kea.springwithrelations.models.OrderLine;
import dk.kea.springwithrelations.models.Product;
import dk.kea.springwithrelations.repositories.OrderLineRepository;
import dk.kea.springwithrelations.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private ProductRepository productRepository;
    private OrderLineRepository orderLineRepository;

    public InitData(ProductRepository productRepository, OrderLineRepository orderLineRepository) {
        this.productRepository = productRepository;
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("InitData is running");
        Product product1 = new Product();
        product1.setDescription("Lækre ærter - lige til at tø op");
        product1.setName("Ærter");
        product1.setPrice(20.95);
        product1.setEAN13("43242353466336");

        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Kartofler");
        product2.setDescription("Dejlige bløde kartofler");
        product2.setPrice(15.50);
        product2.setEAN13("423543654786");

        productRepository.save(product2);

        OrderLine line1 = new OrderLine();
        line1.setProduct(product2);
        line1.setQuantity(5);

        orderLineRepository.save(line1);

        OrderLine line2 = new OrderLine();
        line2.setQuantity(4);
        line2.setProduct(product2);

        orderLineRepository.save(line2);
    }
}
