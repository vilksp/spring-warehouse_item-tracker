package ksp.vilius.Visma.task.service;

import ksp.vilius.Visma.task.dto.ProductDto;
import ksp.vilius.Visma.task.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(ProductDto product);

    void deleteProduct(Long id);

    Product updateProduct(ProductDto productDto, Long productToBeUpdatedId);

    List<Product> getProductWithQuantity(int quantity);

    List<Product> getProductUntilExpireDate(LocalDate date);

}
