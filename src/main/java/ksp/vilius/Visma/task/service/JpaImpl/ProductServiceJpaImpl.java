package ksp.vilius.Visma.task.service.JpaImpl;

import ksp.vilius.Visma.task.dto.ProductDto;
import ksp.vilius.Visma.task.exception.ProductException;
import ksp.vilius.Visma.task.model.Product;
import ksp.vilius.Visma.task.repository.ProductRepository;
import ksp.vilius.Visma.task.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setQuantity(productDto.getQuantity());
        product.setExpiryDate(productDto.getExpiryDate());

        log.info("New product has been created with name of: " + product.getProductName());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
        log.info("Product has been deleted with id: [" + id + " ]");
    }

    @Override
    public Product updateProduct(ProductDto productDto, Long productToBeUpdatedId) {
        Product productUpdated = productRepository
                .findById(productToBeUpdatedId)
                .orElseThrow(() -> new ProductException("No such product with that id"));
        productUpdated.setProductName(productDto.getProductName());
        productUpdated.setProductDescription(productDto.getProductDescription());
        productUpdated.setExpiryDate(productDto.getExpiryDate());
        productUpdated.setQuantity(productDto.getQuantity());
        log.info("The product has been updated successfully");

        return productRepository.save(productUpdated);
    }

    @Override
    public List<Product> getProductWithQuantity(int quantity) {
        List<Product> list = new ArrayList<>();

        productRepository.findAll().forEach(prod -> {
            if (prod.getQuantity() < quantity) {
                list.add(prod);
            }
        });
        log.info("Retrieving products with quantity lesser than: " + quantity);
        return list;
    }

    @Override
    public List<Product> getProductUntilExpireDate(LocalDate date) {
        List<Product> list = new ArrayList<>();

        productRepository.findAll().forEach(prod -> {
            if (prod.getExpiryDate().isBefore(date)) {
                list.add(prod);
            }
        });
        log.info("Retrieving products whose expiration date is not equal to: " + date);
        return list;
    }
}
