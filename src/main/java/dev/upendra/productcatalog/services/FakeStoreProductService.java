package dev.upendra.productcatalog.services;

import dev.upendra.productcatalog.dtos.FakeStoreProductDto;
import dev.upendra.productcatalog.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto getProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto product = new GenericProductDto();

        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;


    }


    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(
                createProductUrl, product, GenericProductDto.class);
        return response.getBody();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(
                createProductUrl, FakeStoreProductDto[].class);
        
        List<GenericProductDto> answer = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProduct: response.getBody()) {
            GenericProductDto product = new GenericProductDto();
            product.setImage(fakeStoreProduct.getImage());
            product.setPrice(fakeStoreProduct.getPrice());
            product.setDescription(fakeStoreProduct.getDescription());
            product.setCategory(fakeStoreProduct.getCategory());
            product.setTitle(fakeStoreProduct.getTitle());

            answer.add(product);
        }
        return answer;
        
//        return null;
    }
}
