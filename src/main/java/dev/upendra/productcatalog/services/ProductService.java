package dev.upendra.productcatalog.services;

import dev.upendra.productcatalog.dtos.GenericProductDto;
import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);
    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();
}
