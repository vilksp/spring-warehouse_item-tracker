package ksp.vilius.Visma.task.service;

import ksp.vilius.Visma.task.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product createProduct(Product product);

    void deleteProduct(Long id);

    Product updateProduct(Product updatedProduct, Long productToBeUpdatedId);

}
