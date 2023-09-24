package dev.upendra.productcatalog.services;

import dev.upendra.productcatalog.dtos.FakeStoreProductDto;
import dev.upendra.productcatalog.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.HttpMessageEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.ArrayList;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDto convertFakeStoreToGeneric(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();

        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());


        return product;
    }

    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();


        return convertFakeStoreToGeneric(fakeStoreProductDto);


    }


    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(
                productRequestBaseUrl, product, GenericProductDto.class);
        return response.getBody();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(
                productRequestBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProduct : response.getBody()) {
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

    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //Here there is deleteEntity() method will delete the product but will not return anything but-
        // we need GenericProduct in return according to fakestore delete api-
        //so we copy the getEntity() method internal code from RestTamplate.class and edit http.delete from own
        //so the following code come from there.

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(
                FakeStoreProductDto.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(
                specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return convertFakeStoreToGeneric(fakeStoreProductDto);
    }



    public GenericProductDto updateProduct(Long id, GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();

        //Here we need GenericProduct in return so i edited the postForEntity code from
        //RestTemplate.class to update the product

        RequestCallback requestCallback = restTemplate.httpEntityCallback(
                product, FakeStoreProductService.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(
                specificProductRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return convertFakeStoreToGeneric(fakeStoreProductDto);
    }
}





