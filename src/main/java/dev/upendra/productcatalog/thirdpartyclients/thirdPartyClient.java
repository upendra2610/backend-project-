package dev.upendra.productcatalog.thirdpartyclients;

import dev.upendra.productcatalog.dtos.GenericProductDto;
import dev.upendra.productcatalog.exceptions.NotFoundExceptions;
import dev.upendra.productcatalog.thirdpartyclients.thirdpartyclientservice.fakestore.FakeStoreProductDto;

import java.util.List;

public interface thirdPartyClient {
    FakeStoreProductDto getProductById(Long id) throws NotFoundExceptions;
    FakeStoreProductDto createProduct(GenericProductDto product);

    List<FakeStoreProductDto> getAllProducts();

    FakeStoreProductDto deleteProductById(Long id);

    FakeStoreProductDto updateProduct(Long id, GenericProductDto product);
}
