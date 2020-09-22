package ksp.vilius.Visma.task.service;

import ksp.vilius.Visma.task.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product createProduct(Product product);

    void deleteProduct(Long id);

    Product updateProduct(Product updatedProduct, Long productToBeUpdatedId);

}
