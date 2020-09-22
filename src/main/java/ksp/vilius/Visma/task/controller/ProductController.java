package ksp.vilius.Visma.task.controller;

import ksp.vilius.Visma.task.model.Product;
import ksp.vilius.Visma.task.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {

        return new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

    @PutMapping("products/{id}")
    public Product updateProject(@PathVariable Long id, @RequestBody Product product) {

        return productService.updateProduct(product, id);
    }

}
