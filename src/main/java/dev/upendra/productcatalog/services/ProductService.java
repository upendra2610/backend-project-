package dev.upendra.productcatalog.services;

import dev.upendra.productcatalog.dtos.GenericProductDto;
import dev.upendra.productcatalog.exceptions.NotFoundExceptions;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundExceptions;
    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProduct(Long id, GenericProductDto product);
}
