package ksp.vilius.Visma.task.controller;

import ksp.vilius.Visma.task.dto.ProductDto;
import ksp.vilius.Visma.task.model.Product;
import ksp.vilius.Visma.task.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public Product getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDto productDto) {

        return productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProject(@PathVariable Long id, @RequestBody ProductDto productDto) {

        return productService.updateProduct(productDto, id);
    }

    @GetMapping("/quantity/{quantity}")
    public List<Product> getProductsWithCertainQuantity(@PathVariable int quantity) {

        return productService.getProductWithQuantity(quantity);
    }

    @GetMapping("/expiration/{date}")
    public List<Product> getProductUntilExpireDate(@PathVariable String date) {
        LocalDate dateParse = LocalDate.parse(date);
        return productService.getProductUntilExpireDate(dateParse);
    }

}
