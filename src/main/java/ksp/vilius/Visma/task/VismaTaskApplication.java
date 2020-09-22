package ksp.vilius.Visma.task;

import ksp.vilius.Visma.task.model.Product;
import ksp.vilius.Visma.task.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class VismaTaskApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(VismaTaskApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {


        Product product1 = new Product("Paper", "Very good", LocalDate.now().plusDays(1000), 50);

        Product product2 = new Product("Pizza", "frozen pizza", LocalDate.now().plusDays(191), 100);

        Product product3 = new Product("Meat", "fresh meat", LocalDate.now().plusDays(7), 5153);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }
}
