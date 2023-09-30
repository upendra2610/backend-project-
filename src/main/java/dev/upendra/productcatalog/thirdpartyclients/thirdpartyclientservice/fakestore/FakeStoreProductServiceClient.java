package dev.upendra.productcatalog.thirdpartyclients.thirdpartyclientservice.fakestore;

import dev.upendra.productcatalog.dtos.GenericProductDto;
import dev.upendra.productcatalog.exceptions.NotFoundExceptions;
import dev.upendra.productcatalog.services.FakeStoreProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class FakeStoreProductServiceClient {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }



    public FakeStoreProductDto getProductById(Long id) throws NotFoundExceptions {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null){
            throw new NotFoundExceptions("Product with id:"+ id + "doesn't exist");
        }


        return fakeStoreProductDto;



    }


    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                productRequestBaseUrl, product, FakeStoreProductDto.class);
        return response.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(
                productRequestBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();


        return Arrays.stream(response.getBody()).toList();

//        return null;
    }

    public FakeStoreProductDto deleteProductById(Long id) {
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

        return fakeStoreProductDto;
    }



    public FakeStoreProductDto updateProduct(Long id, GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();

        //Here we need GenericProduct in return so i edited the postForEntity code from
        //RestTemplate.class to update the product

        RequestCallback requestCallback = restTemplate.httpEntityCallback(
                product, FakeStoreProductService.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(
                specificProductRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return fakeStoreProductDto;
    }
}
