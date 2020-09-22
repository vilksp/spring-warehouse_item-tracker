package ksp.vilius.Visma.task.controller;

import ksp.vilius.Visma.task.model.Product;
import ksp.vilius.Visma.task.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> pList = productService.getAllProducts();
        return pList;
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProject(@PathVariable Long id, @RequestBody Product product) {

        return productService.updateProduct(product, id);
    }

}
