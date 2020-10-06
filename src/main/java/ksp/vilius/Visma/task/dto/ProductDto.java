package ksp.vilius.Visma.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProductDto {

    private String productName;
    private String productDescription;
    private LocalDate expiryDate;
    private int quantity;
}
