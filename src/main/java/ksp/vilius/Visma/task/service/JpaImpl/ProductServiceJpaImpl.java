package ksp.vilius.Visma.task.service.JpaImpl;

import ksp.vilius.Visma.task.model.Product;
import ksp.vilius.Visma.task.repository.ProductRepository;
import ksp.vilius.Visma.task.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceJpaImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceJpaImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("List of products has been retrieved:");
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {

        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        log.info("New product has been created with name of: " + product.getProductName());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
        log.info("Product has been deleted with id: [" + id + " ]");
    }

    @Override
    public Product updateProduct(Product updatedProduct, Long productToBeUpdatedId) {
        Product productUpdated = productRepository
                .findById(productToBeUpdatedId)
                .orElseThrow(() -> new RuntimeException("No such product with that id"));
        productUpdated.setProductName(updatedProduct.getProductName());
        productUpdated.setProductDescription(updatedProduct.getProductDescription());
        productUpdated.setExpiryDate(updatedProduct.getExpiryDate());
        productUpdated.setQuantity(updatedProduct.getQuantity());
        log.info("The product has been updated successfully");

        return productRepository.save(productUpdated);
    }
}
